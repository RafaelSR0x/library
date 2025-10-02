package com.libary.library.controller;

import com.libary.library.DTO.EmprestimosAtualizarDTO;
import com.libary.library.DTO.EmprestimosDTO;
import com.libary.library.entities.Emprestimos;
import com.libary.library.service.EmprestimosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Past;
import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity buscarEmprestimos() {

        List<EmprestimosDTO> emprestimosDTOS = emprestimosService.findAll();

        if (emprestimosDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(emprestimosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity bucarEmprestimoId(@PathVariable Long id) {
        List<EmprestimosDTO> emprestimosDTOS = emprestimosService.findById(id);
        if (emprestimosDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(emprestimosService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimos emprestimos) {
        try {
            return ResponseEntity.ok(emprestimosService.updateLoans(id, emprestimos));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity devolverEmprestimo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(emprestimosService.returnLoans(id));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }
}
