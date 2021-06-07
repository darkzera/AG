package CaxeiroViajante;

public class Roleta {

    public static PopulacaoCaminhos roletaCidades(PopulacaoCaminhos p){
        PopulacaoCaminhos pais = new PopulacaoCaminhos();
        double fitTotal = 0;
        int numSelecionado = 0;

        for (Caminho caminho : p.getCaminhosPopulacao()){
            fitTotal += caminho.fitness;
        }

        for (Caminho caminho : p.getCaminhosPopulacao()){
            caminho.calcChance(fitTotal);
        }

        while (numSelecionado != 2) {
            double sumAptd = 0;
            double numRoleta = Math.random() * 100;
            for (Caminho caminho : p.getCaminhosPopulacao()) {
                sumAptd += caminho.chance;
                if (sumAptd >= numRoleta) {
                    pais.caminhosPopulacao.add(caminho);
                    numSelecionado++;
                    break;
                    // garantindo que o algoritmo nao selecione o mesmo cromossomo
                } else if (sumAptd >= numRoleta && pais.caminhosPopulacao.contains(caminho)) {
                    break;
                }
            }
        }
        return pais;
    }

//    public static Populacao roleta(Populacao p) {
//        Populacao pais = new Populacao();
//        double fitTotal = 0;
//        int numSelecionado = 0;
//        for (Cromossomo cromo : p.cromossomos){
//            fitTotal += cromo.fitness;
//        }
//
//        for (Cromossomo cromo : p.cromossomos){
//            cromo.calcChance(fitTotal);
//        }
//
//        while (numSelecionado != 2) {
//            double sumAptd = 0;
//            double numRoleta = Math.random() * 100;
//            for (Cromossomo cromo : p.cromossomos) {
//                sumAptd += cromo.chance;
//                if (sumAptd >= numRoleta) {
//                    pais.cromossomos.add(cromo);
//                    numSelecionado++;
//                    break;
//                    // garantindo que o algoritmo nao selecione o mesmo cromossomo
//                } else if (sumAptd >= numRoleta && pais.cromossomos.contains(cromo)) {
//                    break;
//                }
//            }
//        }
//        return pais;
//    }


}
