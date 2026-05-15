package burgergof.test;

import burgergof.atendimento.TotemFacade;
import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;
import burgergof.model.Carrinho;
import burgergof.model.Pedido;
import burgergof.pagamento.IEstrategiaPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Facade — TotemAtendimentoFacade (Simulando o Totem da Hamburgueria)")
class TotemAtendimentoFacadeTest {

    private TotemFacade facade;
    private Carrinho carrinho;
    private Produto burger;

    @BeforeEach
    void setUp() {
        facade = new TotemFacade();
        carrinho = new Carrinho();
        burger = new Produto("Burger Clássico", 22.90, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico"));
        carrinho.adicionarItem(burger);
    }

    @Test
    @DisplayName("finalizarPedido() com pagamento aprovado retorna pedido na cozinha")
    void testFinalizarPedidoComSucesso() {
        IEstrategiaPagamento pagamentoOk = valor -> true;
        
        Pedido pedido = facade.finalizarPedido(carrinho, "Cliente Teste", pagamentoOk, Collections.emptyList());
        
        assertNotNull(pedido, "Pedido não deveria ser nulo com pagamento aprovado");
        assertEquals("Cliente Teste", pedido.getNomeCliente());
        assertEquals("NA_COZINHA", pedido.getEstadoAtual().getNome(), "Pedido deveria ter avançado para NA_COZINHA");
        assertEquals(22.90, pedido.getTotalPago(), 0.01);
    }

    @Test
    @DisplayName("finalizarPedido() com pagamento recusado retorna null")
    void testFinalizarPedidoComPagamentoRecusado() {
        IEstrategiaPagamento pagamentoRecusado = valor -> false;
        
        Pedido pedido = facade.finalizarPedido(carrinho, "Cliente Sem Saldo", pagamentoRecusado, null);
        
        assertNull(pedido, "Pedido deveria ser nulo quando o pagamento é recusado");
    }

    @Test
    @DisplayName("finalizarPedido() associa observers corretamente")
    void testFinalizarPedidoComObservers() {
        IEstrategiaPagamento pagamentoOk = valor -> true;
        boolean[] notificado = {false};
        
        Pedido pedido = facade.finalizarPedido(carrinho, "Cliente Notificado", pagamentoOk, 
            Collections.singletonList(p -> notificado[0] = true));
            
        assertNotNull(pedido);
        
        // Aciona o observer alterando o estado
        pedido.avancarEstado(); 
        
        assertTrue(notificado[0], "Observer deveria ter sido notificado da mudança de estado");
    }
}
