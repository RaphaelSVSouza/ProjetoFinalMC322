package controllers;

import java.util.ArrayList;
import java.util.List;
import aplicativo.models.pessoas.Usuario;

public class CadastroUsuario {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void cadastrarUsuario(String nome, String email, String senha) {
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
}