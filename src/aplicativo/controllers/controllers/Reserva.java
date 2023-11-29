package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aplicativo.models.pacotes.PacoteCompleto;
import aplicativo.models.pessoas.Usuario;
import aplicativo.models.utils.ColecoesPacotes;
import aplicativo.models.pessoas.Pessoa;
public class Reserva {
    private static List<Reserva> reservas = new ArrayList<>();

    private Pessoa usuario;
    private PacoteCompleto pacoteViagem;
    private LocalDate dataReserva;
    //private ColecoesPacotes<PacoteCompleto> servicoPacotes;

    public Reserva(Pessoa usuario, PacoteCompleto pacoteViagem) {
        this.usuario = usuario;
        this.pacoteViagem = pacoteViagem;
        this.dataReserva = LocalDate.now();
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public PacoteCompleto getPacoteViagem() {
        return pacoteViagem;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public static boolean pacoteJaReservado(PacoteCompleto pacote) {
        for (Reserva reserva : reservas) {
            if (reserva.getPacoteViagem().equals(pacote)) {
                return true;
            }
        }
        return false;
    }

    public static void realizarReserva(Pessoa usuario, PacoteCompleto pacoteViagem, ColecoesPacotes<?> pacotes) {
        if (usuario instanceof Usuario){    // verifica se a reserva é feita por um usuario

            if (pacoteJaReservado(pacoteViagem)) {  // verifica se ja esta numa lista de reservas
                System.out.println("Este pacote já foi reservado por outro usuário.");
            } else {
                Reserva reserva = new Reserva(usuario, pacoteViagem); // instancia uma nova reserva
                reservas.add(reserva);  
                System.out.println("Reserva para " + usuario.getNome() + " realizada com sucesso!");
                
                usuario.setAdmin(true); // possibilita a remoção de pacote ao reservar

                // Remover o pacote do serviço de pacotes
                try {
					pacotes.removerPacote(usuario, pacoteViagem);
				} catch (Exception e) {
					e.printStackTrace();
				}
                
                usuario.setAdmin(false); // revoga o privilégio de administrador do usuario automaticamente
            }
        } else {
            System.out.println("Não é um usuário para reservar este pacote.");
        }
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    public static List<Reserva> minhasReservas(Pessoa usuarioDesejado) {
        List<Reserva> minhasReservas = new ArrayList<>();
        for (Reserva reverva : reservas){
            if (reverva.getUsuario().equals(usuarioDesejado)){
                minhasReservas.add(reverva);
            }
        }
        return minhasReservas;
    }
}
