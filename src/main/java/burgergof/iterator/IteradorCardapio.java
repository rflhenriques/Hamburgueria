package burgergof.iterator;

import burgergof.cardapio.Combo;
import burgergof.cardapio.IItemCardapio;

import java.util.ArrayList;
import java.util.List;

/**
 * <<ConcreteIterator>>
 * Percorre a árvore do Composite (itens e combos) de forma
 * linear e sequencial, sem expor a estrutura interna de listas.
 * O front-end (totem, app) usa este iterador para exibir
 * o cardápio sem precisar conhecer a hierarquia de classes.
 */
public class IteradorCardapio implements IIterador {

    private final List<IItemCardapio> itensPlanificados;
    private int posicaoAtual = 0;

    public IteradorCardapio(List<IItemCardapio> raiz) {
        this.itensPlanificados = new ArrayList<>();
        planificar(raiz);
    }

    /**
     * Percorre recursivamente a árvore do Composite,
     * transformando a hierarquia em uma lista linear.
     */
    private void planificar(List<IItemCardapio> itens) {
        for (IItemCardapio item : itens) {
            itensPlanificados.add(item);
            if (item instanceof Combo) {
                // Desce recursivamente nos combos
                planificar(((Combo) item).getItens());
            }
        }
    }

    @Override
    public boolean temProximo() {
        return posicaoAtual < itensPlanificados.size();
    }

    @Override
    public IItemCardapio proximo() {
        if (!temProximo()) {
            throw new java.util.NoSuchElementException(
                "[Iterator] Fim do cardápio atingido."
            );
        }
        return itensPlanificados.get(posicaoAtual++);
    }

    @Override
    public void reiniciar() {
        posicaoAtual = 0;
    }

    public int totalItens() {
        return itensPlanificados.size();
    }
}
