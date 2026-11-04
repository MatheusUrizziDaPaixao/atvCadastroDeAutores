
package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "Livros/form";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/Livros";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "Livros/lista";
    }

    @GetMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/Livros";
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