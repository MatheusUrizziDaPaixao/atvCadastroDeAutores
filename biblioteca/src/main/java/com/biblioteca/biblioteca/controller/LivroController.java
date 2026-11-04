
package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Livros")
public class LivroController {

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "Livros/form";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model) {

        model.addAttribute("livro", livro);
        return "Livros/confirmacao";
    }

    @GetMapping
    public String inicio(Model model) {
        return "Livros/inicio";
    }

    @GetMapping("/Livro")
    public String exibirLivro(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("JoJo's Bizarre Adventure");
        livro.setAutor("Hirohiko Araki");
        livro.setISBN("978-85-00-00000-0");

        model.addAttribute("Livro", livro);
        return "livro";
    }
}