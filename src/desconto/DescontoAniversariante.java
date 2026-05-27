package desconto;

import model.Pedido;

public class DescontoAniversariante extends ProcessadorDesconto {
    private static final String CODIGO = "ANIVERSARIO";
    private static final double PCT    = 20.0;

    @Override public double calcular(Pedido p, String cupom) {
        if (CODIGO.equalsIgnoreCase(cupom)) {
            double total = p.calcularTotal() * (1 - PCT / 100);
            System.out.println("[Chain] DescontoAniversariante -" + (int)PCT + "% → R$ " + String.format("%.2f", total));
            return total;
        }
        System.out.println("[Chain] DescontoAniversariante: não aplicável, passando adiante...");
        return passarAdiante(p, cupom);
    }
}
