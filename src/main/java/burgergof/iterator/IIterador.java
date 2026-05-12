package burgergof.iterator;

import burgergof.cardapio.IItemCardapio;

/**
 * <<Iterator>>
 * Interface do iterador do cardápio.
 * Permite percorrer qualquer coleção de itens
 * sem expor sua estrutura interna.
 */
public interface IIterador {
    boolean temProximo();
    IItemCardapio proximo();
    void reiniciar();
}
