package br.insper.biblioteca;

import java.util.ArrayList;

public class Livro {
    private String nome;
    private String  autor;
    private Boolean disponivel;
    private Biblioteca biblioteca;

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void adicionaReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void adicionaEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
