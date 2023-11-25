package aplicativo.models.pacotes;

import java.time.LocalDate;
import aplicativo.models.destino.*;
import aplicativo.models.utils.*;

public abstract class Pacote implements Reservavel {
    private CategoriaPacote categoria;
    private int valorTotal;
    private LocalDate dataIda;
    private LocalDate dataVolta;
    private int duracaoDias;
    private Lugar lugar;

    public CategoriaPacote getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPacote categoria) {
        this.categoria = categoria;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
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

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}