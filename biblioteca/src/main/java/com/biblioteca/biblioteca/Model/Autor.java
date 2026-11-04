package com.biblioteca.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String Nome;
    private List<Livro> Livros = new ArrayList<>();

    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public List<Livro> getLivros() {
        return Livros;
    }
    public void setLivros(List<Livro> Livros) {
        this.Livros = Livros;
    }
}