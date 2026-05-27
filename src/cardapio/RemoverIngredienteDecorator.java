package cardapio;

/**
 * <<ConcreteDecorator>>
 * Remove um ingrediente do lanche (ex: sem cebola, sem molho).
 * Não altera o preço, apenas a descrição.
 */
public class RemoverIngredienteDecorator extends AdicionalDecorator {

    private final String ingredienteRemovido;

    public RemoverIngredienteDecorator(IItemCardapio itemBase, String ingrediente) {
        super(itemBase);
        this.ingredienteRemovido = ingrediente;
    }

    @Override
    public String getDescricao() {
        return itemBase.getDescricao() + " (sem " + ingredienteRemovido + ")";
    }

    // Preço não muda ao remover ingrediente
    @Override
    public double getPreco() {
        return itemBase.getPreco();
    }
}
