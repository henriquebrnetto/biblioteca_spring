package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ReservaService {

    private ArrayList<Reserva> reservas =  new ArrayList<>();

    public void cadastrarReserva(Reserva reserva) {

        reservas.add(reserva);
        reserva.getUsuario().adicionaReserva(reserva);
        reserva.getLivro().adicionaReserva(reserva);

    }

    public ArrayList<Reserva> listarReserva() {
        return reservas;
        }

    public void excluirReserva(String codigo) {
        reservas
                .removeIf(biblioteca -> biblioteca.getCodigo().equals(codigo));
    }

}
