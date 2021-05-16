import java.util.ArrayList;
import java.util.Arrays;

public class Solucao {
    int vertices[];
    double fitness;
    ArrayList<Integer> genes = new ArrayList<Integer>();

    public Solucao(int[] vertices, double fitness) {
        this.vertices = vertices;
        this.fitness = fitness;
    }

    public int[] getVertices() {
        return vertices;
    }

    @Override
    public String toString() {
        return "" + Arrays.toString(vertices) +
                " Fitness = " + fitness +
                "]\n";
    }

    public void setVertices(int[] vertices) {
        this.vertices = vertices;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

}
