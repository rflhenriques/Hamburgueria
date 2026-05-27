package iterator;

import cardapio.IItemCardapio;

public interface IIterador {
    boolean temProximo();
    IItemCardapio proximo();
    void reiniciar();
}
