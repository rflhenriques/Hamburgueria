package notificacao;

/**
 * <<ConcreteImplementor>> (Bridge)
 * Envia notificações via SMS.
 */
public class EnvioSMS implements IPlataformaEnvio {

    @Override
    public void disparar(String destinatario, String mensagem) {
        System.out.println("[SMS] → " + destinatario
                + ": " + mensagem);
    }

    @Override
    public String getNomePlataforma() {
        return "SMS";
    }
}
