package entities;

public class Acessorio extends Produto {
    private String material;

    public Acessorio(String nome, String marca, double preco, String descricao, String material) {
        super(nome, marca, preco, descricao);
        this.material = material;
    }


}
