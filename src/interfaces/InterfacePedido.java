package interfaces;

import entities.Produto;

public interface InterfacePedido {
    public void adicionarItem(Produto produto);
    public double calcularTotal();
}
