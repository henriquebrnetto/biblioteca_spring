package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LivroService {

    private ArrayList<Livro> livros =  new ArrayList<>();

    public void cadastrarLivro(String nome, String autor, Boolean disponivel,
                               Biblioteca biblioteca) {

        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setAutor(autor);
        livro.setDisponivel(disponivel);
        livro.setBiblioteca(biblioteca);

        livros.add(livro);
        biblioteca.adicionaLivro(livro);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Biblioteca: " + livro.getBiblioteca().getNome());
            System.out.println("Emprestimos: " + livro.getEmprestimos());
            System.out.println("Reservas: " + livro.getReservas());
        }
    }

    public Livro buscarLivro(String nomeLivro) {

        // return livros
        //         .stream()
        //         .filter(b -> b.getNome().equals(nomeLivro))
        //         .findFirst()
        //         .get();

        for (Livro livro : livros) {
            if (livro.getNome().equals(nomeLivro)) {
                return livro;
            }
        }
        return null;
    }

}
