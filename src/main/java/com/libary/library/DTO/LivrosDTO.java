package com.libary.library.DTO;

import com.libary.library.entities.Livros;

public class LivrosDTO {

    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private Integer anoPublicacao;
    private Livros.StatusLivro status;

    public LivrosDTO(Livros livros) {
        titulo = livros.getTitulo();
        autor = livros.getAutor();
        genero = livros.getGenero();
        isbn = livros.getIsbn();
        anoPublicacao = livros.getAnoPublicacao();
        status = livros.getStatus();
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

    public Livros.StatusLivro getStatus() {
        return status;
    }

    public void setStatus(Livros.StatusLivro status) {
        this.status = status;
    }
}
