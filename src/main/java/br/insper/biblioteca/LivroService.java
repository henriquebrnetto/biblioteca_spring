package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LivroService {

    private ArrayList<Livro> livros =  new ArrayList<>();

    public void cadastrarLivro(Livro livro) {

        livros.add(livro);
        livro.getBiblioteca().adicionaLivro(livro);
    }

    public ArrayList<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarLivro(String nomeLivro) {

        for (Livro livro : livros) {
            if (livro.getNome().equals(nomeLivro)) {
                return livro;
            }
        }
        return null;
    }

    public void excluirLivro(String nome) {
        livros
                .removeIf(livro -> livro.getNome().equals(nome));
    }


}
