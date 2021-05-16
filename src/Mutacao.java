public class Mutacao {

    // Recebe um filho gerado p/ randomizar se sofrerá ou nao uma MUTACAO
    // Metodo basico P-Med
    public static void mutacaoSimples(Cromossomo filhoGerado){
        // Porcentagem ocorrencia mutacao
        int porcentOcorrenciaMutacao = 2;
        // Posicao dos genes q sofrerao a mutacao
        int posGenesMutacao;
        int numVertices = 323;
        int numGenes = 1;
        int chancesMutacao = tools.generateRandomValue(0, 100);

        int totalGensMutados = 1;

        if (chancesMutacao <= porcentOcorrenciaMutacao){

            for (int i = 0; i < totalGensMutados ; i++) {
                posGenesMutacao = tools.generateRandomValue(0, 9);
                int novoGene = tools.generateRandomValue(0, numVertices);
                filhoGerado.genes.set(posGenesMutacao, novoGene);
            }

        }

    }


}

