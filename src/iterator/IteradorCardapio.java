package iterator;

import cardapio.Combo;
import cardapio.IItemCardapio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IteradorCardapio implements IIterador {
    private final List<IItemCardapio> itensPlanificados = new ArrayList<>();
    private int posicao = 0;

    public IteradorCardapio(List<IItemCardapio> raiz) { planificar(raiz); }

    private void planificar(List<IItemCardapio> itens) {
        for (IItemCardapio item : itens) {
            itensPlanificados.add(item);
            if (item instanceof Combo) planificar(((Combo) item).getItens());
        }
    }

    @Override public boolean temProximo()  { return posicao < itensPlanificados.size(); }
    @Override public void reiniciar()      { posicao = 0; }
    @Override public IItemCardapio proximo() {
        if (!temProximo()) throw new NoSuchElementException("[Iterator] Fim do cardápio.");
        return itensPlanificados.get(posicao++);
    }
    public int totalItens() { return itensPlanificados.size(); }
}
