package burgergof.desconto;

import burgergof.model.Pedido;

public class DescontoPromocaoDia extends ProcessadorDesconto {
    private static final String CODIGO = "PROMO10";
    private static final double PCT    = 10.0;

    @Override public double calcular(Pedido p, String cupom) {
        if (CODIGO.equalsIgnoreCase(cupom)) {
            double total = p.calcularTotal() * (1 - PCT / 100);
            System.out.println("[Chain] DescontoPromocaoDia -" + (int)PCT + "% → R$ " + String.format("%.2f", total));
            return total;
        }
        System.out.println("[Chain] DescontoPromocaoDia: não aplicável, passando adiante...");
        return passarAdiante(p, cupom);
    }
}
