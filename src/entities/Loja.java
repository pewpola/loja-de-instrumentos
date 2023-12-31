package entities;

import interfaces.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja implements CarrinhoDeCompras {
    private ArrayList<Produto> estoque;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Cliente> clientes;

    Scanner sc = new Scanner(System.in);

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

    @Override
    public void adicionarAoCarrinho(Cliente cliente, Produto produto) {
        cliente.adicionarAoCarrinho(produto);
        System.out.println(produto.descricaoProduto() + " adicionado ao carrinho de " + cliente.getNome());
    }

    @Override
    public void removerDoCarrinho(Cliente cliente) {
        ArrayList<Produto> carrinho = cliente.getCarrinho();

        if (carrinho.isEmpty()) {
            System.out.println(cliente.getNome() + " não possui itens no carrinho por enquanto.");
            return;
        }

        System.out.println("Carrinho de " + cliente.getNome() + ":");
        for (int i = 0; i < carrinho.size(); i++) {
            Produto produto = carrinho.get(i);
            System.out.println((i + 1) + ". " + produto.descricaoProdutoSemId());
        }

        System.out.print("Digite o número do produto que deseja remover: ");
        int numeroProduto = sc.nextInt();

        if (numeroProduto < 1 || numeroProduto > carrinho.size()) {
            System.out.println("Número de item inválido.");
            return;
        }

        carrinho.remove(numeroProduto - 1);
        System.out.println("Item removido com sucesso.");
    }

    public void processarCompra(Cliente cliente) {
        if (cliente.getCarrinho().isEmpty()) {
            System.out.println("O seu Carrinho está vazio. Adicione produtos para poder efetuar uma compra.");
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
        System.out.println("Histórico de compras para o cliente " + cliente.getNome() + ":");
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente() == cliente) {
                System.out.println("Data e Hora: " + pedido.getDataEHorario());
                System.out.println("Itens do Pedido:");
                for (Produto produto : pedido.getItens()) {
                    System.out.println("- " + produto.descricaoProdutoSemId() + ", Preço: R$ " + produto.getPreco());
                }
                System.out.println("Valor Total do Pedido: R$ " + pedido.calcularTotal());
                System.out.println("======================================================");
            }
        }
    }

    public void processarPedido(Pedido pedido) {
        for (Produto item : pedido.getItens()) {
            estoque.remove(item);
        }

        pedidos.add(pedido);

        if (!clientes.contains(pedido.getCliente())) {
            clientes.add(pedido.getCliente());
        }

        System.out.println("Pedido efetuado para " + pedido.getCliente().getNome() +
                ". Total a pagar: R$ " + pedido.calcularTotal() +
                ". Data e Hora: " + pedido.getDataEHorario());
    }

    public void visualizarCarrinho(Cliente cliente) {
        ArrayList<Produto> carrinho = cliente.getCarrinho();

        if (carrinho.isEmpty()) {
            System.out.println(cliente.getNome() + " não possui itens no carrinho.");
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("Carrinho de " + cliente.getNome() + ":");
            for (Produto produto : carrinho) {
                System.out.println("- " + produto.descricaoProdutoSemId());
            }
            System.out.println("Total do Carrinho: R$ " + calcularTotalCarrinho(carrinho));
            System.out.println("----------------------------------------------");
        }
    }

    private double calcularTotalCarrinho(ArrayList<Produto> carrinho) {
        double total = 0.0;
        for (Produto produto : carrinho) {
            total += produto.getPreco();
        }
        return total;
    }
}
