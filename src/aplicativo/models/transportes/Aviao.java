package aplicativo.models.transportes;

public class Aviao extends MeioTransporte {
    private String aeroporto;

    public String getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }
}