package pagamento;

/**
 * <<Strategy>>
 * Interface dos algoritmos de pagamento.
 * Implementações concretas na Parte 4.
 */
public interface IEstrategiaPagamento {
    boolean processar(double valor);
    String getDescricao();
}
