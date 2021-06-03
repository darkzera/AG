import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainCaxeiro {
    public static void main(String[] args) {
        int tamPopulacao = 20;
        long startTime = System.currentTimeMillis();
        long totalTime = 0;
        int rept = 0;
        PopulacaoCaminhos pop = PopHandling.generateBasicPopulation(tamPopulacao, 100);

        // Ciclo TODO: interf
        Caminho melhorFitStart = PopHandling.bestFit(pop);
        do {
            PopulacaoCaminhos paisSelecionados = Roleta.roletaCidades(pop);
            Caminho filho = Cruzamento.cruzCaix(paisSelecionados);
            if (!PopHandling.findClone(pop, filho)) {
                PopHandling.reinsert(pop, paisSelecionados, filho);
            }
            filho.findRepetidos();
            if (melhorFitStart.getFitness() > PopHandling.bestFit(pop).getFitness()) {
                melhorFitStart = PopHandling.bestFit(pop);
                System.out.println("Melhor fit encontrado na populacao: " + melhorFitStart.getFitness());
            }
            rept++;
            totalTime = (System.currentTimeMillis() - startTime) / 60000;
        } while (rept != 50000);
//        } while (totalTime < 120000) ;

        // Relatorio final
        System.out.println("------------ Pop Final ------------" );
        System.out.println(pop.caminhosPopulacao.toString());
        Caminho best = PopHandling.bestFit(pop);
        System.out.println("------------ Best found [Complete] ------------" );
        System.out.println(best.toString());
        System.out.println("------------ Fitness ------------" );
        System.out.println("Melhor fit: " + best.getFitness());
        System.out.println("Pior fit: " + PopHandling.worstFit(pop).getFitness());
        System.out.println("------------ Status ------------" );
        System.out.println("Tamanho populacao: " + tamPopulacao);
        System.out.println("Quantidade de cidades: 100 [1 destino + 99 a percorrer]");
        totalTime = (System.currentTimeMillis() - startTime) / 60000;
        System.out.print("T/min: " + totalTime);
        totalTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.print(" - T/sec: " + totalTime);

        tools.printBar();
        System.out.println(pop.caminhosPopulacao.get(1).inicio);
        System.out.println(pop.caminhosPopulacao.get(0).inicio);



        // Pontos
//        int[][] mat = tools.loadFile("src/100.txt");
//        // Lista das cidades p visitar
//        // Ordem baseada no .txt
//        ArrayList<Cidade> cidadesLoad = new ArrayList<>();
//        Cidade cidadeInicio = new Cidade();
//        // Mapeamento com as cidades default
//        // Cidades ordenadas de acordo com o txt
//        for (int i = 0; i < mat.length; i++) {
//            Cidade cidadeAdd = new Cidade();
//            // A primeira cidade (coordenada x,y) do arquivo é setado como cidade INICIAL
//            if (cidadesLoad.size() == 0) {
//                cidadeInicio = cidadeAdd;
//            }
//            cidadeAdd.setX(mat[i][0]);
//            cidadeAdd.setY(mat[i][1]);
//            cidadesLoad.add(cidadeAdd);
//        }
//        // Remover cidade start do array
//        cidadesLoad.remove(0);
//
//        // Populacao inicial => Array de caminhos
//        PopulacaoCaminhos pop = new PopulacaoCaminhos();
//        ArrayList<Caminho> caminhos = new ArrayList<>();
//        for (int i = 0; i < tamPopulacao; i++) {
//            // Array com a posicao dos genes
//            // random sequencia de cidades p/ Caminhos/Rotas (possiveis - pop inicial)
//            caminhos.add(new Caminho());
//            ArrayList<Cidade> cities = cidadesLoad;
//            Collections.shuffle(cities);
//
//            caminhos.get(i).setInicio(cidadeInicio);
//            for (Cidade c : cities) {
//                caminhos.get(i).sequenciaCidades.add(c);
//            }
//            caminhos.get(i).setFitness(); // TODO: LOADFITNESS
//            pop.caminhosPopulacao.add(caminhos.get(i));
//        }
    }
}

