package cardapio;

public class BaconDecorator extends AdicionalDecorator {

    private static final double PRECO_BACON = 3.00;

    public BaconDecorator(IItemCardapio itemBase) {
        super(itemBase);
    }

    @Override
    public double getPreco() {
        return itemBase.getPreco() + PRECO_BACON;
    }

    @Override
    public String getDescricao() {
        return itemBase.getDescricao() + " + Bacon";
    }
}
