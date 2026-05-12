package burgergof.pagamento;

/**
 * <<ConcreteStrategy>>
 * Pagamento em dinheiro — calcula troco automaticamente.
 */
public class PagamentoDinheiro implements IEstrategiaPagamento {

    private final double valorEntregue;

    public PagamentoDinheiro(double valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    @Override
    public boolean processar(double valor) {
        System.out.println("[Strategy/Dinheiro] Valor do pedido: R$ "
                + String.format("%.2f", valor));
        System.out.println("[Strategy/Dinheiro] Valor entregue: R$ "
                + String.format("%.2f", valorEntregue));

        if (valorEntregue < valor) {
            System.out.println("[Strategy/Dinheiro] ❌ Valor insuficiente.");
            return false;
        }

        double troco = valorEntregue - valor;
        System.out.println("[Strategy/Dinheiro] ✅ Pagamento aceito. Troco: R$ "
                + String.format("%.2f", troco));
        return true;
    }

    @Override
    public String getDescricao() {
        return "Dinheiro (troco calculado automaticamente)";
    }
}
