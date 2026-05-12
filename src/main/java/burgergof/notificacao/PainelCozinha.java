package burgergof.notificacao;

import burgergof.model.Pedido;

/**
 * <<ConcreteObserver>>
 * Painel físico da cozinha que exibe o status dos pedidos.
 * É notificado automaticamente toda vez que um pedido muda de estado.
 */
public class PainelCozinha implements IObserver {

    private final String nomePainel;

    public PainelCozinha(String nomePainel) {
        this.nomePainel = nomePainel;
    }

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[Observer/PainelCozinha:" + nomePainel + "] "
                + "Pedido #" + pedido.getId()
                + " (" + pedido.getNomeCliente() + ") → "
                + pedido.getEstadoAtual().getNome());
    }
}
