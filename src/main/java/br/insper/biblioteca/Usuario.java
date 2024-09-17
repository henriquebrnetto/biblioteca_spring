package br.insper.biblioteca;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String endereco;
    private String email;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
