package aplicativo.models.transportes;

import aplicativo.models.utils.PossuiValor;

public abstract class MeioTransporte implements PossuiValor {
    private CategoriaTransporte categoria;
    private String classePassagem;
    private String compania;
    private double valor;

    public CategoriaTransporte getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTransporte categoria) {
        this.categoria = categoria;
    }

    public String getClassePassagem() {
        return classePassagem;
    }

    public void setClassePassagem(String classePassagem) {
        this.classePassagem = classePassagem;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}