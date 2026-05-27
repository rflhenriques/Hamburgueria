package cozinha;

import model.Pedido;

/**
 * <<ConcreteState>>
 * Pedido cancelado — estado final negativo.
 */
public class EstadoCancelado implements IEstadoPedido {

    @Override
    public void avancar(Pedido pedido) {
        throw new IllegalStateException(
            "[State] Pedido cancelado não pode ser avançado."
        );
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State] Pedido #" + pedido.getId()
                + " já está cancelado.");
    }

    @Override
    public String getNome() {
        return "CANCELADO";
    }
}
