package main;
import aplicativo.models.destino.*;
//import aplicativo.models.excecoes.PermissaoNegadaException;
import aplicativo.models.pacotes.*;
import aplicativo.models.pessoas.Administrador;
//import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.transportes.Aviao;
import aplicativo.models.transportes.Onibus;
import aplicativo.models.utils.ColecoesPacotes;
import servicos.Login;

import java.time.LocalDate;
//import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instanciando um administrador
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
		PacoteCompleto pacote2 = ColecoesPacotes.criarPacote(admin, estadia1, destino2, LocalDate.now(), LocalDate.now().plusDays(7), CategoriaPacote.AVENTURA, 0.8, onibus);

		
		ColecoesPacotes<PacoteCompleto> servicoPacotes = new ColecoesPacotes<PacoteCompleto>();
		
		if (pacote1 != null) {
            servicoPacotes.adicionarPacote(pacote1);
            servicoPacotes.adicionarPacote(pacote2);
		}
        
        Login.realizarLogin(servicoPacotes);
    }
}
