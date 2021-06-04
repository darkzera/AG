import java.util.ArrayList;
import java.util.List;

public class Cruzamento {

    public static Caminho cruzCaix(PopulacaoCaminhos pais){
        Caminho filho1 = new Caminho();
        Caminho filho2 = new Caminho();
        PopulacaoCaminhos filhos = new PopulacaoCaminhos();
        // Limite range de corte 70% do tamanho do array 0.7 * arr.size
        int rangeCorte = (int) (0.7 * pais.caminhosPopulacao.get(0).sequenciaCidades.size());
        int ptsCorte[] = tools.generatePointsCrossOver(rangeCorte);
        int plus = 1;
        Caminho paiAlvo = pais.caminhosPopulacao.get(0);

//         criando filho1
        fillFake(filho1, ptsCorte);
        filho1.sequenciaCidades.addAll(pais.caminhosPopulacao.get(1).sequenciaCidades.subList(ptsCorte[0], (ptsCorte[1] + plus)));
        filho1.inicio = pais.caminhosPopulacao.get(0).inicio;
        filho1 = findAndReplace(filho1, paiAlvo, ptsCorte);
        filho1.setFitness();
        paiAlvo = pais.caminhosPopulacao.get(1);
//         criando filho2
        fillFake(filho2, ptsCorte);
        filho2.sequenciaCidades.addAll(pais.caminhosPopulacao.get(0).sequenciaCidades.subList(ptsCorte[0], (ptsCorte[1] + 1)));
        filho2.inicio = pais.caminhosPopulacao.get(1).inicio;
        filho2 = findAndReplace(filho2, paiAlvo, ptsCorte);
        filho2.setFitness();

        if (filho1.getFitness() > filho2.getFitness()) {
            filho1.setFitness();
            Mutacao.mutacaoCx(filho1);
            return filho1;
        }
        Mutacao.mutacaoCx(filho2);
        filho2.setFitness();
        return filho2;
    }

    private static Caminho findAndReplace(Caminho filhoGerado, Caminho pai, int[] ptsCorte) {
        boolean swap = false;
        int iniCorte = ptsCorte[0];
        int fimCorte = ptsCorte[1];
        int addedSub = 0;

        for (int i = 0; !swap && i < pai.sequenciaCidades.size(); i++) {
            if (i == iniCorte) {
                i = fimCorte + 1;
            }
            if (i < iniCorte) {
                if (!sequenceHasCity(filhoGerado.sequenciaCidades.subList(iniCorte, fimCorte + 1), pai.sequenciaCidades.get(i))) {
                    filhoGerado.sequenciaCidades.set(i, pai.sequenciaCidades.get(i));
                } else {
                    for (int subGroupPai = iniCorte + addedSub; subGroupPai <= fimCorte; subGroupPai++) {
                        if (!sequenceHasCity(filhoGerado.sequenciaCidades.subList(iniCorte, fimCorte + 1), pai.sequenciaCidades.get(subGroupPai))) {
                            filhoGerado.sequenciaCidades.set(i, pai.sequenciaCidades.get(subGroupPai));
                            addedSub++;
                            break;
                        }
                        addedSub++;
                    }
                }
            }
            // Sim, sao iguais mas fui integrar e fiz merda
            // Portanto, resolvi fazer um loop pra cada parte foda-s
            if (i > fimCorte) {
                int plus = 1;
                // Nem tenta entender isso
                if (fimCorte == 99){
                    plus = 1;
                }
                if (!sequenceHasCity(filhoGerado.sequenciaCidades.subList(iniCorte, fimCorte + plus), pai.sequenciaCidades.get(i))) {
                    filhoGerado.sequenciaCidades.add(pai.sequenciaCidades.get(i));
                } else {
                    for (int subGroupPai = iniCorte + addedSub; subGroupPai <= fimCorte; subGroupPai++) {
                        if (!sequenceHasCity(filhoGerado.sequenciaCidades.subList(0, fimCorte + plus), pai.sequenciaCidades.get(subGroupPai))) {
                            filhoGerado.sequenciaCidades.add(i, pai.sequenciaCidades.get(subGroupPai)
                            );
                            addedSub++;
                            break;
                        }
                        addedSub++;
                    }
                }
            }


        }
        return filhoGerado;



//         SEGUNDA
//        for (int cidadePaiIndex = 0; cidadePaiIndex < iniCorte; cidadePaiIndex++) {
//            Cidade cidadePai1 = pais.getCaminhosPopulacao().get(0).sequenciaCidades.get(cidadePaiIndex); // ??? VAR NAMS
//            found = false;
//            for (int cidadeFilho = iniCorte; !found && cidadeFilho <= fimCorte; cidadeFilho++) {
//                // Se for diff -> inserir primeiro(0) valor do PAI na primeira pos do F
//                if (filhoGerado.sequenciaCidades.get(cidadeFilho).compair(cidadePai1)){
//                    found = true;
//                    posInsertBkp = cidadePaiIndex;
//                    posFilhoBkp = cidadeFilho;
//                    posSubGrupoPai = iniCorte;
//                    do{
//                        // SE NAO TEM< BORA ADD NA LISTA VALOR INIC
//                        if (filhoGerado.sequenciaCidades.subList(iniCorte, fimCorte).contains(pai1.sequenciaCidades.get(posSubGrupoPai))){
//                            if (filhoGerado.sequenciaCidades.get(posInsertBkp).getX() == -1) {
//                                filhoGerado.sequenciaCidades.set(posInsertBkp, pai1.sequenciaCidades.get(posSubGrupoPai));
//                            }else{
//                                System.out.println("TENTOU MAIS N PODEU");
//                            }
//                            swap = true;
//                        }
//                        //  se a sequencia MIOLO do filho possuí a cidade do pai, nao posso inserir
//                        posSubGrupoPai++;
//                    }while(!swap && posSubGrupoPai <= fimCorte);
//                }
//            } // for j
//            if (!found && filhoGerado.sequenciaCidades.get(cidadePaiIndex).getX() == -1) {
//                filhoGerado.sequenciaCidades.set(cidadePaiIndex, pai1.sequenciaCidades.get(cidadePaiIndex));
//            }
//        } // for I
// PIRMEIR
//        for (int i = 0; i < ptsCorte[0]; i++) {
//            Cidade cidadePai1 = pais.getCaminhosPopulacao().get(0).sequenciaCidades.get(i);
//            swap = false;
//            for (int j = ptsCorte[0]; !swap && j <= ptsCorte[1]; j++) {
//                if (filhoGerado.sequenciaCidades.get(j).compair(cidadePai1)){
//                    System.
//        }
//
////        for (int i = pai1.sequenciaCidades.size()-1; i > ptsCorte[1]; i--) {
////            filhoGerado.sequenciaCidades.add(pai1.sequenciaCidades.get(i));
////        }


    }

    private static void fillFake(Caminho filho, int[] points){
        Cidade nullified = new Cidade(-1,-1, "NULL X");
        for (int i = 0; i < points[0]; i++) {
            filho.sequenciaCidades.add(nullified);
        }
    }

    private static boolean sequenceHasCity(List<Cidade> cidades, Cidade cidadeBusca) {
        boolean found = false;
        for (int i = 0; i < cidades.size(); i++){
            if (cidades.get(i).compair(cidadeBusca)) {
                found = true;
            }
        }
        return found;
    }

    private static ArrayList<Cidade> onlyRemains(List<Cidade> cidadesPai, List<Cidade> cidadesFilho){
        ArrayList<Cidade> cidadesAllowed = new ArrayList<>();
        for (Cidade cityPai : cidadesPai) {
            for (Cidade cityFilho : cidadesFilho) {
                if (cityFilho.getY() != cityPai.getY()){
                    cidadesAllowed.add(cityPai);
                } else {
                    break;
                }

            }
        }
        return cidadesAllowed;
    }



    // P-med
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
        Cidade nullified = new Cidade(0,0, "NULL X");

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
        boolean sucessfullCross = false;

        while (!sucessfullCross) {
            // criando filho1
            filho1.genes.addAll(pais.cromossomos.get(0).genes.subList(0, ptsCorte[0]));
//        System.out.println("pai1 add: " + pais.cromossomos.get(0).genes.subList(0, ptsCorte[0]));
            /////
            filho1.genes.addAll(pais.cromossomos.get(1).genes.subList(ptsCorte[0], (ptsCorte[1] + 1)));
//        System.out.println("pai2 add: " + pais.cromossomos.get(1).genes.subList(ptsCorte[0], (ptsCorte[1]+1)));
            /////
            filho1.genes.addAll(pais.cromossomos.get(0).genes.subList(ptsCorte[1], 9)); // ARBITRARIO
//        System.out.println( "pai1 add: " + pais.cromossomos.get(0).genes.subList(ptsCorte[1], 9) );
            findRepetidos(filho1);

            // criando filho2
            filho2.genes.addAll(pais.cromossomos.get(1).genes.subList(0, ptsCorte[0]));
//        System.out.println("pai2 add: " + pais.cromossomos.get(1).genes.subList(0, ptsCorte[0]));
            /////
            filho2.genes.addAll(pais.cromossomos.get(0).genes.subList(ptsCorte[0], (ptsCorte[1] + 1)));
//        System.out.println("pai1 add: " + pais.cromossomos.get(0).genes.subList(ptsCorte[0], (ptsCorte[1]+1)));
            /////
            filho2.genes.addAll(pais.cromossomos.get(1).genes.subList(ptsCorte[1], 9)); // ARBITRARIO
//        System.out.println( "pai2 add: " + pais.cromossomos.get(1).genes.subList(ptsCorte[1], 9) );
            findRepetidos(filho2);
        }

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
    //


}
