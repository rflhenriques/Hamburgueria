package notificacao;

import model.Pedido;

/**
 * <<ConcreteObserver>>
 * Aplicativo do cliente que exibe notificações em tempo real.
 * Usa o Bridge para enviar pelo canal preferido do cliente.
 */
public class AppCliente implements IObserver {

    private final String        nomeCliente;
    private final Notificacao   notificacao; // Bridge

    public AppCliente(String nomeCliente, Notificacao notificacao) {
        this.nomeCliente  = nomeCliente;
        this.notificacao  = notificacao;
    }

    @Override
    public void atualizar(Pedido pedido) {
        String estado  = pedido.getEstadoAtual().getNome();
        String detalhe = "Pedido #" + pedido.getId();

        System.out.println("[Observer/AppCliente:" + nomeCliente
                + "] Notificando estado: " + estado);

        switch (estado) {
            case "PAGO":
                notificacao.enviar(nomeCliente,
                        detalhe + " — pagamento confirmado!");
                break;
            case "NA_COZINHA":
                notificacao.enviar(nomeCliente,
                        detalhe + " — seu lanche está sendo preparado!");
                break;
            case "PRONTO":
                notificacao.enviar(nomeCliente,
                        detalhe + " — retire no balcão!");
                break;
            case "CANCELADO":
                notificacao.enviar(nomeCliente,
                        detalhe + " — seu pedido foi cancelado.");
                break;
            default:
                break;
        }
    }
}
