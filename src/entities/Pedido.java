package entities;

import interfaces.InterfacePedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido implements InterfacePedido {
    private Cliente cliente;
    private ArrayList<Produto> itens;
    private LocalDateTime dataEHorario;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataEHorario = LocalDateTime.now();
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

    public LocalDateTime getDataEHorario() {
        return dataEHorario;
    }
}
