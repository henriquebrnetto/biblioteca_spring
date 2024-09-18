package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    private ArrayList<Usuario> usuarios =  new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {

        usuarios.add(usuario);
        usuario.getBiblioteca().getUsuarios().add(usuario);
    }

    public ArrayList<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(String nomeUsuario) {

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void excluirUsuario(String nome) {
        usuarios
                .removeIf(usuario -> usuario.getNome().equals(nome));
    }

}
