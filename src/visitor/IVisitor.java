package visitor;

import cardapio.Produto;
import cardapio.Combo;

/**
 * <<Visitor>>
 * Interface que declara as operações para cada tipo de elemento
 * da árvore do cardápio. Permite adicionar novas operações
 * sem alterar as classes dos itens.
 */
public interface IVisitor {
    void visitarProduto(Produto produto);
    void visitarCombo(Combo combo);
}
