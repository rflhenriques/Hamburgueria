package cardapio;

import visitor.IVisitor;

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
        itemBase.aceitar(visitor);
    }
}
