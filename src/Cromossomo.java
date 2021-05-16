import java.util.ArrayList;

public class Cromossomo {
    double fitness;
    ArrayList<Integer> genes = new ArrayList<Integer>();
    double chance;

    public Cromossomo(ArrayList<Integer> genes, double fitness) {
        this.genes = genes;
        this.fitness = fitness;
    }
    public Cromossomo(){}

    @Override
    public String toString() {
        return this.genes +
                " Fitness=" + this.fitness +
                "]\n";
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    // Calculo da chance na roleta
    public void calcChance(double fitTotal) {
        this.chance = (this.fitness * 100) / fitTotal;
    }


    // Calcular fitness based in 324.txt file
    public void calcFitness(){
        int[][] mat = tools.loadFile("src/324.txt");
        this.fitness =
                tools.avaliacao(genes.stream().mapToInt(Integer::intValue).toArray(), mat);
    }


}
