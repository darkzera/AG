package CaxeiroViajante;

public class Mutacao {

    public static void mutacaoCx(Caminho filho){
        // Porcentagem ocorrencia mutacao
        int porcentOcorrenciaMutacao = 1;
        // Posicao dos genes q sofrerao a mutacao
        int chancesMutacao = tools.generateRandomValue(0, 100);

        int limit = filho.sequenciaCidades.size();
        if (chancesMutacao <= porcentOcorrenciaMutacao){
            Cidade cityBkp = new Cidade();
            int[] randomPos = tools.fillVetorRandomValues(2, limit);
            cityBkp = filho.sequenciaCidades.get(randomPos[0]);
            filho.sequenciaCidades.set(randomPos[0],
                    filho.sequenciaCidades.get(randomPos[1])
            );
            filho.sequenciaCidades.set(randomPos[1],
                    cityBkp);
        }
    }


    // Recebe um filho gerado p/ randomizar se sofrerá ou nao uma MUTACAO
    // Metodo basico P-Med
//    public static void mutacaoSimples(Cromossomo filhoGerado){
//        // Porcentagem ocorrencia mutacao
//        int porcentOcorrenciaMutacao = 2;
//        // Posicao dos genes q sofrerao a mutacao
//        int posGenesMutacao;
//        int numVertices = 323;
//        int numGenes = 1;
//        int chancesMutacao = tools.generateRandomValue(0, 100);
//
//        int totalGensMutados = 1;
//
//        if (chancesMutacao <= porcentOcorrenciaMutacao){
//
//            for (int i = 0; i < totalGensMutados ; i++) {
//                posGenesMutacao = tools.generateRandomValue(0, 9);
//                int novoGene = tools.generateRandomValue(0, numVertices);
//                filhoGerado.genes.set(posGenesMutacao, novoGene);
//            }
//
//        }
//
//    }


}

