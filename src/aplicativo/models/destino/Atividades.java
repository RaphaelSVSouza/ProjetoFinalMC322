package aplicativo.models.destino;

import aplicativo.models.utils.PossuiValor;

public class Atividades implements PossuiValor {
    private CategoriaAtividade categoria;
    private String descricao;
    private int valor;
    private int duracaoHoras;

    public CategoriaAtividade getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAtividade categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }
}