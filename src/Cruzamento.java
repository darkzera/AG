import java.util.ArrayList;

public class Cruzamento {

    public static Populacao cruzarGenes(Populacao p){
        Cromossomo filho1 = new Cromossomo();
        Populacao filhos = new Populacao();

        int paiCiclo = 0;
        while (paiCiclo <= 1) {
            Cromossomo pai = p.cromossomos.get(paiCiclo);
            System.out.println("Cromos do pai"+paiCiclo+ " completo: " + p.cromossomos.get(paiCiclo));
            if (filho1.genes.size() > 3) {
                System.out.println("vo add: "+ pai.genes.subList(5, 10));
                filho1.genes.addAll(pai.genes.subList(5, 10));
            }
            if (filho1.genes.size() == 0) {
                System.out.println("vo add: "+ pai.genes.subList(0, 5));
                filho1.genes.addAll(pai.genes.subList(0, 5));
            }
            paiCiclo++;
        }
        filhos.cromossomos.add(filho1);

        return filhos;
    }


    public static Cromossomo cruzarGenesPtsCorte(Populacao pais){
        Cromossomo filho1 = new Cromossomo();
        Cromossomo filho2 = new Cromossomo();
        Populacao filhos = new Populacao();
        int ptsCorte[] = new int[2];
        for (int i = 0; i < ptsCorte.length ; i++) {
            ptsCorte[i] = tools.generateRandomValue(0, 9);
            // obrigar o segundo vlr a ser maior que o primeiro
            if (i > 0){
                int menorValor = 0;
                if (ptsCorte[i] < ptsCorte[i-1]) {
                    menorValor = ptsCorte[i];
                    ptsCorte[i] = ptsCorte[i-1];
                    ptsCorte[i-1] = menorValor;
                }
            }
        }
        // criando filho1
        filho1.genes.addAll(pais.cromossomos.get(0).genes.subList(0, ptsCorte[0]));
//        System.out.println("pai1 add: " + pais.cromossomos.get(0).genes.subList(0, ptsCorte[0]));
        /////
        filho1.genes.addAll(pais.cromossomos.get(1).genes.subList(ptsCorte[0], (ptsCorte[1]+1)) );
//        System.out.println("pai2 add: " + pais.cromossomos.get(1).genes.subList(ptsCorte[0], (ptsCorte[1]+1)));
        /////
        filho1.genes.addAll(pais.cromossomos.get(0).genes.subList(ptsCorte[1], 9) );
//        System.out.println( "pai1 add: " + pais.cromossomos.get(0).genes.subList(ptsCorte[1], 9) );
        findRepetidos(filho1);

        // criando filho2
        filho2.genes.addAll(pais.cromossomos.get(1).genes.subList(0, ptsCorte[0]));
//        System.out.println("pai2 add: " + pais.cromossomos.get(1).genes.subList(0, ptsCorte[0]));
        /////
        filho2.genes.addAll(pais.cromossomos.get(0).genes.subList(ptsCorte[0], (ptsCorte[1]+1)) );
//        System.out.println("pai1 add: " + pais.cromossomos.get(0).genes.subList(ptsCorte[0], (ptsCorte[1]+1)));
        /////
        filho2.genes.addAll(pais.cromossomos.get(1).genes.subList(ptsCorte[1], 9) );
//        System.out.println( "pai2 add: " + pais.cromossomos.get(1).genes.subList(ptsCorte[1], 9) );
        findRepetidos(filho2);



        if (filho1.getFitness() > filho2.getFitness()) {
            filho1.calcFitness();
            Mutacao.mutacaoSimples(filho1);
            return filho1;
        }
        Mutacao.mutacaoSimples(filho2);
        filho2.calcFitness();



        return filho2;

    }

    private static void findRepetidos(Cromossomo filhoGerado){
        for (int i = 0; i < filhoGerado.genes.size() ; i++) {
            for (int j = 0; j < filhoGerado.genes.size() ; j++) {
                if (i != j && filhoGerado.genes.get(i).intValue() == filhoGerado.genes.get(j).intValue()) {
//                    int randomValue = tools.generateRandomValue(0, 323);
                    int randomValue = filhoGerado.genes.get(i)+1;
                    filhoGerado.genes.set(i, randomValue);
                }
            } // end for J
        } // end for I
    }


}
