package cardapio;

public class CheddarDecorator extends AdicionalDecorator {

    private static final double PRECO_CHEDDAR = 2.50;

    public CheddarDecorator(IItemCardapio itemBase) {
        super(itemBase);
    }

    @Override
    public double getPreco() {
        return itemBase.getPreco() + PRECO_CHEDDAR;
    }

    @Override
    public String getDescricao() {
        return itemBase.getDescricao() + " + Cheddar";
    }
}
