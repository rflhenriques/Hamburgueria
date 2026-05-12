package burgergof.cozinha;

import burgergof.model.Pedido;

/**
 * <<ConcreteState>>
 * Pedido pago — pronto para entrar na fila da cozinha.
 */
public class EstadoPago implements IEstadoPedido {

    @Override
    public void avancar(Pedido pedido) {
        System.out.println("[State] Pedido #" + pedido.getId()
                + " → NA_COZINHA.");
        pedido.setEstado(new EstadoNaCozinha());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State] Pedido pago não pode ser cancelado sem estorno. "
                + "Acione o gerente.");
        // Proxy de autorização será acionado neste ponto
    }

    @Override
    public String getNome() {
        return "PAGO";
    }
}
