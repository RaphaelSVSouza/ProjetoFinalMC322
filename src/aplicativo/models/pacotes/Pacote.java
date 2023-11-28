package aplicativo.models.pacotes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import aplicativo.models.destino.*;
import aplicativo.models.excecoes.PermissaoNegadaException;
import aplicativo.models.utils.*;
import aplicativo.models.pessoas.Pessoa;

public abstract class Pacote implements Reservavel {
    private CategoriaPacote categoria;
    private double valorTotal;
    private LocalDate dataIda;
    private LocalDate dataVolta;
    private Lugar lugar;
    private int vagasDisponiveis;

    public CategoriaPacote getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPacote categoria) {
        this.categoria = categoria;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    public LocalDate getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public int duracaoDias(LocalDate ida, LocalDate volta) {
        long diferencaDias = ChronoUnit.DAYS.between(ida, volta);

        return Math.abs((int) diferencaDias);
    }

    public abstract void criarPacote(Pessoa pessoa, Estadia estadia, Lugar destino, LocalDate ida, LocalDate volta, CategoriaPacote categoria, double fatorPreco) throws PermissaoNegadaException;
}
