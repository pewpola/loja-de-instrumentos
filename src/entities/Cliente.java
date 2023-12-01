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

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public String descricaoCliente() {
        return "Nome: " + nome + "; CPF: " + cpf + "; E-mail: " + email + "; Telefone: " + telefone;
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
    }
}
