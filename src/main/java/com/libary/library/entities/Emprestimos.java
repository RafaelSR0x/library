package com.libary.library.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Emprestimos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "livros_id")
    @JsonBackReference
    private Livros livro;

    @Column(nullable = false)
    private String leitor;

    @Column(nullable = false)
    private LocalDateTime dataEmprestimo;

    @Column(nullable = false)
    private LocalDateTime dataDevolucao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo statusEmprestimo;

    public enum StatusEmprestimo{
        ATIVO, FINALIZADO
    }

    public Emprestimos() {
    }

    public Emprestimos(Long id, Livros livro, String leitor, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, StatusEmprestimo statusEmprestimo) {
        this.id = id;
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.statusEmprestimo = statusEmprestimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
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

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }
}
