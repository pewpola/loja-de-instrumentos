package entities;

import interfaces.CadastroProduto;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Loja implements CadastroProduto {
    private ArrayList<Produto> estoque;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Cliente> clientes;
    private static Scanner scanner = new Scanner(System.in);

    public Loja() {
        this.estoque = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarAoEstoque(Produto produto) {
        estoque.add(produto);
    }

    public void visualizarEstoque() {
        System.out.println("Estoque da loja:");
        for (Produto produto : estoque) {
            System.out.println("- " + produto.descricaoProduto());
        }
    }
    /*
    public void cadastrarProduto(int id, String tipo, String marca, String modelo, double preco) {
        Produto produto;
        if (produto instanceof instrumento) {
            System.out.print("Digite o modelo do instrumento: ");
            String modelo = scanner.next();
            produto = new Instrumento(int id, String tipo, String marca, String modelo, double preco, String tipoDeInstrumento);
        } else {
            System.out.print("Digite o material do acessório: ");
            String material = scanner.next();
            produto = new Acessorio(int id, String tipo, String marca, String modelo, double preco);
        }
        adicionarAoEstoque(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

     */

    public void adicionarAoCarrinho(Cliente cliente, Produto produto) {
        cliente.adicionarAoCarrinho(produto);
        System.out.println(produto.descricaoProduto() + " adicionado ao carrinho de " + cliente.getNome());
    }

    public void processarCompra(Cliente cliente) {
        if (cliente.getCarrinho().isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de finalizar a compra.");
            return;
        }

        Pedido pedido = new Pedido(cliente);
        for (Produto produto : cliente.getCarrinho()) {
            pedido.adicionarItem(produto);
        }

        processarPedido(pedido);
        cliente.getCarrinho().clear();
        System.out.println("Compra realizada com sucesso!");
    }

    public void exibirHistoricoDeCompras(Cliente cliente) {
        System.out.println("Histórico de compras para " + cliente.getNome() + ":");
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente() == cliente) {
                System.out.println("Data e Hora: " + pedido.getDataEHorario());
                System.out.println("Itens do Pedido:");
                for (Produto produto : pedido.getItens()) {
                    System.out.println("- " + produto.descricaoProduto() + ", Preço: R$ " + produto.getPreco());
                }
                System.out.println("Total do Pedido: R$ " + pedido.calcularTotal());
                System.out.println("------------------------------");
            }
        }
    }

    public void processarPedido(Pedido pedido) {
        // Atualiza o estoque (simulação simples)
        for (Produto item : pedido.getItens()) {
            estoque.remove(item);
        }

        // Adiciona o pedido à lista de pedidos
        pedidos.add(pedido);

        // Adiciona o cliente à lista de clientes se ainda não estiver presente
        if (!clientes.contains(pedido.getCliente())) {
            clientes.add(pedido.getCliente());
        }

        System.out.println("Pedido processado para " + pedido.getCliente().getNome() +
                ". Total: R$ " + pedido.calcularTotal() +
                ". Data e Hora: " + pedido.getDataEHorario());
    }
}
