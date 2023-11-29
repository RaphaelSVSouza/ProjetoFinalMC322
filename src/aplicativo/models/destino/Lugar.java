package aplicativo.models.destino;
import aplicativo.models.utils.PossuiValor;

public class Lugar implements PossuiValor {
    private String descricao;
    private String pathImagens;
    private double valor;
    private String nomeDestino;


    public String getNomeDestino() {
        return this.nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

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
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
