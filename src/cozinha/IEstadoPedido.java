package cozinha;

import model.Pedido;

/**
 * <<State>>
 * Interface dos estados do pedido.
 * Implementação completa dos estados concretos na Parte 4.
 */
public interface IEstadoPedido {
    void avancar(Pedido pedido);
    void cancelar(Pedido pedido);
    String getNome();
}
