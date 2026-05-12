package burgergof.notificacao;

/**
 * <<ConcreteImplementor>> (Bridge)
 * Envia notificações via e-mail.
 */
public class EnvioEmail implements IPlataformaEnvio {

    @Override
    public void disparar(String destinatario, String mensagem) {
        System.out.println("[Email] → " + destinatario
                + ": " + mensagem);
    }

    @Override
    public String getNomePlataforma() {
        return "Email";
    }
}
