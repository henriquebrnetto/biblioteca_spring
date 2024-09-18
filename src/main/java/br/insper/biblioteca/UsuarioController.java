package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String postUsuario(@RequestBody Usuario usuario) {

        Biblioteca biblioteca = bibliotecaService
                .buscarBiblioteca(usuario.getBiblioteca().getNome());

        if (biblioteca == null) {
            return "Biblioteca nao cadastrada";
        }

        usuario.setBiblioteca(biblioteca);
        biblioteca.adicionaUsuario(usuario);

        usuarioService.cadastrarUsuario(usuario);
        return "Usuário cadastrado com sucesso";
    }

    @GetMapping("/usuario")
    public ArrayList<Usuario> listaUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/usuario/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable String nome) {

        usuarioService.excluirUsuario(nome);
    }

}
