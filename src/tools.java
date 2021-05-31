import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class tools {
    public static int[][] loadFile(String path) {
        FileReader arquivo;
        BufferedReader buffer;
        String saida = "", temp = "";
        int pos = 0, cont;
        try {
            arquivo = new FileReader(path);
            buffer = new BufferedReader(arquivo);
            int mat[][] = new int[Integer.parseInt(buffer.readLine())][2];
            while (buffer.ready()) {
                saida = buffer.readLine();
                cont = 0;
                for (int i = 0; i < saida.length(); i++) {
                    if (saida.charAt(i) != ' ') {
                        temp += saida.charAt(i);
                    }
                    if (saida.charAt(i) == ' ' || i == saida.length() - 1) {
                        mat[pos][cont] = Integer.parseInt(temp);
                        temp = "";
                        cont++;
                    }
                }
                pos++;
            }
            buffer.close();
            arquivo.close();
            return mat;
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo!");
            return null;
        }
    }

    public static int generateRandomValue(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static int[] fillVetorRandomValues(int range){
        int array[] = new int[range];
        Random rand = new Random();
        for (int i = 0; i < array.length ; i++) {
//            int randomValue = rand.nextInt(324);
            int randomValue = rand.nextInt(99);
            array[i] = randomValue;
        }
        return array;
    }


    // Caxeiro V.

    // Determinar a distancia entre duas cidades recebidas
    static double getRangeCities(int mat[][], Cidade city1, Cidade city2){
        double distancia;
        int a = mat[city1.getX()][0] - mat[city2.getY()][0];
        int b = mat[city1.getX()][1] - mat[city2.getY()][1];
        distancia = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return distancia;
    }


    // P-Med
    static double avaliacao(int vet[], int mat[][]) {
        int maxPts = mat.length;
        double somatorio = 0;
        double dist;
        double menorDist;

        for (int i = 0; i < maxPts; i++) {
            menorDist = Double.MAX_VALUE;
            for (int j = 0; j < vet.length; j++) {
                dist = getRange(mat, vet[j], i);
                if (menorDist > dist) {
                    menorDist = dist;
                }
            }
            somatorio += menorDist;
        }
        return somatorio;
    }

    static double getRange(int mat[][], int c1, int c2) {
        double distancia;
        int a = mat[c1][0] - mat[c2][0];
        int b = mat[c1][1] - mat[c2][1];
        distancia = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return distancia;
}

    public static Solucao teitzBart(int vet[], int matrix[][], double fitness){
        int maxPointsValue = 324;
        for (int i = 0; i < vet.length; i++){
            int posBkp = vet[i];
            for (int t = 0; t < maxPointsValue; t++) {
                vet[i] = t;
                double newFit = tools.avaliacao(vet, matrix);
                if (newFit < fitness){
                    fitness = newFit;
                    posBkp = t;
                }
            }
            vet[i] = posBkp;
        }
        Solucao solution = new Solucao(vet, fitness);
        return solution;
    }

    public static Cromossomo teitzBartCromo(int vet[], int mat[][], double fitness){
        // TODO: vet[] => Gene
        int maxPoints = 324;
        ArrayList<Integer> genes = new ArrayList<Integer>();
        for (int i = 0; i < vet.length; i++){
            int posBkp = vet[i];
            for (int t = 0; t < maxPoints; t++) {
                vet[i] = t;
                double newFit = tools.avaliacao(vet, mat);
                if (newFit < fitness){
                    fitness = newFit;
                    posBkp = t;
                }
            }
            vet[i] = posBkp;
            genes.add(vet[i]);
        }
        Cromossomo cromo = new Cromossomo(genes, fitness);
        return cromo;
    }






}
