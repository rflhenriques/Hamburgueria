package burgergof.cozinha;

import burgergof.model.Pedido;

/**
 * <<ConcreteState>>
 * Pedido entregue ao cliente — estado final positivo.
 */
public class EstadoEntregue implements IEstadoPedido {

    @Override
    public void avancar(Pedido pedido) {
        System.out.println("[State] Pedido #" + pedido.getId()
                + " já foi entregue. Nenhuma ação disponível.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException(
            "[State] Pedido já entregue não pode ser cancelado."
        );
    }

    @Override
    public String getNome() {
        return "ENTREGUE";
    }
}
