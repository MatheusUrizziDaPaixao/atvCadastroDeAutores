
package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.Model.Autor;
import com.biblioteca.biblioteca.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Autores")
public class AutorController {

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        Autor autor = new Autor();
        autor.getLivros().add(new Livro());
        autor.getLivros().add(new Livro());
        autor.getLivros().add(new Livro());

        model.addAttribute("autor", autor);
        return "Autores/form";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor, Model model) {

        List<Livro> livros = new ArrayList<>();
        for (Livro livro : autor.getLivros()) {
            if (livro.getTitulo() != null && !livro.getTitulo().isBlank()) {
                livro.setAutor(autor.getNome());
                livros.add(livro);
            }
        }
        autor.setLivros(livros);

        model.addAttribute("autor", autor);
        return "Autores/confirmacao";
    }
}