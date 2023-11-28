package controllers;

import java.util.Scanner;
import aplicativo.models.pessoas.Usuario;
import aplicativo.models.pessoas.Administrador;
import aplicativo.models.pessoas.Pessoa;


public class Login {
	
    public static void realizarLogin() {
    	Scanner scanner = new Scanner(System.in);
    	while (true) {
	        System.out.println("Bem-vindo! Por favor, faça login:");
	
	        //informações de login do usuário
	        System.out.print("Email: ");
	        String email = scanner.nextLine();
	
	        System.out.print("Senha: ");
	        String senha = scanner.nextLine();
	
	        // Tenta autenticar o usuário
	        Pessoa usuarioAutenticado = autenticarUsuario(email, senha);
			
	        if (usuarioAutenticado != null) {

				if (usuarioAutenticado instanceof Administrador) {
					Administrador admin = (Administrador) usuarioAutenticado;
					String nomeAdmin = admin.getNome();
					System.out.println("Login bem-sucedido. Bem-vindo, Adminitrador:" + nomeAdmin);
				} else {
					System.out.println("Login bem-sucedido. Bem-vindo, " + usuarioAutenticado.getNome() + "!");
				}

				break;
	        } else {
	            System.out.println("Usuário não encontrado. Deseja criar uma nova conta? (sim/não)");
	            String resposta = scanner.nextLine();
	
	            if (resposta.equalsIgnoreCase("sim")) {
	                // Realiza o cadastro usando a classe CadastrarUsuario
	                CadastroUsuario.cadastrarUsuario();
	            } else {
	                System.out.println("Obrigado. Até mais!");
	            }
	        }
	        
	    }
    	scanner.close();
    }
    
    // Método para autenticar o usuário
    private static Pessoa autenticarUsuario(String email, String senha) {
        // Obtém a lista de usuários do cadastro
        for (Pessoa user : CadastroUsuario.getUsers()) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return user; // Usuário autenticado
            }
        }
        return null; // Usuário não encontrado
    }
}