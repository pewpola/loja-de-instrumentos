package entities;

import interfaces.InterfaceProduto;

abstract public class Produto implements InterfaceProduto {
    private String nome;
    private String marca;
    private double preco;
    private String descricao;

    public Produto(String nome, String marca, double preco, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getMarca() {
        return this.marca;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
