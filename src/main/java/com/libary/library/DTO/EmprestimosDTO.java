package com.libary.library.DTO;

import com.libary.library.entities.Emprestimos;
import com.libary.library.DTO.LivrosDTO;

import java.time.LocalDateTime;

public class EmprestimosDTO {

    LivrosDTO livrosDTO;
    private String leitor;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private Emprestimos.StatusEmprestimo statusEmprestimo;

    public EmprestimosDTO() {
    }

    public EmprestimosDTO(Emprestimos emprestimos) {
        this.livrosDTO = new LivrosDTO(emprestimos.getLivro());
        this.leitor = emprestimos.getLeitor();
        this.dataEmprestimo = emprestimos.getDataEmprestimo();
        this.dataDevolucao = emprestimos.getDataDevolucao();
        this.statusEmprestimo = emprestimos.getStatusEmprestimo();
    }


    public LivrosDTO getLivros() {
        return livrosDTO;
    }

    public void setLivros(LivrosDTO livros) {
        this.livrosDTO = livros;
    }

    public String getLeitor() {
        return leitor;
    }

    public void setLeitor(String leitor) {
        this.leitor = leitor;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimos.StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(Emprestimos.StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }
}
