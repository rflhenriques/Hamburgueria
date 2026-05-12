package burgergof.pagamento;

/**
 * <<Adaptee>> (Adapter)
 * Simula a API externa do Mercado Pago.
 * Possui interface incompatível com o sistema da hamburgueria.
 * Esta classe não pode ser modificada — é de terceiros.
 */
public class MercadoPagoAPI {

    public MercadoPagoResponse sendPaymentRequest(MercadoPagoRequest request) {
        System.out.println("[MercadoPagoAPI] Processando pagamento externo...");
        System.out.println("[MercadoPagoAPI] Valor: " + request.getAmount());
        System.out.println("[MercadoPagoAPI] Método: " + request.getPaymentMethod());

        // Simula aprovação
        MercadoPagoResponse response = new MercadoPagoResponse();
        response.setStatusCode(200);
        response.setMessage("APPROVED");
        return response;
    }
}
