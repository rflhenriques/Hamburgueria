package test;

import atendimento.ProxyAutorizacaoGerente;
import cardapio.FabricaInfoNutricional;
import cardapio.Produto;
import model.Pedido;
import pagamento.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Strategy + Adapter + Proxy")
class PagamentoECaixaTest {

    @Test @DisplayName("PIX processa com sucesso sem taxa")
    void testPix() {
        assertTrue(new PagamentoPix().processar(50.00));
    }

    @Test @DisplayName("Cartão processa com sucesso via Adapter")
    void testCartao() {
        assertTrue(new PagamentoCartao().processar(50.00));
    }

    @Test @DisplayName("Dinheiro suficiente é aceito")
    void testDinheiroSuficiente() {
        assertTrue(new PagamentoDinheiro(60.00).processar(50.00));
    }

    @Test @DisplayName("Dinheiro insuficiente é recusado")
    void testDinheiroInsuficiente() {
        assertFalse(new PagamentoDinheiro(30.00).processar(50.00));
    }

    @Test @DisplayName("Adapter MercadoPago retorna aprovado")
    void testAdapter() {
        assertTrue(new AdapterMercadoPago().processar(100.00));
    }

    @Test @DisplayName("Proxy bloqueia acesso com senha errada")
    void testProxySenhaErrada() {
        Pedido.resetContador();
        ProxyAutorizacaoGerente proxy = new ProxyAutorizacaoGerente("admin123");
        Pedido p = new Pedido("Teste");
        p.adicionarItem(new Produto("Item", 10.00, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico")));
        p.setTotalPago(10.00);
        assertFalse(proxy.cancelarPedido(p, "senhaErrada"));
    }

    @Test @DisplayName("Proxy permite acesso com senha correta")
    void testProxySenhaCorreta() {
        Pedido.resetContador();
        ProxyAutorizacaoGerente proxy = new ProxyAutorizacaoGerente("admin123");
        Pedido p = new Pedido("Teste");
        p.adicionarItem(new Produto("Item", 10.00, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico")));
        p.setTotalPago(10.00);
        assertTrue(proxy.cancelarPedido(p, "admin123"));
    }
}
