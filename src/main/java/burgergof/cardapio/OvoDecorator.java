package burgergof.cardapio;

/**
 * <<ConcreteDecorator>>
 * Adiciona ovo ao lanche.
 */
public class OvoDecorator extends AdicionalDecorator {

    private static final double PRECO_OVO = 2.00;

    public OvoDecorator(IItemCardapio itemBase) {
        super(itemBase);
    }

    @Override
    public double getPreco() {
        return itemBase.getPreco() + PRECO_OVO;
    }

    @Override
    public String getDescricao() {
        return itemBase.getDescricao() + " + Ovo";
    }
}
