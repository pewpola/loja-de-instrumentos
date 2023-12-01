package entities;

abstract public class Produto {

    protected int id;
    protected String tipo;
    protected String marca;
    protected String modelo;
    protected double preco;

    public Produto(int id, String tipo, String marca, String modelo, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPreco() {
        return preco;
    }

    public String getModelo() {
        return modelo;
    }

    public String descricaoProduto() {
        return id + " " + tipo + " " + marca + " "+ modelo + " por R$ " + preco;
    }

    public String descricaoProdutoSemId() {
        return tipo + " " + marca + " "+ modelo + " por R$ " + preco;
    }
}
