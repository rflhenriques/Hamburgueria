package notificacao;

/**
 * <<Abstraction>> (Bridge)
 * Define o tipo de notificação independente do canal de envio.
 * A separação entre abstração e implementação é o coração do Bridge:
 * pode-se trocar o canal sem alterar o tipo de notificação e vice-versa.
 */
public abstract class Notificacao {

    // Referência para a implementação — o "bridge"
    protected IPlataformaEnvio plataforma;

    public Notificacao(IPlataformaEnvio plataforma) {
        this.plataforma = plataforma;
    }

    public void setPlataforma(IPlataformaEnvio plataforma) {
        this.plataforma = plataforma;
    }

    public abstract void enviar(String destinatario, String detalhe);
}
