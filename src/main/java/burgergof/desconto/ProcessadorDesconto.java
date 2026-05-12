package burgergof.desconto;

import burgergof.model.Pedido;

/**
 * <<Handler>> (Chain of Responsibility)
 * Classe abstrata base da cadeia de descontos.
 * Cada handler tenta aplicar seu desconto; se não conseguir,
 * passa para o próximo da cadeia.
 */
public abstract class ProcessadorDesconto {

    protected ProcessadorDesconto proximo;

    public ProcessadorDesconto setProximo(ProcessadorDesconto proximo) {
        this.proximo = proximo;
        return proximo; // permite encadeamento fluente
    }

    public abstract double calcular(Pedido pedido, String codigoCupom);

    protected double passarAdiante(Pedido pedido, String codigoCupom) {
        if (proximo != null) {
            return proximo.calcular(pedido, codigoCupom);
        }
        return pedido.calcularTotal();
    }
}
