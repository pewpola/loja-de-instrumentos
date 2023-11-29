package entities;

import entities.Produto;

import java.util.ArrayList;

public class Cliente  {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    private ArrayList<Produto> carrinho;

    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;

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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
        System.out.println(produto + " adicionado ao carrinho");
    }

    public void removerDoCarrinho(Produto produto) {
        carrinho.remove(produto);
    }

    public void editarCarrinho(Produto produtoAntigo, Produto produtoNovo) {
        if (carrinho.contains(produtoAntigo)) {
            carrinho.remove(produtoAntigo);
            carrinho.add(produtoNovo);
            System.out.println("Carrinho editado com sucesso!");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }
}
