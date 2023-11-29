package entities;

import interfaces.CadastroProduto;

import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> estoque;
    private ArrayList<Pedido> pedidos;

    public Loja() {
        this.estoque = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void adicionarAoEstoque(Produto produto) {
        estoque.add(produto);
    }

    public void visualizarEstoque() {
        System.out.println("Estoque da loja:");
        for (Produto produto : estoque) {
            System.out.println("- " + produto.getDescricao() + " - R$ " + produto.getPreco());
        }
    }

    public void adicionarAoCarrinho(Cliente cliente, Produto produto) {
        cliente.adicionarAoCarrinho(produto);
        System.out.println(produto.getDescricao() + " adicionado ao carrinho de " + cliente.getNome());
    }

    public void processarCompra(Cliente cliente, String data, String hora) {
        if (cliente.getCarrinho().isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de finalizar a compra.");
            return;
        }

        Pedido pedido = new Pedido(cliente, data, hora);
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
                System.out.println("Data: " + java.time.LocalDateTime.now());
                System.out.println("Itens do Pedido:");
                for (Produto produto : pedido.getItens()) {
                    System.out.println("- " + produto.getDescricao() + ", Preço: R$ " + produto.getPreco());
                }
                System.out.println("Total do Pedido: R$ " + pedido.calcularTotal());
                System.out.println("------------------------------");
            }
        }
    }

    private void processarPedido(Pedido pedido) {
        for (Produto item : pedido.getItens()) {
            estoque.remove(item);
        }

        pedidos.add(pedido);

        System.out.println("Pedido processado para " + pedido.getCliente().getNome() +
                ". Total: R$ " + pedido.calcularTotal());
    }

    public void cadastrarProduto(String nome, String marca, double preco, String descricao, boolean isInstrumento) {
        Produto produto;
        if (isInstrumento) {
            System.out.print("Digite o modelo do instrumento: ");
            //String modelo = scanner.next();
            //produto = new Instrumento(nome, marca, preco, descricao, modelo);
        } else {
            System.out.print("Digite o material do acessório: ");
            //String material = scanner.next();
            //produto = new Acessorio(nome, marca, preco, descricao, material);
        }
        //adicionarAoEstoque(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
}
