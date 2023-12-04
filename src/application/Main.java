package application;

import entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();
        LeitorArquivo leitorArquivo = new LeitorArquivo();

        ArrayList<Produto> produtos = leitorArquivo.lerProdutos("arquivos/produtos.txt");
        ArrayList<Cliente> clientes = leitorArquivo.lerClientes("arquivos/clientes.txt");

        for (Produto produto: produtos) {
            loja.adicionarAoEstoque(produto);
        }

        int opcao;
        while (true) {
            System.out.println("\n********************************************************************");
            System.out.println("------------------Bem vindo a Dev Guitar Shop!--------------------");
            System.out.println("********************************************************************");
            System.out.println("----------------Escolha uma opção ao seu desejo na loja------------");
            System.out.println(">   1. Visualizar Estoque   <");
            System.out.println(">   2. Adicionar Produto ao carrinho  <");
            System.out.println(">   3. Visualizar Carrinho   <");
            System.out.println(">   4. Remover Produto do carrinho  <");
            System.out.println(">   5. Efetuar Compra   <");
            System.out.println(">   6. Histórico de Compras  <");
            System.out.println(">   7. Ver clientes da Loja   <");
            System.out.println(">   0. Sair da Loja   <");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                loja.visualizarEstoque();
            }
            if (opcao == 2) {
                System.out.print("Digite o seu nome: ");
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
            if(opcao == 3) {
                System.out.print("Digite o seu nome: ");
                String nomeClienteCarrinho = sc.nextLine();
                Cliente clienteCarrinho = null;
                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeClienteCarrinho)) {
                        clienteCarrinho = cliente;
                        break;
                    }
                }
                if (clienteCarrinho == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                loja.visualizarCarrinho(clienteCarrinho);
            }
            if (opcao == 4) {
                System.out.print("Digite o seu nome: ");
                String nomeClienteRemover = sc.nextLine();
                Cliente clienteRemover = null;
                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeClienteRemover)) {
                        clienteRemover = cliente;
                        break;
                    }
                }
                if (clienteRemover == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                loja.removerDoCarrinho(clienteRemover);
            }
            if (opcao == 5) {
                System.out.print("Digite o seu nome: ");
                String nomeClienteCompra = sc.nextLine();
                Cliente clienteCompra = null;
                for (Cliente c : clientes) {
                    if (c.getNome().equals(nomeClienteCompra)) {
                        clienteCompra = c;
                    }
                }
                if (clienteCompra == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                loja.processarCompra(clienteCompra);
            }
            if (opcao == 6) {
                System.out.print("Digite o seu nome: ");
                String nomeClienteHistorico = sc.nextLine();
                Cliente clienteHistorico = null;
                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeClienteHistorico)) {
                        clienteHistorico = cliente;
                        break;
                    }
                }
                if (clienteHistorico == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                loja.exibirHistoricoDeCompras(clienteHistorico);
            }
            if (opcao == 7) {
                for (Cliente cliente: clientes) {
                    System.out.println(cliente.descricaoCliente());
                }
            }
            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }
        }
    }
}