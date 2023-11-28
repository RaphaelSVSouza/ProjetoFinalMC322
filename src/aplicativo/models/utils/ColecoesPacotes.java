package aplicativo.models.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import aplicativo.models.destino.*;
import aplicativo.models.excecoes.PermissaoNegadaException;
import aplicativo.models.pacotes.CategoriaPacote;
import aplicativo.models.pacotes.Pacote;
import aplicativo.models.pacotes.PacoteCompleto;
import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.transportes.MeioTransporte;

public class ColecoesPacotes<T extends Pacote> {
    private List<T> pacotes;

    public ColecoesPacotes() {
        this.pacotes = new ArrayList<>();
    }

    public void adicionarPacote(T pacote) {
        this.pacotes.add(pacote);
    }

    public List<T> listarPorPreco(int precoMaximo) {
        List<T> pacotesPorPreco = new ArrayList<>();
        for (T pacote : pacotes) {
            if (pacote.getValorTotal() <= precoMaximo) {
                pacotesPorPreco.add(pacote);
            }
        }
        return pacotesPorPreco;
    }

    public List<T> listarPorData(LocalDate dataDesejada) {
        List<T> pacotesPorData = new ArrayList<>();
        for (T pacote : pacotes) {
            if (pacote.getDataIda().isEqual(dataDesejada) || pacote.getDataIda().isAfter(dataDesejada)) {
                pacotesPorData.add(pacote);
            }
        }
        return pacotesPorData;
    }

    public List<T> listarPorLocal(Lugar localDesejado) {
        List<T> pacotesPorLocal = new ArrayList<>();
        for (T pacote : pacotes) {
            if (pacote.getLugar().getNomeDestino().equalsIgnoreCase(localDesejado.getNomeDestino())) {
                pacotesPorLocal.add(pacote);
            }
        }
        return pacotesPorLocal;
    }

    public List<T> listarPorCategoria(CategoriaPacote categoriaDesejada) {
        List<T> pacotesPorCategoria = new ArrayList<>();
        for (T pacote : pacotes) {
            if (pacote.getCategoria() == categoriaDesejada) {
                pacotesPorCategoria.add(pacote);
            }
        }
        return pacotesPorCategoria;
    }
    

    public void removerPacote(Pessoa admin, PacoteCompleto pacote) {
        try {
            if (admin.isAdmin()) {
                boolean removido = pacotes.remove(pacote);
                if (removido) {
                    System.out.println("Pacote removido com sucesso!");
                } else {
                    System.out.println("Pacote não encontrado para remoção.");
                }
            } else {
                throw new PermissaoNegadaException("Apenas administradores podem remover pacotes.");
            }
        } catch (PermissaoNegadaException e) {
            System.out.println("Erro ao remover pacote: " + e.getMessage());
        }
    }
    
    
    public static PacoteCompleto criarPacote(Pessoa admin, Estadia estadia, Lugar destino, LocalDate ida, 
                                            LocalDate volta, CategoriaPacote categoria, double fatorPreco, MeioTransporte meioTransporte) {                                   
        PacoteCompleto novoPack = null;

        try {
            novoPack = new PacoteCompleto();
            novoPack.setMeioTransporte(meioTransporte);
            novoPack.criarPacote(admin, estadia, destino, ida, volta, categoria, fatorPreco);
        } catch (PermissaoNegadaException e) {
            System.out.println("Erro ao criar pacote: " + e.getMessage());
        }

        return novoPack;
    }


}

