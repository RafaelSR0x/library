package com.libary.library.service;

import com.libary.library.DTO.LivrosDTO;
import com.libary.library.entities.Livros;
import com.libary.library.repositories.LivrosRepository;
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

}
