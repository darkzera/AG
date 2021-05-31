import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainCaxeiro {
    public static void main(String[] args) {
        int maxPointsValue = 100;
        int tamPopulacao = 100;
        long startTime = System.currentTimeMillis();
        // Pontos
        int[][] mat = tools.loadFile("src/100.txt");
        // Lista das cidades p visitar
        // Ordem baseada no .txt
        ArrayList<Cidade> cidadesLoad = new ArrayList<>();
        Cidade cidadeInicio = new Cidade();

        // Mapeamento com as cidades default
        // Cidades ordenadas de acordo com o txt
        for (int i = 0; i < mat.length; i++) {
            Cidade cidadeAdd = new Cidade();
            // A primeira cidade (coordenada x,y) do arquivo é setado como cidade INICIAL
            if (cidadesLoad.size() == 0) {
                cidadeInicio = cidadeAdd;
            }
            cidadeAdd.setX(mat[i][0]);
            cidadeAdd.setY(mat[i][1]);
            cidadesLoad.add(cidadeAdd);
        }
        // Remover cidade start do array
        cidadesLoad.remove(0);

        // Populacao inicial => Array de caminhos
        PopulacaoCaminhos pop = new PopulacaoCaminhos();
        ArrayList<Caminho> caminhos = new ArrayList<>();
        for (int i = 0; i < tamPopulacao; i++) {
            // Array com a posicao dos genes
            // random sequencia de cidades p/ Caminhos/Rotas (possiveis - pop inicial)
            caminhos.add(new Caminho());
            ArrayList<Cidade> cities = cidadesLoad;
            Collections.shuffle(cities);

            caminhos.get(i).setInicio(cidadeInicio);
            for (Cidade c : cities) {
                caminhos.get(i).sequenciaCidades.add(c);
            }
            caminhos.get(i).setFitness(); // TODO: LOADFITNESS
            pop.caminhosPopulacao.add(caminhos.get(i));
        }

        // Ciclo ag
        int rept = 0;

        do {
            PopulacaoCaminhos paisSelecionados = Roleta.roletaCidades(pop);
            Caminho filho = Cruzamento.cruzCaix(paisSelecionados);
            filho.findRepetidos();
            System.out.println("---------\n" + filho.fitness);
            rept++;
        } while (rept != 2000);



        // end of populacao  TODO: Levar pra outra estrutura separada
    }
}

