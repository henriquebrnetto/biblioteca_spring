package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarUsuario(@RequestBody Usuario usuario) {

        Biblioteca biblioteca = bibliotecaService
                .buscarBiblioteca(usuario.getBiblioteca().getNome());

        if (biblioteca == null) {
            return "Biblioteca nao cadastrada";
        }

        usuario.setBiblioteca(biblioteca);
        biblioteca.getUsuarios().add(usuario);

        usuarioService.cadastrarUsuario(usuario);
        return "Usuário cadastrado com sucesso";
    }

}
