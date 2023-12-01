package entities;

public class Acessorio extends Produto {
    private String material;

    public Acessorio(int id, String tipo, String marca, String modelo, double preco, String material) {
        super(id, tipo, marca, modelo, preco);
        this.material = material;
    }

}
