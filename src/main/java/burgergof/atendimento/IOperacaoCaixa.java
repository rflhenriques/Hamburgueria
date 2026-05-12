package burgergof.atendimento;

import burgergof.model.Pedido;

/**
 * <<Subject>> (Proxy)
 * Interface compartilhada entre o caixa real e o proxy de autorização.
 * Garante que o proxy seja transparente para quem o usa.
 */
public interface IOperacaoCaixa {
    boolean cancelarPedido(Pedido pedido, String senhaOperador);
    boolean estornarPagamento(Pedido pedido, String senhaOperador);
    void abrirCaixa(String operador);
    void fecharCaixa();
}
