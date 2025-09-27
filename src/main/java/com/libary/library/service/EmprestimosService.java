package com.libary.library.service;

import com.libary.library.entities.Emprestimos;
import com.libary.library.entities.Livros;
import com.libary.library.repositories.EmprestimosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmprestimosService {

    @Autowired
    private EmprestimosRepository repository;

    public record EmprestimoDTO(Long id, Long livroId, String leitor, String status) {}

    public EmprestimoDTO createLoans(Emprestimos request) {

        request.setStatusEmprestimo(Emprestimos.StatusEmprestimo.ATIVO);
        request.setDataEmprestimo(LocalDateTime.now());

        Emprestimos emprestimos =  repository.save(request);

        return new EmprestimoDTO(
                emprestimos.getId(),
                emprestimos.getLivro().getId(),
                emprestimos.getLeitor(),
                emprestimos.getStatusEmprestimo().name()
        );
    }
}
