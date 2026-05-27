package model;

import cardapio.IItemCardapio;
import java.util.List;

public class PedidoMemento {

    private final List<IItemCardapio> itensSalvos;

    public PedidoMemento(List<IItemCardapio> itens) {
        this.itensSalvos = itens;
    }

    public List<IItemCardapio> getItensSalvos() {
        return itensSalvos;
    }
}
