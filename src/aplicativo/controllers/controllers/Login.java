package controllers;

import java.util.Scanner;
import aplicativo.models.pessoas.Usuario;

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
	        Usuario usuarioAutenticado = autenticarUsuario(email, senha);
	
	        if (usuarioAutenticado != null) {
	            System.out.println("Login bem-sucedido. Bem-vindo, " + usuarioAutenticado.getNome() + "!");
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
    private static Usuario autenticarUsuario(String email, String senha) {
        // Obtém a lista de usuários do cadastro
        for (Usuario usuario : CadastroUsuario.getUsuarios()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario; // Usuário autenticado
            }
        }
        return null; // Usuário não encontrado
    }
}
