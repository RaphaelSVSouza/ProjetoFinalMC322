package servicos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import aplicativo.models.destino.*;
import aplicativo.models.pacotes.Pacote;

public class ServicoPacotes {
    private List<Pacote> pacotes;


    public ServicoPacotes() {
        this.pacotes = new ArrayList<>();
    }

    public void adicionarPacote(Pacote pacote) {
        this.pacotes.add(pacote);
    }

    public List<Pacote> listarPorPreco(int precoMaximo) {
        List<Pacote> pacotesPorPreco = new ArrayList<>();
        for (Pacote pacote : pacotes) {
            if (pacote.getValorTotal() <= precoMaximo) {
                pacotesPorPreco.add(pacote);
            }
        }
        return pacotesPorPreco;
    }

    public List<Pacote> listarPorData(LocalDate dataDesejada) {
        List<Pacote> pacotesPorData = new ArrayList<>();
        for (Pacote pacote : pacotes) {
            if (pacote.getDataIda().isEqual(dataDesejada) || pacote.getDataIda().isAfter(dataDesejada)) {
                pacotesPorData.add(pacote);
            }
        }
        return pacotesPorData;
    }

    public List<Pacote> listarPorLocal(Lugar localDesejado) {
        List<Pacote> pacotesPorLocal = new ArrayList<>();
        for (Pacote pacote : pacotes) {
            if (pacote.getLugar().getNomeDestino().equalsIgnoreCase(localDesejado.getNomeDestino())) {
                pacotesPorLocal.add(pacote);
            }
        }
        return pacotesPorLocal;
    }
}
