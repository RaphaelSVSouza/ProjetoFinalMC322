package aplicativo.models.pacotes;

import java.time.LocalDate;
import java.util.List;
import aplicativo.models.destino.Atividades;
import aplicativo.models.destino.Estadia;
import aplicativo.models.destino.Lugar;
import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.transportes.MeioTransporte;

class PermissaoNegadaException extends Exception {
    public PermissaoNegadaException(String mensagem) {
        super(mensagem);
    }
}


public class PacoteCompleto extends Pacote {
    private List<Atividades> atividades;
    private MeioTransporte meioTransporte;
    private Estadia estadia;
    private int duracaoViagem;

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

    @Override
    public void criarPacote(Pessoa pessoa, Estadia estadia, Lugar destino, LocalDate ida, LocalDate volta, CategoriaPacote categoria) throws PermissaoNegadaException{
        try {
            if (!pessoa.isAdmin()) {
             
               throw new PermissaoNegadaException("Você não tem permissao de administrador.");
            } 
            // Lógica para criar o pacote
            setCategoria(categoria);
            setLugar(destino);
            setEstadia(estadia);
            setDataIda(ida);
            setDataVolta(volta);

            duracaoViagem = duracaoDias(ida, volta);


            System.out.println("Pacote de viagem criado com sucesso!");
        } catch(PermissaoNegadaException e) {
            System.out.println("Erro ao criar pacote: " + e.getMessage());
        }
    }

}