package CaxeiroViajante;

public class Cidade {
    private int x, y;
    private String nome;


    // Calculca distancia de <this> cidade para CaxeiroViajante.Cidade recebida por parametro
    public double rangeToCidade(Cidade c){
//        int _x = Math.abs(this.x - c.x);
//        int _y = Math.abs(this.y - c.y);
//        double distancia = Math.sqrt(Math.pow(_x, 2) + Math.pow(_y, 2));
//        return distancia;

        double deltaXSq = Math.pow((c.getX() - this.getX()), 2);
        double deltaYSq = Math.pow((c.getY() - this.getY()), 2);
        double distance = Math.sqrt(Math.abs(deltaXSq + deltaYSq));
        return distance;


    }

    public boolean compair(Cidade c){
        if (c.getX() == this.getX() && c.getY() == getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " [" +
                "X: " + x +
                " " +
                "Y: " + y +
                "]";
    }

    public String print(){
        return "[X: " + x + "] ";
    }

    public Cidade(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Cidade(int x, int y, String nome) {
        this.x = x;
        this.y = y;
        this.nome = nome;
    }
    public Cidade(){}

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
