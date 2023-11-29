package interfaces;

import entities.Cliente;
import entities.Produto;

public interface CarrinhoDeCompras {
    public void adicionarAoCarrinho(Cliente cliente, Produto produto);
    public void removerDoCarrinho(Produto produto);
    public void editarCarrinho(Produto produtoAntigo, Produto produtoNovo);

}
