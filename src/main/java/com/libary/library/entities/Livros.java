package com.libary.library.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private Integer anoPublicacao;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimos> emprestimos;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    public enum StatusLivro {
        DISPONIVEL, EMPRESTADO
    }

    public Livros() {
    }

    public Livros(Long id, String titulo, String autor, String genero, String isbn, Integer anoPublicacao, List<Emprestimos> emprestimos, StatusLivro status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.emprestimos = emprestimos;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public List<Emprestimos> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimos> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }
}
