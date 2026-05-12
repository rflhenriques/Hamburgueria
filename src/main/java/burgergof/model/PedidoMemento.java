package burgergof.model;

import burgergof.cardapio.IItemCardapio;
import java.util.List;

/**
 * <<Memento>>
 * Armazena um snapshot imutável da lista de itens do pedido.
 * Utilizado pelo Command para desfazer ações no carrinho.
 */
public class PedidoMemento {

    private final List<IItemCardapio> itensSalvos;

    public PedidoMemento(List<IItemCardapio> itens) {
        this.itensSalvos = itens;
    }

    public List<IItemCardapio> getItensSalvos() {
        return itensSalvos;
    }
}
