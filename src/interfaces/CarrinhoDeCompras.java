package interfaces;

import entities.Cliente;
import entities.Produto;

import java.util.ArrayList;

public interface CarrinhoDeCompras {
    public void adicionarAoCarrinho(Cliente cliente, Produto produto);
    public void removerDoCarrinho(Cliente cliente);

}
