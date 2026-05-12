package burgergof.desconto;

import burgergof.model.Pedido;

/**
 * <<ConcreteHandler>> (Chain of Responsibility)
 * Handler final da cadeia — encerra sem aplicar desconto.
 * Evita NullPointerException quando nenhum cupom é válido.
 */
public class SemDescontoHandler extends ProcessadorDesconto {

    @Override
    public double calcular(Pedido pedido, String codigoCupom) {
        System.out.println("[Chain] SemDescontoHandler: cupom \""
                + codigoCupom + "\" inválido. Nenhum desconto aplicado.");
        return pedido.calcularTotal();
    }
}
