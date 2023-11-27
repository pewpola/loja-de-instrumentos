package interfaces;

import entities.Produto;

public interface CarrinhoDeCompras {
    public void adicionarAoCarrinho(Produto produto);
    public void removerDoCarrinho(Produto produto);
    public void editarCarrinho(Produto produtoAntigo, Produto produtoNovo);
}
