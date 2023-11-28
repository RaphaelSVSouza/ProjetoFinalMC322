package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicativo.models.pessoas.Usuario;
import aplicativo.models.utils.ColecoesPacotes;
import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.pacotes.PacoteCompleto;
import aplicativo.models.pessoas.Administrador;
import controllers.Login;
	
public class CadastroUsuario {
    private static List<Pessoa> pessoas = new ArrayList<>();
    ColecoesPacotes<PacoteCompleto> servicoPacotes;

    static {
        // Administradores ja cadastrados no sistema
        Administrador admin1 = new Administrador("Admin1", "admin1@example.com", "admin123", "Gerente");
        Administrador admin2 = new Administrador("Admin2", "admin2@example.com", "admin456", "Supervisor");

        pessoas.add(admin1);
        pessoas.add(admin2);
    }

    public static void cadastrarUsuario(ColecoesPacotes<PacoteCompleto> servicoPacotes) {
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
        pessoas.add(novoUsuario);

        System.out.println("Cadastro realizado com sucesso!");


        Login.realizarLogin(servicoPacotes);
    }

    public static List<Pessoa> getUsers() {
        return pessoas;
    }
}