package burgergof.cardapio;

import burgergof.visitor.IVisitor;

/**
 * <<Component>> (Composite) + ponto de entrada do <<Visitor>>
 * Interface raiz de todos os itens do cardápio —
 * tanto itens simples (Leaf) quanto combos (Composite).
 */
public interface IItemCardapio {
    double getPreco();
    String getDescricao();

    /**
     * Método aceitar() é obrigatório para o padrão Visitor.
     * Permite que qualquer Visitor percorra a árvore do cardápio.
     */
    void aceitar(IVisitor visitor);
}
