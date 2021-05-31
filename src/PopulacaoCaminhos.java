import java.util.ArrayList;

public class PopulacaoCaminhos {
    ArrayList<Caminho> caminhosPopulacao = new ArrayList<>();

    public ArrayList<Caminho> getCaminhosPopulacao() {
        return caminhosPopulacao;
    }

    public void setCaminhosPopulacao(ArrayList<Caminho> caminhosPopulacao) {
        this.caminhosPopulacao = caminhosPopulacao;
    }
    public void addCaminho(Caminho caminhoAdd){
       caminhosPopulacao.add(caminhoAdd);
    }

    @Override
    public String toString() {
        String rslt = "";
        int qt = 0;
        for (Caminho caminho : caminhosPopulacao ) {
            rslt += "\n-----Path " + qt + "\n";
            rslt += caminho.sequenciaCidades.toString() + "\n Fitness: " + caminho.fitness;
            qt++;
        }
        return rslt;
    }
}
