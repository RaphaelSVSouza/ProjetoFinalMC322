package aplicativo.models.pacotes;

import java.util.List;
import aplicativo.models.destino.Atividades;
import aplicativo.models.destino.Estadia;
import aplicativo.models.transportes.MeioTransporte;

public class PacoteCompleto extends Pacote {
    private List<Atividades> atividades;
    private MeioTransporte meioTransporte;
    private Estadia estadia;

    public List<Atividades> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividades> atividades) {
        this.atividades = atividades;
    }

    public MeioTransporte getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(MeioTransporte meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }
}