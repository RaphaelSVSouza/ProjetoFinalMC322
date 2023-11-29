package aplicativo.models.pessoas;

public class Usuario extends Pessoa {	
    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
        setAdmin(false);
    }
}
