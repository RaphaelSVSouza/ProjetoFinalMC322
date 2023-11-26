package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import aplicativo.models.pacotes.Pacote;
import aplicativo.models.pessoas.Usuario;

public class Reserva {
    private static List<Reserva> reservas = new ArrayList<>();

    private Usuario usuario;
    private Pacote pacoteViagem;
    private LocalDate dataReserva;

    public Reserva(Usuario usuario, Pacote pacoteViagem) {
        this.usuario = usuario;
        this.pacoteViagem = pacoteViagem;
        this.dataReserva = LocalDate.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pacote getPacoteViagem() {
        return pacoteViagem;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void realizarReserva() {
        // Adiciona a reserva à lista de reservas
        reservas.add(this);

        System.out.println("Reserva realizada com sucesso!");
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }
}
