package aplicativo.models.pacotes;

import java.time.LocalDate;
import java.util.List;
import aplicativo.models.destino.Atividades;
import aplicativo.models.destino.Estadia;
import aplicativo.models.destino.Lugar;
import aplicativo.models.pessoas.Pessoa;
import aplicativo.models.transportes.MeioTransporte;
import aplicativo.models.utils.PermissaoNegadaException;


public class PacoteCompleto extends Pacote {
    private List<Atividades> atividades;
    private MeioTransporte meioTransporte = null;
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

    public int getDuracaoViagem(){
        return duracaoViagem;
    }

    public double precoTotal(double fatorPreco) {
        /*
        verifica se algum item que agrega ao pacote esta nao incluso no valor
        final e então, é multiplicado por por um fator para caso de promoção ou não
        sendo 0 "de graça" e 1 "sem desconto".
        O desconto é calculado a partir de "Desconto = 1 - fatorPreco"
        */

        double precoTotal = 0;

        if (estadia != null) {
            precoTotal += estadia.getValorPorDia() * getDuracaoViagem();
        }
        
        if (meioTransporte != null) {
            precoTotal += meioTransporte.getValor();

        }
        
        if (atividades != null) {
            for(Atividades atividade : atividades) {
                precoTotal += atividade.getValor();
            }
        }
        
        return precoTotal * fatorPreco;
    }

    @Override
    public void criarPacote(Pessoa pessoa, Estadia estadia, Lugar destino, LocalDate ida, LocalDate volta,
                             CategoriaPacote categoria, double fatorPreco) throws PermissaoNegadaException {
        if (!pessoa.isAdmin()) {
            throw new PermissaoNegadaException("Você não tem permissão de administrador.");
        } 
    
        // Lógica para criar o pacote
        setCategoria(categoria);
        setLugar(destino);
        setEstadia(estadia);
        setDataIda(ida);
        setDataVolta(volta);
        this.duracaoViagem = duracaoDias(ida, volta);
        this.meioTransporte = getMeioTransporte();
    
        // Calcula preço final
        double valorTotal = precoTotal(fatorPreco);
        setValorTotal(valorTotal);
        
        System.out.println("Pacote de viagem criado com sucesso!");
    }
    

}