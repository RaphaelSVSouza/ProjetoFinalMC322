package main;
import aplicativo.models.destino.*;
import aplicativo.models.excecoes.PermissaoNegadaException;
import aplicativo.models.pacotes.*;
import aplicativo.models.pessoas.Administrador;
import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.transportes.Aviao;
import aplicativo.models.transportes.Onibus;
import aplicativo.models.utils.ColecoesPacotes;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

	Administrador admin = new Administrador("Admin", "admin@example.com", "senha", "getente");

        // Criando alguns destinos
        Lugar destino1 = new Lugar();
        destino1.setNomeDestino("Paris");
        destino1.setValor(1000.0);

        Lugar destino2 = new Lugar();
        destino2.setNomeDestino("Londres");
        destino2.setValor(1200.0);

        // Criando estadias para os destinos
        Estadia estadia1 = new Estadia();
        estadia1.setCategoria(CategoriaEstadia.HOTEL);
        estadia1.setValorPorDia(200.0);

        Estadia estadia2 = new Estadia();
        estadia2.setCategoria(CategoriaEstadia.APARTAMENTO);
        estadia2.setValorPorDia(150.0);

        // Criando transportes para os destinos
        Aviao aviao = new Aviao();
        aviao.setValor(500.0);

        Onibus onibus = new Onibus();
        onibus.setValor(100.0);
		
		
        // Criando pacotes
		PacoteCompleto pacote1 = ColecoesPacotes.criarPacote(admin, estadia2, destino1, LocalDate.now(), LocalDate.now().plusDays(7), CategoriaPacote.RELAXAMENTO, 1.0, aviao);
		
		
		ColecoesPacotes servicoPacotes = new ColecoesPacotes();
		
		if (pacote1 != null) {
			servicoPacotes.adicionarPacote(pacote1);
		}

		// Remove o pacote
		servicoPacotes.removerPacote(admin, pacote1);
		
        // Testando os métodos de listagem
        List<Pacote> pacotesPorPreco = servicoPacotes.listarPorPreco(20000);
        List<Pacote> pacotesPorData = servicoPacotes.listarPorData(LocalDate.now());
        List<Pacote> pacotesPorLocal = servicoPacotes.listarPorLocal(destino1);

        // Exibindo os resultados
        System.out.println("Pacotes por preço:");
        for (Pacote pacote : pacotesPorPreco) {
            System.out.println("Destino: " + pacote.getLugar().getNomeDestino() + ", Data de Ida: " + 
								pacote.getDataIda() + ", Preço: " + pacote.getValorTotal());
        }

        System.out.println("\nPacotes por data:");
        for (Pacote pacote : pacotesPorData) {
            System.out.println("Destino: " + pacote.getLugar().getNomeDestino() + ", Data de Ida: " + 
								pacote.getDataIda() + ", Preço: " + pacote.getValorTotal());
        }

        System.out.println("\nPacotes por local:");
        for (Pacote pacote : pacotesPorLocal) {
            System.out.println("Destino: " + pacote.getLugar().getNomeDestino() + ", Data de Ida: " + 
								pacote.getDataIda() + ", Preço: " + pacote.getValorTotal());
        }
    }
}
