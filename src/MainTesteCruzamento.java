import java.util.ArrayList;
import java.util.Random;

public class MainTesteCruzamento {
    public static void main(String[] args) {
        Caminho c1 = new Caminho();
        Caminho c2 = new Caminho();
        ArrayList<Cidade> cidades = new ArrayList<>();
        ArrayList<Cidade> cidades2 = new ArrayList<>();
        PopulacaoCaminhos p = new PopulacaoCaminhos();



        cidades2.add(new Cidade(120, 120));
        for (int i = 0; cidades.size() < 100; i++) {
            cidades.add(new Cidade(i, i));
        }
        c1.setCaminho(cidades);
        System.out.println(c1.sequenciaCidades.size());
        for (int i = 101; cidades2.size() < 100; i++) {
            cidades2.add(new Cidade(i, i));
        }
        c2.setCaminho(cidades2);
        System.out.println(c2.sequenciaCidades.size());
        p.addCaminho(c1);
        p.addCaminho(c2);

        System.out.println(c1.toString()+ "\n" + c2.toString() + "\nb");
        Cruzamento.cruzCaix(p).findRepetidos();


    }
}
