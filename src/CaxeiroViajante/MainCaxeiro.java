package CaxeiroViajante;

public class MainCaxeiro {
    public static void main(String[] args) {
        int tamPopulacao = 5;
        long startTime = System.currentTimeMillis();
        long totalTime = 0;
        int rept = 0;
        PopulacaoCaminhos pop = PopHandling.generateBasicPopulation(tamPopulacao, 100);

        // Ciclo TODO: interf
        Caminho melhorFitStart = PopHandling.bestFit(pop);
        System.out.println("Melhor fit INICAL: "+ melhorFitStart);
        System.out.println("------------ Pop Final ------------");
        System.out.println(pop.caminhosPopulacao.toString());

        Caminho a = melhorFitStart;
        do {
            PopulacaoCaminhos paisSelecionados = Roleta.roletaCidades(pop);
            Caminho filho = Cruzamento.cruzCaix(paisSelecionados);
            if (!PopHandling.findClone(pop, filho)) {
                PopHandling.reinsert(pop, paisSelecionados, filho);
            }
            filho.findRepetidos();
            if (melhorFitStart.getFitness() > PopHandling.bestFit(pop).getFitness()) {
                melhorFitStart = PopHandling.bestFit(pop);
                System.err.println("Melhor fit encontrado! " + melhorFitStart.getFitness() + " | ");
            }
            rept++;
            totalTime = (System.currentTimeMillis() - startTime) / 60000;
        } while (rept != 5000000);
//        } while (totalTime < 120000) ;

        // Relatorio final
        System.out.println("------------ Pop Final ------------");
        System.out.println(pop.caminhosPopulacao.toString());
        Caminho best = PopHandling.bestFit(pop);
        tools.printBar();
        System.out.println(best.toString());
        System.out.println("------------ Fitness ------------");
        System.out.println("Melhor fit encontrado: " + best.getFitness());
        System.out.println("Pior fit encontrado: " + PopHandling.worstFit(pop).getFitness());
        System.out.println("------------ Status ------------");
        System.out.println("Tamanho populacao: " + tamPopulacao);
        System.out.println("Quantidade de cidades: " + (pop.caminhosPopulacao.get(0).sequenciaCidades.size() + 1));
        totalTime = (System.currentTimeMillis() - startTime) / 60000;
        System.out.print("T/min: " + totalTime);
        totalTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.print(" - T/sec: " + totalTime);
    }
}

