package burgergof.desconto;

import burgergof.model.Pedido;

/**
 * <<ConcreteHandler>> (Chain of Responsibility)
 * Aplica desconto de aniversário (código "ANIVERSARIO").
 */
public class DescontoAniversariante extends ProcessadorDesconto {

    private static final String CODIGO  = "ANIVERSARIO";
    private static final double PERCENT = 20.0;

    @Override
    public double calcular(Pedido pedido, String codigoCupom) {
        if (CODIGO.equalsIgnoreCase(codigoCupom)) {
            double desconto = pedido.calcularTotal() * (PERCENT / 100.0);
            double total    = pedido.calcularTotal() - desconto;
            System.out.println("[Chain] DescontoAniversariante aplicado: -"
                    + PERCENT + "% → R$ "
                    + String.format("%.2f", total));
            return total;
        }
        System.out.println("[Chain] DescontoAniversariante: cupom não reconhecido, "
                + "passando adiante...");
        return passarAdiante(pedido, codigoCupom);
    }
}
