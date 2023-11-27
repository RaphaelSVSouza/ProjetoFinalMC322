package aplicativo.models.destino;

import aplicativo.models.utils.PossuiValor;

public class Estadia implements PossuiValor {
    private CategoriaEstadia categoria;
    private String descricao;
    private double valorPorDia;

    public CategoriaEstadia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEstadia categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorPorDia() {
        return valorPorDia;
    }

    public void setValorPorDia(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

	@Override
	public double getValor() {
		return getValorPorDia();
	}
}