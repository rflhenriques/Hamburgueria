package burgergof.atendimento;

import burgergof.model.Pedido;

/**
 * <<Proxy>>
 * Controla o acesso às operações sensíveis do caixa.
 * Exige senha de gerente antes de delegar para o CaixaReal.
 * O cliente nunca acessa o CaixaReal diretamente.
 */
public class ProxyAutorizacaoGerente implements IOperacaoCaixa {

    private final CaixaReal   caixaReal;
    private final String      senhaGerente;

    public ProxyAutorizacaoGerente(String senhaGerente) {
        this.caixaReal    = new CaixaReal();
        this.senhaGerente = senhaGerente;
    }

    private boolean autenticar(String senhaFornecida) {
        boolean ok = senhaGerente.equals(senhaFornecida);
        if (!ok) {
            System.out.println("[Proxy] ❌ Acesso negado: senha de gerente incorreta.");
        } else {
            System.out.println("[Proxy] ✅ Gerente autenticado com sucesso.");
        }
        return ok;
    }

    @Override
    public boolean cancelarPedido(Pedido pedido, String senhaOperador) {
        System.out.println("[Proxy] Tentativa de cancelamento do pedido #"
                + pedido.getId());
        if (!autenticar(senhaOperador)) return false;
        return caixaReal.cancelarPedido(pedido, senhaOperador);
    }

    @Override
    public boolean estornarPagamento(Pedido pedido, String senhaOperador) {
        System.out.println("[Proxy] Tentativa de estorno do pedido #"
                + pedido.getId());
        if (!autenticar(senhaOperador)) return false;
        return caixaReal.estornarPagamento(pedido, senhaOperador);
    }

    @Override
    public void abrirCaixa(String operador) {
        // Abertura de caixa não exige senha de gerente
        caixaReal.abrirCaixa(operador);
    }

    @Override
    public void fecharCaixa() {
        caixaReal.fecharCaixa();
    }
}
