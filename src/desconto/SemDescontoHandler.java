package desconto;

import model.Pedido;

public class SemDescontoHandler extends ProcessadorDesconto {
    @Override public double calcular(Pedido p, String cupom) {
        System.out.println("[Chain] Cupom \"" + cupom + "\" inválido. Nenhum desconto.");
        return p.calcularTotal();
    }
}
