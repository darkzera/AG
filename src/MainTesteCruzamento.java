import java.util.*;

public class MainTesteCruzamento {
    public static void main(String[] args) {
        Caminho c1 = new Caminho();
        Caminho c2 = new Caminho();
        ArrayList<Cidade> cidades = new ArrayList<>();
        ArrayList<Cidade> cidades2 = new ArrayList<>();
        PopulacaoCaminhos p = new PopulacaoCaminhos();
        Cidade c = new Cidade(3,3);
        cidades.add(c);
        c = new Cidade(7, 7);
        cidades.add(c);
        c = new Cidade(5, 5);
        cidades.add(c);
        c = new Cidade(1, 1);
        cidades.add(c);
        c = new Cidade(6, 6);
        cidades.add(c);
        c = new Cidade(8, 8);
        cidades.add(c);
        c = new Cidade(2, 2);
        cidades.add(c);
        c = new Cidade(4, 4);
        cidades.add(c);
        cidades2 = new ArrayList<>();
        cidades2.addAll(cidades);
        Collections.sort(cidades2, new Comparator<Cidade>() {
            @Override
            public int compare(Cidade o1, Cidade o2) {
                if (o1.getX() > o2.getX()){
                    return 1;
                } else if (o1.getX() < o2.getX()){
                    return -1;
                }
                return 0;
            }
        });
        c = new Cidade();

        Caminho path = new Caminho();
        path.sequenciaCidades = cidades;
        path.inicio = c;
        p.addCaminho(path);
        path = new Caminho();
        path.sequenciaCidades = cidades2;
        path.inicio = c;
        p.addCaminho(path);


        Caminho filho = Cruzamento.cruzCaix(p);
        System.out.println(filho.toString());






    }
}
