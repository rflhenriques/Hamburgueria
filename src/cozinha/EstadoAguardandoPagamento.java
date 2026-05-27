package cozinha;

import model.Pedido;

/**
 * <<ConcreteState>>
 * Estado inicial do pedido — aguardando confirmação de pagamento.
 * Implementação completa na Parte 4.
 */
public class EstadoAguardandoPagamento implements IEstadoPedido {

    @Override
    public void avancar(Pedido pedido) {
        System.out.println("[State] Pagamento confirmado. Pedido #"
                + pedido.getId() + " → PAGO.");
        pedido.setEstado(new EstadoPago());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("[State] Pedido #" + pedido.getId() + " cancelado.");
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String getNome() {
        return "AGUARDANDO_PAGAMENTO";
    }
}
