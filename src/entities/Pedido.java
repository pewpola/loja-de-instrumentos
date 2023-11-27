package entities;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Produto> itens;
    private String data;
    private String hora;

    public Pedido(Cliente cliente, String data, String hora) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.data = data;
        this.hora = hora;
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
}
