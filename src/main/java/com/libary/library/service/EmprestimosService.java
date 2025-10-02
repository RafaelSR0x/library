package com.libary.library.service;

import com.libary.library.DTO.EmprestimosDTO;
import com.libary.library.entities.Emprestimos;
import com.libary.library.entities.Livros;
import com.libary.library.repositories.EmprestimosRepository;
import com.libary.library.repositories.LivrosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmprestimosService {

    @Autowired
    private EmprestimosRepository emprestimosRepository;
    @Autowired
    private LivrosRepository livrosRepository;

    public record EmprestimoDTO(Long id, Long livroId, String leitor, String status) {}

    public EmprestimoDTO createLoans(Emprestimos request) {

        Livros livro =livrosRepository.findById(request.getLivro().getId())
                        .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));


       if (livro.getStatus() == Livros.StatusLivro.DISPONIVEL){
           livro.setStatus(Livros.StatusLivro.EMPRESTADO);
           livrosRepository.save(livro);
       }else {
           throw new IllegalArgumentException("Livro já está emprestado e não pode ser emprestado novamente!");
       }

       request.setLivro(livro);
       request.setStatusEmprestimo(Emprestimos.StatusEmprestimo.ATIVO);
       request.setDataEmprestimo(LocalDateTime.now());


        Emprestimos emprestimos =  emprestimosRepository.save(request);

        return new EmprestimoDTO(
                emprestimos.getId(),
                emprestimos.getLivro().getId(),
                emprestimos.getLeitor(),
                emprestimos.getStatusEmprestimo().name()
        );
    }

    public List<EmprestimosDTO> findAll() {
        return emprestimosRepository.findAll().stream().map(EmprestimosDTO::new).toList();
    }

    public List<EmprestimosDTO> findById(Long id) {
        return emprestimosRepository.findById(id).stream().map(EmprestimosDTO::new).toList();
    }

    public Emprestimos updateLoans(Long id, Emprestimos emprestimos) {
        Emprestimos bucarEmprestimos = emprestimosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emprestimo não encontrado"));

        bucarEmprestimos.setLivro(emprestimos.getLivro());
        bucarEmprestimos.setLeitor(emprestimos.getLeitor());
        bucarEmprestimos.setDataDevolucao(emprestimos.getDataDevolucao());

        return emprestimosRepository.save(bucarEmprestimos);
    }

    public Emprestimos returnLoans(Long id) {
        Emprestimos emprestimos = emprestimosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emprestimo não encontrado"));

        Livros livro = emprestimos.getLivro();

        livro.setStatus(Livros.StatusLivro.DISPONIVEL);
        emprestimos.setDataDevolucao(LocalDateTime.now());
        emprestimos.setStatusEmprestimo(Emprestimos.StatusEmprestimo.FINALIZADO);

        livrosRepository.save(livro);
        return emprestimosRepository.save(emprestimos);
    }
}
