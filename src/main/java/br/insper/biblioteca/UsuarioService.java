package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    private ArrayList<Usuario> usuarios =  new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        //biblioteca.getUsuarios().add(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Biblioteca: " + usuario.getBiblioteca().getNome());
        }
    }

}
