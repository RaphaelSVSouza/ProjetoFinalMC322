package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicativo.models.pessoas.Usuario;
	
public class CadastroUsuario {
		private static List<Usuario> usuarios = new ArrayList<>();
    	public static void cadastrarUsuario() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Criando nova conta. Por favor, forneça as informações necessárias:");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            // Cria um novo usuário
            Usuario novoUsuario = new Usuario(nome, email, senha);

            // Adiciona o usuário à lista de usuários
            usuarios.add(novoUsuario);

            System.out.println("Cadastro realizado com sucesso!");
        }

        public static List<Usuario> getUsuarios() {
            return usuarios;
        }
    }