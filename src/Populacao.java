import java.util.ArrayList;

public class Populacao {
    Solucao[] solucoes = new Solucao[100];
    ArrayList<Cromossomo> cromossomos = new ArrayList<Cromossomo>();

    public Populacao(Solucao[] solucoes) {
        this.solucoes = solucoes;
    }

    public Populacao(ArrayList<Cromossomo> cromossomos){
        this.cromossomos = cromossomos;
    }

    public Populacao() { }

    public int getLenght(){
        return this.solucoes.length;
    }

    public boolean addIndividuo(Solucao solucao) {
        if (solucao != null) {
            for (int i = 0; i < this.solucoes.length ; i++) {
                if (this.solucoes[i] == null){
                    this.solucoes[i] = solucao;
                    return true;
                }
            }
        }
        return false;
    }

    public void addCromossomo(Cromossomo cromossomoAdd){
        if (cromossomoAdd != null) {
            this.cromossomos.add(cromossomoAdd);
        }
    }

    public String exibeCromossomos(){
        return cromossomos.toString();
    }

    public String getWorstFit(){
        String result = "";
        double worstFit = Double.MIN_VALUE;

        //pior fit
        for (Cromossomo c : cromossomos) {
            if (worstFit < c.getFitness()) {
               worstFit = c.getFitness();
            }
        }
        result += worstFit;
        return result;
    }

    public String getBtterFit(){
        String result = "";

        double btterFit = Double.MAX_VALUE;

        for (Cromossomo c : cromossomos) {
            if (btterFit > c.getFitness()) {
                btterFit = c.getFitness();
            }
        }
        result += btterFit;
        return result;
    }

    public String exibe() {
        String result = "";
        for (Cromossomo c : cromossomos) {
           result += c.toString();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (Solucao element : this.solucoes) {
            if (element != null)
                result += element.toString();
        }
        return result;
    }

}
