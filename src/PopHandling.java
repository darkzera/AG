import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class PopHandling {


    // Retorna o Caminho (Indiv.) com o melhor fitness da populacao
    public static Caminho bestFit(PopulacaoCaminhos p){
        // Melhor fit -> MENOR fitness
        double menorFit = Double.MAX_VALUE;
        for (Caminho camin : p.caminhosPopulacao) {
            if (menorFit > camin.getFitness()){
                menorFit = camin.getFitness();
            }
        }

        for (Caminho camin : p.caminhosPopulacao) {
            if (menorFit == camin.getFitness()){
                return camin;
            }
        }
        return null;
    }

    public static Caminho worstFit(PopulacaoCaminhos p) {
        // Pior fit -> MAIOR fit
        double maiorFit = Double.MIN_VALUE;
        for (Caminho camin : p.caminhosPopulacao){
            if (maiorFit < camin.getFitness()){
                maiorFit = camin.getFitness();
            }
        }
        for (Caminho camin : p.caminhosPopulacao) {
            if (maiorFit == camin.getFitness()){
                return camin;
            }
        }
       return null;
    }

    public static void reinsert(PopulacaoCaminhos pop, PopulacaoCaminhos pais, Caminho filhoGerado){
        double paiFitness = pais.caminhosPopulacao.get(0).getFitness();
        double pai2Fitness = pais.caminhosPopulacao.get(1).getFitness();
        Caminho piorPai = null;
        // Melhor que os dois pais
        if (filhoGerado.getFitness() < paiFitness && filhoGerado.getFitness() < pai2Fitness) {
            // Se pai1 tiver o fit MELHOR (menor que) pai2
            // Inserir filho na pos pai2
            if (paiFitness < pai2Fitness) {
                piorPai = pais.caminhosPopulacao.get(1);
            } else {
                piorPai = pais.caminhosPopulacao.get(0);
            }
            seekSwap(pop, piorPai, filhoGerado);
        }else {
//            seekSwap(pop, worstFit(pop), filhoGerado);
        }

    }

    public static void seekSwap(PopulacaoCaminhos pop, Caminho caminhoRmv, Caminho caminhoAdd ){
        for (int i = 0; i < pop.caminhosPopulacao.size(); i++) {
            if (pop.caminhosPopulacao.get(i).getFitness() == caminhoRmv.getFitness()){
//                System.out.println("------------ TROCA ------------------");
//                System.out.println("Vaaai sair: " + pop.caminhosPopulacao.get(i).getFitness());
                pop.caminhosPopulacao.set(i, caminhoAdd);
//                System.out.println("Vai entrar: " + caminhoAdd.getFitness());
                return;
            }
        }
    }

    // Verdadeiro: descartar
    // Fals: prox. fase (inserir() filho)
    public static boolean findClone(PopulacaoCaminhos pop, Caminho filho){
        for (Caminho caminho : pop.caminhosPopulacao) {
            // Existe um clone do FILHO a inserir dentro da populacao
            // Descartar Filho
            caminho.findRepetidos();
            if (caminho.getFitness() == filho.getFitness()){
                return true;
            }
        }
        return false;
    }

    public static Cidade loadCidadesFromArray(int[][] map, ArrayList<Cidade> cidadesLoad){
        Cidade cidadeInicio = new Cidade();
        for (int i = 0; i < map.length; i++) {
            Cidade cidadeAdd = new Cidade();
            // A primeira cidade (coordenada x,y) do arquivo é setado como cidade INICIAL
            if (cidadesLoad.size() == 0) {
                cidadeInicio = cidadeAdd;
            }
            cidadeAdd.setX(map[i][0]);
            cidadeAdd.setY(map[i][1]);
            cidadesLoad.add(cidadeAdd);
        }
        // Remover cidade start do array
        cidadesLoad.remove(0);

        return cidadeInicio;
    }

    public static PopulacaoCaminhos generateBasicPopulation(int tamanhoPopulacao, int qtdCidadesMap){
        // Mapeamento com as cidades default
        int map[][] = tools.mapCities(qtdCidadesMap);
        ArrayList<Cidade> cidadesLoad = new ArrayList();
        Cidade cidadeInicio = new Cidade();
        cidadeInicio = loadCidadesFromArray(map, cidadesLoad);
        PopulacaoCaminhos popInicial = new PopulacaoCaminhos();
        for (int i = 0; i < tamanhoPopulacao; i++) {
            // Array com a posicao dos genes
            // random sequencia de cidades p/ Caminhos/Rotas (possiveis - pop inicial)
            popInicial.caminhosPopulacao.add(new Caminho());
            ArrayList<Cidade> cities = cidadesLoad;
            Collections.shuffle(cities);
            popInicial.caminhosPopulacao.get(i).setInicio(cidadeInicio);
            for (Cidade c : cities) {
                popInicial.caminhosPopulacao.get(i).sequenciaCidades.add(c);
            }
            popInicial.caminhosPopulacao.get(i).setFitness(); // TODO: LOADFITNESS
        }
        return popInicial;
    }

    /////////////// P-med
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

    // P-med
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
