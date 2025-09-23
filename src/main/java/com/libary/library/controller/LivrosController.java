package com.libary.library.controller;

import com.libary.library.entities.Livros;
import com.libary.library.service.LivrosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @PostMapping
    public ResponseEntity<Livros> create(@Valid @RequestBody Livros livros) {
            return ResponseEntity.status(HttpStatus.CREATED).body(livrosService.create(livros));
    }
}
