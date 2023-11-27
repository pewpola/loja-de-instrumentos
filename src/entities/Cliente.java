package entities;

import interfaces.CarrinhoDeCompras;

import java.util.ArrayList;

abstract public class Cliente implements CarrinhoDeCompras {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private ArrayList<Produto> carrinho;

    public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.carrinho = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    @Override
    public void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    @Override
    public void removerDoCarrinho(Produto produto) {
        carrinho.remove(produto);
    }
}
