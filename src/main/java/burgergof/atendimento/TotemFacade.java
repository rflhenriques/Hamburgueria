package burgergof.atendimento;

import burgergof.cardapio.IItemCardapio;
import burgergof.model.Carrinho;
import burgergof.model.Pedido;
import burgergof.pagamento.IEstrategiaPagamento;
import burgergof.estoque.GerenciadorEstoque;
import burgergof.cozinha.FilaCozinha;
import burgergof.notificacao.IObserver;

/**
 * <<Facade>>
 * Simplifica a interface do sistema de atendimento para o cliente.
 * Esconde a complexidade de interagir com múltiplos subsistemas:
 * estoque, pagamento, cozinha, notificação.
 */
public class TotemFacade {

    private final GerenciadorEstoque estoque;
    private final FilaCozinha        filaCozinha;

    public TotemFacade() {
        this.estoque      = GerenciadorEstoque.getInstancia();
        this.filaCozinha  = new FilaCozinha();
        System.out.println("[Facade] TotemFacade inicializado.");
    }

    /**
     * Fluxo completo simplificado: o cliente só chama este método.
     * Internamente, coordena múltiplos subsistemas.
     */
    public Pedido finalizarPedido(Carrinho carrinho, String nomeCliente, 
                                   IEstrategiaPagamento estrategiaPagamento,
                                   java.util.List<IObserver> observers) {
        
        System.out.println("\n[Facade] Iniciando processamento do pedido...");

        // 1. Valida estoque
        if (!validarEstoque(carrinho)) {
            System.out.println("[Facade] ❌ Pedido cancelado: itens fora de estoque.");
            return null;
        }

        // 2. Cria o pedido
        Pedido pedido = new Pedido(nomeCliente);
        if (observers != null) {
            for (IObserver obs : observers) {
                pedido.addObserver(obs);
            }
        }
        for (IItemCardapio item : carrinho.getItens()) {
            pedido.adicionarItem(item);
        }

        // 3. Processa pagamento
        double total = pedido.calcularTotal();
        boolean pagamentoOk = estrategiaPagamento.processar(total);
        
        if (!pagamentoOk) {
            System.out.println("[Facade] ❌ Pagamento recusado.");
            return null;
        }

        pedido.setTotalPago(total);

        // 4. Baixa estoque
        baixarEstoque(carrinho);

        // 5. Envia para cozinha
        pedido.avancarEstado(); // muda para PAGO
        pedido.avancarEstado(); // muda para NA_COZINHA
        filaCozinha.adicionar(pedido);

        System.out.println("[Facade] ✅ Pedido #" + pedido.getId() + " finalizado com sucesso!");
        System.out.println("[Facade] Total pago: R$ " + String.format("%.2f", total));
        
        return pedido;
    }

    private boolean validarEstoque(Carrinho carrinho) {
        // Simplificação: assume que todos os itens estão disponíveis
        // Em produção, consulta GerenciadorEstoque
        return true;
    }

    private void baixarEstoque(Carrinho carrinho) {
        // Simplificação: delega para o GerenciadorEstoque
        System.out.println("[Facade] Estoque atualizado.");
    }
}
