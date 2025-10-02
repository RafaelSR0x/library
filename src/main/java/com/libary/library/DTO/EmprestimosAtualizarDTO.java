package com.libary.library.DTO;

import com.libary.library.entities.Emprestimos;

import java.time.LocalDateTime;

public class EmprestimosAtualizarDTO {

    LivrosDTO livrosDTO;
    private String leitor;
    private LocalDateTime dataDevolucao;


    public EmprestimosAtualizarDTO() {
    }

    public EmprestimosAtualizarDTO(Emprestimos emprestimos) {
        this.livrosDTO = new LivrosDTO(emprestimos.getLivro());
        this.leitor = emprestimos.getLeitor();
        this.dataDevolucao = emprestimos.getDataDevolucao();
    }

    public LivrosDTO getLivrosDTO() {
        return livrosDTO;
    }

    public void setLivrosDTO(LivrosDTO livrosDTO) {
        this.livrosDTO = livrosDTO;
    }

    public String getLeitor() {
        return leitor;
    }

    public void setLeitor(String leitor) {
        this.leitor = leitor;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
