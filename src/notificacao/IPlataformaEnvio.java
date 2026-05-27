package notificacao;

/**
 * <<Implementor>> (Bridge)
 * Interface da camada de implementação do Bridge.
 * Define como a mensagem é fisicamente enviada.
 * Totalmente independente da abstração (tipo de notificação).
 */
public interface IPlataformaEnvio {
    void disparar(String destinatario, String mensagem);
    String getNomePlataforma();
}
