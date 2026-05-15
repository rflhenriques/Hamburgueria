package burgergof.atendimento;

import burgergof.model.Pedido;

public class CaixaReal implements IOperacaoCaixa {

    private String operadorAtual;
    private boolean aberto = false;

    @Override
    public boolean cancelarPedido(Pedido pedido, String senhaOperador) {
        System.out.println("[CaixaReal] Cancelando pedido #" + pedido.getId());
        pedido.cancelar();
        return true;
    }

    @Override
    public boolean estornarPagamento(Pedido pedido, String senhaOperador) {
        System.out.println("[CaixaReal] Estornando R$ "
                + String.format("%.2f", pedido.getTotalPago())
                + " do pedido #" + pedido.getId());
        return true;
    }

    @Override
    public void abrirCaixa(String operador) {
        this.operadorAtual = operador;
        this.aberto = true;
        System.out.println("[CaixaReal] Caixa aberto pelo operador: " + operador);
    }

    @Override
    public void fecharCaixa() {
        this.aberto = false;
        System.out.println("[CaixaReal] Caixa fechado. Operador: " + operadorAtual);
    }

    public boolean isAberto() {
        return aberto;
    }
}
