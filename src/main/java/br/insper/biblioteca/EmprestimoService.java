package br.insper.biblioteca;

import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class EmprestimoService {

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarEmprestimo(Emprestimo emprestimo) {

        emprestimo.getUsuario().adicionaEmprestimo(emprestimo);
        emprestimo.getLivro().adicionaEmprestimo(emprestimo);
        emprestimo.getLivro().setDisponivel(false);
        emprestimos.add(emprestimo);
    }

    public ArrayList<Emprestimo> listarEmprestimo() {
        return emprestimos;
    }

    public void excluirEmprestimo(String codigo) {
        emprestimos
                .removeIf(emprestimo -> emprestimo.getCodigo().equals(codigo));
    }
}
