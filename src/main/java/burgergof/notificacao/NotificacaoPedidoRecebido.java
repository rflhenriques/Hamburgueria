package burgergof.notificacao;

/**
 * <<RefinedAbstraction>> (Bridge)
 * Notificação específica de pedido recebido.
 */
public class NotificacaoPedidoRecebido extends Notificacao {

    public NotificacaoPedidoRecebido(IPlataformaEnvio plataforma) {
        super(plataforma);
    }

    @Override
    public void enviar(String destinatario, String detalhe) {
        String mensagem = "✅ Pedido recebido! " + detalhe
                + " | Canal: " + plataforma.getNomePlataforma();
        plataforma.disparar(destinatario, mensagem);
    }
}
