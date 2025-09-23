package com.libary.library.service;

import com.libary.library.DTO.LivrosDTO;
import com.libary.library.entities.Livros;
import com.libary.library.repositories.LivrosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public Livros create(Livros request) {

        request.setStatus(Livros.StatusLivro.DISPONIVEL);

        return livrosRepository.save(request);
    }

    @Transactional
    public List<LivrosDTO> findAll() {
        return livrosRepository.findAll().stream().map(LivrosDTO::new).toList();
    }

    public LivrosDTO findById(Long id) {
        Livros livros = livrosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        return new LivrosDTO(livros);
    }

    public Livros update(Long id, Livros request){
        Livros livros = livrosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        livros.setTitulo(request.getTitulo());
        livros.setAutor(request.getAutor());
        livros.setGenero(request.getGenero());
        livros.setIsbn(request.getIsbn());
        livros.setAnoPublicacao(request.getAnoPublicacao());

        return livrosRepository.save(livros);
    }

    public void delete(Long id){
        Livros livros = livrosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        livrosRepository.delete(livros);
    }
}
