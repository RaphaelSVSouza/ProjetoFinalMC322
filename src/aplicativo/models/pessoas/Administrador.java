package aplicativo.models.pessoas;

public class Administrador extends Pessoa {
    private String cargo;
    
    public Administrador(String nome, String email, String senha, String cargo) {
        super(nome, email, senha);
        this.cargo = cargo;
    }

    // Getter e setter específico para Administrador
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
