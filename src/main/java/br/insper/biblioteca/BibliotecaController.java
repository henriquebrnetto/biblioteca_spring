package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/biblioteca")
    @ResponseStatus(HttpStatus.CREATED)
    public String postBiblioteca(@RequestBody Biblioteca biblioteca) {
        bibliotecaService.cadastrarBiblioteca(biblioteca);
        return "Biblioteca cadastrada com sucesso";
    }

    @GetMapping("/biblioteca")
    public ArrayList<Biblioteca> listaBibliotecas(
            @RequestParam(required = false) String nome) {
        return bibliotecaService.listarBibliotecas(nome);
    }

    @DeleteMapping("/biblioteca/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirBiblioteca(@PathVariable String nome) {
        bibliotecaService.excluirBiblioteca(nome);
    }

}
