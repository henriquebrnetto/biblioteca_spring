package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BibliotecaService {

  /*  private BibliotecaService() {
    }

    private static BibliotecaService bibliotecaService = null;

    public static BibliotecaService getInstance() {
        if (bibliotecaService == null) {
            bibliotecaService = new BibliotecaService();
        }
        return bibliotecaService;
    }*/

    private ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
    public void cadastrarBiblioteca(Biblioteca biblioteca) {
        bibliotecas.add(biblioteca);
    }

    public ArrayList<Biblioteca> listarBibliotecas(String nome) {
        if (nome != null) {
            ArrayList<Biblioteca> retorno = new ArrayList<>();
            for (Biblioteca biblioteca : bibliotecas) {
                if (biblioteca.getNome().startsWith(nome)) {
                    retorno.add(biblioteca);
                }
            }
            return retorno;
        }
        return bibliotecas;
    }

    public Biblioteca buscarBiblioteca(String nomeBiblioteca) {

       // return bibliotecas
       //         .stream()
       //         .filter(b -> b.getNome().equals(nomeBiblioteca))
       //         .findFirst()
       //         .get();

        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getNome().equals(nomeBiblioteca)) {
                return biblioteca;
            }
        }
        return null;
    }

    public void excluirBiblioteca(String nome) {
        bibliotecas
                .removeIf(biblioteca -> biblioteca.getNome().equals(nome));
    }
}
