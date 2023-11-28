package controllers;

import java.util.List;
import java.util.Scanner;
import aplicativo.models.pessoas.Usuario;
import aplicativo.models.utils.ColecoesPacotes;
import aplicativo.models.pacotes.CategoriaPacote;
import aplicativo.models.pacotes.Pacote;
import aplicativo.models.pacotes.PacoteCompleto;
import aplicativo.models.pessoas.Administrador;
import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.destino.Lugar;
import java.time.LocalDate;

public class Login {
	private static ColecoesPacotes<PacoteCompleto> servicoPacotes;
	
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
					System.out.println(nomeAdmin + "deseja realizar qual operação com base nos dados cadastrados? (criar pacote/remover pacote)");
					String operacao = scanner.nextLine();
					
					if (operacao.equalsIgnoreCase("criar pacote")) {
						// função de ver todos os parametros (estadia, lugar, categoria do pacote)
					}



				} else { // usuario foi autenticado como Usuario
					System.out.println("Login bem-sucedido. Bem-vindo usuário " + usuarioAutenticado.getNome() + "!");
					System.out.println("Digite 1 para filtrar os pacotes por preço.");
					System.out.println("Digite 2 para filtrar os pacotes por categoria.");
					System.out.println("Digite 3 para filtrar os pacotes por destino");
					System.out.println("Digite 4 para filtrar os pacotes por data de partida.");
					System.out.println("Digite 5 para sair.");

					String acao = scanner.nextLine();

					if (acao.equalsIgnoreCase("1")) {
						System.out.println("Digite o preço máximo em R$: (int preço)");
						int precoMax = scanner.nextInt();
						scanner.nextLine();
	
						List<PacoteCompleto> pacotesPorPreco = servicoPacotes.listarPorPreco(precoMax);
						System.out.println("Pacotes por preço:");

						int contador = 1;
						for (PacoteCompleto pacote : pacotesPorPreco) {
							System.out.println("Pacote " + contador + ": Destino: " + pacote.getLugar().getNomeDestino() + ", Estadia: " + pacote.getEstadia() +
												", Categoria: " + pacote.getCategoria() + ", Data de Ida: " + 
												pacote.getDataIda() + ", Preço: R$" + pacote.getValorTotal());
							contador++;
						}
						
						// Solicitar ao usuário que selecione um pacote para reservar
						System.out.println("Digite o número do pacote que deseja reservar:");
						int numeroPacote = scanner.nextInt();
						scanner.nextLine(); // Limpar a quebra de linha
						
						// Verificar se o número fornecido é válido
						if (numeroPacote > 0 && numeroPacote <= pacotesPorPreco.size()) {
							// Obter o pacote selecionado pelo usuário
							PacoteCompleto pacoteSelecionado = pacotesPorPreco.get(numeroPacote - 1); // -1 porque os índices começam em 0
						
							// Realizar a reserva do pacote
							Reserva.realizarReserva(usuarioAutenticado, pacoteSelecionado, servicoPacotes);
						} else {
							System.out.println("Número do pacote inválido!");
						}
						
					} else if (acao.equalsIgnoreCase("2")) {

						System.out.println("Digite a preço categoria: ");
						String categoriaDigitada = scanner.nextLine();

						CategoriaPacote categoriaDesejada = CategoriaPacote.valueOf(categoriaDigitada.toUpperCase());
	
						List<PacoteCompleto> pacotesPorCategoria = servicoPacotes.listarPorCategoria(categoriaDesejada);
						System.out.println("Pacotes por categoria:");

						int contador = 1;
						for (PacoteCompleto pacote : pacotesPorCategoria) {
							System.out.println("Pacote " + contador + ": Destino: " + pacote.getLugar().getNomeDestino() + ", Estadia: " + pacote.getEstadia() +
												", Categoria: " + pacote.getCategoria() + ", Data de Ida: " + 
												pacote.getDataIda() + ", Preço: R$" + pacote.getValorTotal());
							contador++;
						}
						
						// Solicitar ao usuário que selecione um pacote para reservar
						System.out.println("Digite o número do pacote que deseja reservar:");
						int numeroPacote = scanner.nextInt();
						scanner.nextLine(); // Limpar a quebra de linha
						
						// Verificar se o número fornecido é válido
						if (numeroPacote > 0 && numeroPacote <= pacotesPorCategoria.size()) {
							// Obter o pacote selecionado pelo usuário
							PacoteCompleto pacoteSelecionado = pacotesPorCategoria.get(numeroPacote - 1); // -1 porque os índices começam em 0
						
							// Realizar a reserva do pacote
							Reserva.realizarReserva(usuarioAutenticado, pacoteSelecionado, servicoPacotes);
						} else {
							System.out.println("Número do pacote inválido!");
						}

					} else if (acao.equalsIgnoreCase("3")) {

						System.out.println("Digite o destino desejado: ");
						String destino = scanner.nextLine();
						Lugar lugarDesejado = new Lugar();
						lugarDesejado.setNomeDestino(destino);
	
						List<PacoteCompleto> pacotesPorDestino = servicoPacotes.listarPorLocal(lugarDesejado);
						System.out.println("Pacotes por preço:");

						int contador = 1;
						for (PacoteCompleto pacote : pacotesPorDestino) {
							System.out.println("Pacote " + contador + ": Destino: " + pacote.getLugar().getNomeDestino() + ", Estadia: " + pacote.getEstadia() +
												", Categoria: " + pacote.getCategoria() + ", Data de Ida: " + 
												pacote.getDataIda() + ", Preço: R$" + pacote.getValorTotal());
							contador++;
						}
						
						// Solicitar ao usuário que selecione um pacote para reservar
						System.out.println("Digite o número do pacote que deseja reservar:");
						int numeroPacote = scanner.nextInt();
						scanner.nextLine(); // Limpar a quebra de linha
						
						// Verificar se o número fornecido é válido
						if (numeroPacote > 0 && numeroPacote <= pacotesPorDestino.size()) {
							// Obter o pacote selecionado pelo usuário
							PacoteCompleto pacoteSelecionado = pacotesPorDestino.get(numeroPacote - 1); // -1 porque os índices começam em 0
						
							// Realizar a reserva do pacote
							Reserva.realizarReserva(usuarioAutenticado, pacoteSelecionado, servicoPacotes);
						} else {
							System.out.println("Número do pacote inválido!");
						}

					} else if (acao.equalsIgnoreCase("4")) {

						System.out.println("Digite a data mínima desejada (no formato YYYY-MM-DD): ");
						String dataString = scanner.nextLine();
						
						LocalDate dataDesejada = LocalDate.parse(dataString);
	
						List<PacoteCompleto> pacotesPorDatas = servicoPacotes.listarPorData(dataDesejada);
						System.out.println("Pacotes por datas: ");

						int contador = 1;
						for (PacoteCompleto pacote : pacotesPorDatas) {
							System.out.println("Pacote " + contador + ": Destino: " + pacote.getLugar().getNomeDestino() + ", Estadia: " + pacote.getEstadia() +
												", Categoria: " + pacote.getCategoria() + ", Data de Ida: " + 
												pacote.getDataIda() + ", Preço: R$" + pacote.getValorTotal());
							contador++;
						}
						
						// Solicitar ao usuário que selecione um pacote para reservar
						System.out.println("Digite o número do pacote que deseja reservar:");
						int numeroPacote = scanner.nextInt();
						scanner.nextLine(); // Limpar a quebra de linha
						
						// Verificar se o número fornecido é válido
						if (numeroPacote > 0 && numeroPacote <= pacotesPorDatas.size()) {
							// Obter o pacote selecionado pelo usuário
							PacoteCompleto pacoteSelecionado = pacotesPorDatas.get(numeroPacote - 1); // -1 porque os índices começam em 0
						
							// Realizar a reserva do pacote
							Reserva.realizarReserva(usuarioAutenticado, pacoteSelecionado, servicoPacotes);
						} else {
							System.out.println("Número do pacote inválido!");
						}

					} else if (acao.equalsIgnoreCase("5")) {
						break;	
					} else {
						System.out.println("Entrada inválida, saindo da plataforma.");
						System.out.println("Obrigado. Até mais!");
						break;
					}
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