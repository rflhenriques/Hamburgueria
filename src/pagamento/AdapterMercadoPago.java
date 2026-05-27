package pagamento;

/**
 * <<Adapter>>
 * Adapta a interface incompatível da MercadoPagoAPI
 * para a interface IEstrategiaPagamento do nosso sistema.
 * O sistema nunca fala diretamente com a API externa.
 */
public class AdapterMercadoPago implements IEstrategiaPagamento {

    private final MercadoPagoAPI apiExterna;

    public AdapterMercadoPago() {
        this.apiExterna = new MercadoPagoAPI();
        System.out.println("[Adapter] AdapterMercadoPago inicializado.");
    }

    @Override
    public boolean processar(double valor) {
        System.out.println("[Adapter] Convertendo chamada interna → formato MercadoPago...");

        // Traduz do formato interno para o formato da API externa
        MercadoPagoRequest request = new MercadoPagoRequest(
            valor,
            "CREDIT_CARD",
            "BURGERGOF-" + System.currentTimeMillis()
        );

        MercadoPagoResponse response = apiExterna.sendPaymentRequest(request);

        System.out.println("[Adapter] Resposta recebida: " + response.getMessage());
        return response.isApproved();
    }

    @Override
    public String getDescricao() {
        return "Cartão via Mercado Pago";
    }
}
