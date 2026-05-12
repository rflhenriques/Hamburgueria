package burgergof.pagamento;

/**
 * <<ConcreteStrategy>>
 * Pagamento via cartão de crédito/débito.
 * Utiliza o AdapterMercadoPago para comunicar com a API externa.
 */
public class PagamentoCartao implements IEstrategiaPagamento {

    private static final double TAXA_CREDITO = 0.035; // 3.5%
    private final AdapterMercadoPago adapter;

    public PagamentoCartao() {
        this.adapter = new AdapterMercadoPago();
    }

    @Override
    public boolean processar(double valor) {
        double taxa       = valor * TAXA_CREDITO;
        double valorFinal = valor + taxa;

        System.out.println("[Strategy/Cartão] Valor original: R$ "
                + String.format("%.2f", valor));
        System.out.println("[Strategy/Cartão] Taxa operadora (3,5%): R$ "
                + String.format("%.2f", taxa));
        System.out.println("[Strategy/Cartão] Valor final: R$ "
                + String.format("%.2f", valorFinal));

        return adapter.processar(valorFinal);
    }

    @Override
    public String getDescricao() {
        return "Cartão de Crédito (taxa 3,5% via Mercado Pago)";
    }
}
