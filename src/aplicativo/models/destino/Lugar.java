package aplicativo.models.destino;
import aplicativo.models.utils.PossuiValor;

public class Lugar implements PossuiValor {
    private String descricao;
    private String pathImagens;
    private int valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPathImagens() {
        return pathImagens;
    }

    public void setPathImagens(String pathImagens) {
        this.pathImagens = pathImagens;
    }

    @Override
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
