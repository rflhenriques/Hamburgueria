package desconto;

import model.Pedido;

/**
 * <<ConcreteHandler>> (Chain of Responsibility)
 * Aplica desconto especial autorizado pelo gerente (código "GERENTE50").
 */
public class DescontoGerente extends ProcessadorDesconto {

    private static final String CODIGO  = "GERENTE50";
    private static final double PERCENT = 50.0;

    @Override
    public double calcular(Pedido pedido, String codigoCupom) {
        if (CODIGO.equalsIgnoreCase(codigoCupom)) {
            double desconto = pedido.calcularTotal() * (PERCENT / 100.0);
            double total    = pedido.calcularTotal() - desconto;
            System.out.println("[Chain] DescontoGerente aplicado: -"
                    + PERCENT + "% → R$ "
                    + String.format("%.2f", total));
            return total;
        }
        System.out.println("[Chain] DescontoGerente: cupom não reconhecido, "
                + "passando adiante...");
        return passarAdiante(pedido, codigoCupom);
    }
}
