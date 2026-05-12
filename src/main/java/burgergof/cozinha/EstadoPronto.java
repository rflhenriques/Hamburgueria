package burgergof.cozinha;

import burgergof.model.Pedido;

/**
 * <<ConcreteState>>
 * Pedido pronto para retirada.
 */
public class EstadoPronto implements IEstadoPedido {

    @Override
    public void avancar(Pedido pedido) {
        System.out.println("[State] Pedido #" + pedido.getId()
                + " → ENTREGUE.");
        pedido.setEstado(new EstadoEntregue());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException(
            "[State] Operação inválida: pedido pronto não pode ser cancelado."
        );
    }

    @Override
    public String getNome() {
        return "PRONTO";
    }
}
