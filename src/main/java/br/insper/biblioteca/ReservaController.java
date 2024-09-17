package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservaController {

        @Autowired
        private ReservaService reservaService;

        @PostMapping("/reserva")
        @ResponseStatus(HttpStatus.CREATED)
        public String postReserva(@RequestBody Reserva reserva) {
            reservaService.(reserva);
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
