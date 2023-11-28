package aplicativo.models.excecoes;

public class PermissaoNegadaException extends Exception {
    public PermissaoNegadaException(String mensagem) {
        super(mensagem);
    }
}
