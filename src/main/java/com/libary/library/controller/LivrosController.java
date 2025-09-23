package com.libary.library.controller;

import com.libary.library.DTO.LivrosDTO;
import com.libary.library.entities.Livros;
import com.libary.library.service.LivrosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @PostMapping
    public ResponseEntity<Livros> create(@Valid @RequestBody Livros livros) {
            return ResponseEntity.status(HttpStatus.CREATED).body(livrosService.create(livros));
    }

    @GetMapping
    public ResponseEntity listBooks(){
        List<LivrosDTO> livrosDTOS = livrosService.findAll();

        if (livrosDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(livrosDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(livrosService.findById(id));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }
}
