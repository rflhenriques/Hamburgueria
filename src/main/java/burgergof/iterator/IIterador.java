package burgergof.iterator;

import burgergof.cardapio.IItemCardapio;

public interface IIterador {
    boolean temProximo();
    IItemCardapio proximo();
    void reiniciar();
}
