package burgergof.pagamento;

/**
 * Objeto de requisição da API externa do Mercado Pago.
 * Formato incompatível com a interface interna do sistema.
 */
public class MercadoPagoRequest {

    private double amount;
    private String paymentMethod;
    private String externalReference;

    public MercadoPagoRequest(double amount, String paymentMethod, 
                               String externalReference) {
        this.amount            = amount;
        this.paymentMethod     = paymentMethod;
        this.externalReference = externalReference;
    }

    public double getAmount()          { return amount; }
    public String getPaymentMethod()   { return paymentMethod; }
    public String getExternalReference() { return externalReference; }
}
