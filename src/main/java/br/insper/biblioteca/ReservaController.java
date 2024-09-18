package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservaController {

        @Autowired
        private ReservaService reservaService;

        @Autowired
        private UsuarioService usuarioService;

        @Autowired
        private LivroService livroService;

        @PostMapping("/reserva")
        @ResponseStatus(HttpStatus.CREATED)
        public String postReserva(@RequestBody Reserva reserva) {

            Livro livro = livroService
                    .buscarLivro(reserva.getLivro().getNome());

            Usuario usuario = usuarioService
                    .buscarUsuario(reserva.getUsuario().getNome());

            if (livro == null) {
                return "Livro nao cadastrado";
            }

            if (usuario == null) {
                return "Usuário nao cadastrado";
            }

            reserva.setUsuario(usuario);
            reserva.setLivro(livro);
            usuario.adicionaReserva(reserva);
            livro.adicionaReserva(reserva);

            reservaService.cadastrarReserva(reserva);
            return "Reserva cadastrada com sucesso";
        }

        @GetMapping("/reserva")
        public ArrayList<Reserva> listaReservas() {
            return reservaService.listarReserva();
        }

        @DeleteMapping("/reserva/{codigo}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void excluirBiblioteca(@PathVariable String codigo) {

            reservaService.excluirReserva(codigo);
        }

}
