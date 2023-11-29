package application;

import entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();

        ArrayList<Produto> produtos = LeitorArquivo.lerProdutos("arquivos/produtos.txt");
        ArrayList<Cliente> clientes = LeitorArquivo.lerClientes("arquivos/clientes.txt");

        for (Produto produto: produtos) {
            loja.adicionarAoEstoque(produto);
        }

        for (Cliente cliente: clientes) {
            System.out.println(cliente.getNome());
        }

        int opcao;
        while (true) {
            System.out.println("\n********************************************************************");
            System.out.println("------------------Bem vindo a Dev Guitar Shop!--------------------");
            System.out.println("********************************************************************");
            System.out.println("----------------Escolha uma opção ao seu desejo na loja------------");
            System.out.println(">   1. Visualizar Estoque   <");
            System.out.println(">   2. Adicionar Produto ao carrinho  <");
            System.out.println(">   0. Sair da Loja   <");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                loja.visualizarEstoque();
            }
            if (opcao == 2) {
                System.out.print("Nome do cliente: ");
                String nomeCliente = sc.nextLine();
                Cliente cliente = null;
                for (Cliente c : clientes) {
                    if (c.getNome().equals(nomeCliente)) {
                        cliente = c;
                        break;
                    }
                }
                if (cliente == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                loja.visualizarEstoque();
                System.out.print("Digite o id do produto para adicionar ao carrinho: ");
                int idProdutoCarrinho = sc.nextInt();
                Produto produtoCarrinho = null;
                for (Produto p : produtos) {
                    if (p.getId() == idProdutoCarrinho) {
                        produtoCarrinho = p;
                        break;
                    }
                }
                if (produtoCarrinho == null) {
                    System.out.println("Produto não encontrado.");
                    break;
                }
                loja.adicionarAoCarrinho(cliente, produtoCarrinho);
                loja.visualizarCarrinho(cliente);
            }
            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }
        }
    }
}