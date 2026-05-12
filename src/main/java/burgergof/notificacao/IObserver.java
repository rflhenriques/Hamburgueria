package burgergof.notificacao;

import burgergof.model.Pedido;

/**
 * <<Observer>>
 * Interface dos observadores do pedido.
 * Implementações concretas na Parte 4.
 */
public interface IObserver {
    void atualizar(Pedido pedido);
}
