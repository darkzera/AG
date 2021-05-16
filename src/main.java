public class main {
    public static void main(String[] args) {
        int maxPointsValue = 324;
        int[][] mat = tools.loadFile("src/324.txt");
        Populacao populacao = new Populacao();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < populacao.getLenght(); i++) {
            int vet[] = tools.fillVetorRandomValues(10);
            double fitness = (double) tools.avaliacao(vet, mat);
            populacao.addCromossomo(tools.teitzBartCromo(vet, mat, fitness));
        }

        System.out.println("----------------------------\n" + populacao.exibe());
        System.out.println("Melhor fit: " + populacao.getBtterFit()+
                "\n Pior fit: " + populacao.getWorstFit()
        );

        Populacao paisSelecionados = new Populacao();
        int i = 0;
        do {
            paisSelecionados = Roleta.roleta(populacao);
            Cromossomo filhoDoCruzamento = Cruzamento.cruzarGenesPtsCorte(paisSelecionados);
            if (!PopHandling.findClones(populacao, filhoDoCruzamento)) {
                PopHandling.reinsert(populacao, filhoDoCruzamento, paisSelecionados.cromossomos.get(0), paisSelecionados.cromossomos.get(1));
            }
            i++;
        }while(i != 1500000);

        // Fazer alguma coisa com esse detect. clone ou nao, ta aqui atoa por enqto

        System.out.println(populacao.exibeCromossomos());
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Melhor fit: " + populacao.getBtterFit()+
                "\nPior fit: " + populacao.getWorstFit()
        );

        long totalTime = (System.currentTimeMillis() - startTime) / 60000;
        System.out.println("T/min: " + totalTime);
        totalTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("T/sec: " + totalTime);
        System.out.println("------------------------------------------------------------------------------------");


    }



}
