package burgergof.desconto;

import burgergof.model.Pedido;

/**
 * <<ConcreteHandler>> (Chain of Responsibility)
 * Aplica desconto da promoção do dia (código "PROMO10").
 */
public class DescontoPromocaoDia extends ProcessadorDesconto {

    private static final String CODIGO  = "PROMO10";
    private static final double PERCENT = 10.0;

    @Override
    public double calcular(Pedido pedido, String codigoCupom) {
        if (CODIGO.equalsIgnoreCase(codigoCupom)) {
            double desconto = pedido.calcularTotal() * (PERCENT / 100.0);
            double total    = pedido.calcularTotal() - desconto;
            System.out.println("[Chain] DescontoPromocaoDia aplicado: -"
                    + PERCENT + "% → R$ "
                    + String.format("%.2f", total));
            return total;
        }
        System.out.println("[Chain] DescontoPromocaoDia: cupom não reconhecido, "
                + "passando adiante...");
        return passarAdiante(pedido, codigoCupom);
    }
}
