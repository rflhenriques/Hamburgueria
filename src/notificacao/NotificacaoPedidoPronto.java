package notificacao;

/**
 * <<RefinedAbstraction>> (Bridge)
 * Notificação urgente de pedido pronto para retirada.
 */
public class NotificacaoPedidoPronto extends Notificacao {

    public NotificacaoPedidoPronto(IPlataformaEnvio plataforma) {
        super(plataforma);
    }

    @Override
    public void enviar(String destinatario, String detalhe) {
        String mensagem = "🍔 Seu pedido está PRONTO! " + detalhe
                + " | Retire no balcão.";
        plataforma.disparar(destinatario, mensagem);
    }
}
