package entities;

public class Instrumento extends Produto{
    private String modelo;

    public Instrumento(String nome, String marca, double preco, String descricao, String modelo) {
        super(nome, marca, preco, descricao);
        this.modelo = modelo;
    }
}
