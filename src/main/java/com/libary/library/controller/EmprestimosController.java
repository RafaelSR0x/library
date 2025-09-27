package com.libary.library.controller;

import com.libary.library.entities.Emprestimos;
import com.libary.library.service.EmprestimosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimosController {

    @Autowired
    private EmprestimosService emprestimosService;

    @PostMapping
    public ResponseEntity<EmprestimosService.EmprestimoDTO> loansBook(@RequestBody Emprestimos emprestimos) {
        EmprestimosService.EmprestimoDTO dto = emprestimosService.createLoans(emprestimos);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
