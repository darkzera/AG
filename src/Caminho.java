import java.util.ArrayList;

// Caminho = Cromossomo
public class Caminho {
    // Cidades = Genes
    ArrayList<Cidade> sequenciaCidades = new ArrayList<Cidade>();
    Cidade inicio;
    double fitness;
    double chance;
    int gen = 1;

    public void findRepetidos(){
        for (int i = 0; i < sequenciaCidades.size(); i++) {
            for (int j = 0; j < sequenciaCidades.size(); j++) {
                if (i != j && sequenciaCidades.get(i).getX() == sequenciaCidades.get(j).getX() && sequenciaCidades.get(i).getY() == sequenciaCidades.get(j).getY()) {
                    System.out.println("Caminho.findRepetidos()");
                    System.out.print(" - > REPETIDO AQ POW");
                }
            } // end for J
        } // end for I
    }

    private Cidade getCidadeMaisProxima(Cidade pAtual){
        Cidade melhorCidade = new Cidade();
        double menorDist = Double.MAX_VALUE;
        for (int i = 0; i < sequenciaCidades.size(); i++) {
            if (menorDist > pAtual.rangeToCidade(sequenciaCidades.get(i))) {
                if (false)
                    melhorCidade = sequenciaCidades.get(i);
            }
        }
        return melhorCidade;
    }

    public double setFitness() {
        double rangeToNextPoint = 0;
        int i = 0;

        // Distancia entre cidade inicio -> primeira cidade (gene) do meu caminho
        rangeToNextPoint += this.inicio.rangeToCidade(sequenciaCidades.get(0));
        // Range entre a 1a cidade até a ultima
        for (i = 0; i < sequenciaCidades.size()-1; i++) {
            rangeToNextPoint += sequenciaCidades.get(i).rangeToCidade(
                    sequenciaCidades.get(i+1)
            );
        }
        // Range entre a ultima cidade e cidade inicio
        rangeToNextPoint += sequenciaCidades.get(sequenciaCidades.size()-1).rangeToCidade(
                this.inicio
        );

        this.fitness = rangeToNextPoint;
        return rangeToNextPoint;
    }

    public void calcChance(double fitTotal) {
        this.chance = (this.fitness * 100) / fitTotal;
    }

    public double getFitness() {
        return fitness;
    }
    public void setInicio(Cidade cidadeInicio){
        this.inicio = cidadeInicio;
    }
    public void setCaminho(ArrayList<Cidade> cidadesAdd){
        this.sequenciaCidades = cidadesAdd;
    }
    public void addCidade(Cidade c){
        sequenciaCidades.add(c);
    }
    public void addCidade(int index, Cidade c){
        sequenciaCidades.set(index, c);
    }

    // Care with this method
    public void addCidade(ArrayList<Cidade> arrListCidade){
        sequenciaCidades = arrListCidade;
    }

    @Override
    public String toString() {
        String rst = "\n";
        int i = 0;
        for (Cidade c : sequenciaCidades) {
            if (i % 5 == 0) {
                rst += "\n";
            }
            rst += c.toString();
            i++;
        }
        rst += "\n - Fitness: " + this.fitness;
        return rst;
    }
    public String fitString() {
        return "[" +
                "fitness =" + fitness +
                " ]";
    }

    public Caminho(){}
    public Caminho(Cidade c){
        this.addCidade(c);
    }
    public Caminho(int vetPontos[], ArrayList<Cidade> cidadesMapa){
        for (int i = 0; i < vetPontos.length ; i++) {
            sequenciaCidades.add(cidadesMapa.get(vetPontos[i]));
        }
    }
}
