package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private BibliotecaService bibliotecaService;


    @PostMapping("/livro")
    @ResponseStatus(HttpStatus.CREATED)
    public String postBiblioteca(@RequestBody Livro livro) {

        Biblioteca biblioteca = bibliotecaService
                .buscarBiblioteca(livro.getBiblioteca().getNome());

        if (biblioteca == null) {
            return "Biblioteca nao cadastrada";
        }

        livro.setBiblioteca(biblioteca);
        biblioteca.adicionaLivro(livro);

        livroService.cadastrarLivro(livro);
        return "Biblioteca cadastrada com sucesso";
    }

    @GetMapping("/livro")
    public ArrayList<Livro> listaBibliotecas() {
        return livroService.listarLivros();
    }

    @DeleteMapping("/livro/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirLivro(@PathVariable String nome) {

        livroService.excluirLivro(nome);
    }

}
