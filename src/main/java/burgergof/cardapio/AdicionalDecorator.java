package burgergof.cardapio;

import burgergof.visitor.IVisitor;

/**
 * <<Decorator>> (classe abstrata)
 * Adiciona funcionalidades extras a um item do cardápio de forma dinâmica.
 * Mantém uma referência ao item decorado e delega chamadas,
 * adicionando comportamento antes ou depois.
 */
public abstract class AdicionalDecorator implements IItemCardapio {

    protected IItemCardapio itemBase;

    public AdicionalDecorator(IItemCardapio itemBase) {
        this.itemBase = itemBase;
    }

    @Override
    public double getPreco() {
        return itemBase.getPreco();
    }

    @Override
    public String getDescricao() {
        return itemBase.getDescricao();
    }

    @Override
    public void aceitar(IVisitor visitor) {
        // O decorator é transparente para o Visitor
        itemBase.aceitar(visitor);
    }
}
