package br.insper.biblioteca;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String endereco;
    @JsonIgnore
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();

    public void adicionaUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }


    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
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
}
