package entities;

abstract public class Produto {
    protected String nome;
    protected String marca;
    protected double preco;
    protected String descricao;

    public Produto(String nome, String marca, double preco, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
