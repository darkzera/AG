import java.util.ArrayList;

public class PopHandling {

    // Encontrar se o filho gerado tem clone na populacao
    public static boolean findClones(Populacao pop, Cromossomo filhoGerado){
        boolean isCloneFound = false;

        for (Cromossomo cromo : pop.cromossomos) {
           if (cromo.getFitness() == filhoGerado.getFitness()) {
               isCloneFound = true;
               return isCloneFound;
           }
        }
        return isCloneFound;
    }

    public static void reinsert(Populacao pop, Cromossomo filhoInserir, Cromossomo pai1, Cromossomo pai2){
        ArrayList cromossPop = pop.cromossomos;
        Cromossomo piorPai = null;
        // Melhor q os dois pais
        if (filhoInserir.getFitness() < pai1.getFitness() && filhoInserir.getFitness() < pai2.getFitness()){
            // set pior pai
            if (pai1.getFitness() > pai2.getFitness()){
                piorPai = pai1;
            } else if (pai1.getFitness() < pai2.getFitness()){
                piorPai = pai2;
            } else if (pai1.getFitness() == pai2.getFitness()){
                piorPai = pai1;
            }
            // Encontrar a pos do pior pai
            // Adicionar o filho no lugar do pior pai
            for (int i = 0; i < pop.cromossomos.size(); i++) {
                if (piorPai.getFitness() == pop.cromossomos.get(i).getFitness()){
                    pop.cromossomos.set(i, filhoInserir);
                }
            }
        } else {
            //
        }


    }



}
