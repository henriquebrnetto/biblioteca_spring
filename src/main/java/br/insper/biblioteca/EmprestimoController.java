package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    @PostMapping("/emprestimo")
    @ResponseStatus(HttpStatus.CREATED)
    public String postEmprestimo(@RequestBody Emprestimo emprestimo) {

        Livro livro = livroService
                .buscarLivro(emprestimo.getLivro().getNome());

        Usuario usuario = usuarioService
                .buscarUsuario(emprestimo.getUsuario().getNome());

        if (livro == null) {
            return "Livro nao cadastrado";
        }

        if (usuario == null) {
            return "Usuário nao cadastrado";
        }

        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        usuario.adicionaEmprestimo(emprestimo);
        livro.adicionaEmprestimo(emprestimo);

        emprestimoService.cadastrarEmprestimo(emprestimo);
        return "Emprestimo cadastrado com sucesso";
    }

    @GetMapping("/emprestimo")
    public ArrayList<Emprestimo> listaEmprestimo() {
        return emprestimoService.listarEmprestimo();
    }

    @DeleteMapping("/emprestimo/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEmprestimo(@PathVariable String codigo) {
        emprestimoService.excluirEmprestimo(codigo);
    }

}
