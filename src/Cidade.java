public class Cidade {
    private int x, y;
    private String nome;

    @Override
    public String toString() {
        return "[" +
                "x=" + x +
                ", y=" + y +
                ", nome='" + nome + '\'' +
                ']';
    }

    public Cidade(int x, int y, String nome) {
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

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
