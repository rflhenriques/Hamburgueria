package burgergof.carrinho;

import burgergof.cardapio.IItemCardapio;
import burgergof.model.Carrinho;

/**
 * <<ConcreteCommand>>
 * Encapsula a ação de remover um item do carrinho.
 * Permite desfazer a remoção via Memento interno do Carrinho.
 */
public class ComandoRemoverItem implements IComando {

    private final Carrinho       carrinho;
    private final IItemCardapio  item;

    public ComandoRemoverItem(Carrinho carrinho, IItemCardapio item) {
        this.carrinho = carrinho;
        this.item     = item;
    }

    @Override
    public void executar() {
        System.out.println("[Command] Executando: remover "
                + item.getDescricao());
        carrinho.removerItem(item);
    }

    @Override
    public void desfazer() {
        System.out.println("[Command] Desfazendo: remover "
                + item.getDescricao());
        carrinho.desfazer();
    }

    @Override
    public String getDescricao() {
        return "Remover " + item.getDescricao();
    }
}
