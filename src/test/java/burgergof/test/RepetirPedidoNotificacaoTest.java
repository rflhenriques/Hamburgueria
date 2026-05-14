package burgergof.test;

import burgergof.cardapio.FabricaInfoNutricional;
import burgergof.cardapio.Produto;
import burgergof.model.Pedido;
import burgergof.notificacao.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Prototype + Bridge")
class RepetirPedidoNotificacaoTest {

    @Test @DisplayName("Clone é uma instância diferente com mesmos itens")
    void testCloneInstanciaDiferente() {
        Pedido.resetContador();
        Pedido original = new Pedido("João");
        original.adicionarItem(new Produto("Burger", 20.00, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico")));
        Pedido clone = original.clone();
        assertNotSame(original, clone);
        assertEquals(original.getItens().size(), clone.getItens().size());
    }

    @Test @DisplayName("Clone é deep copy — modificar clone não afeta original")
    void testCloneDeepCopy() {
        Pedido.resetContador();
        Pedido original = new Pedido("João");
        Produto item = new Produto("Burger", 20.00, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico"));
        original.adicionarItem(item);
        Pedido clone = original.clone();
        clone.removerItem(item);
        assertEquals(1, original.getItens().size());
        assertEquals(0, clone.getItens().size());
    }

    @Test @DisplayName("Bridge envia notificação pelo canal correto")
    void testBridgeWhatsApp() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Notificacao n = new NotificacaoPedidoPronto(new EnvioWhatsApp());
        n.enviar("João", "Pedido #1");
        System.setOut(System.out);
        assertTrue(out.toString().contains("WhatsApp"));
    }

    @Test @DisplayName("Bridge troca canal em tempo de execução")
    void testBridgeTrocaCanal() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Notificacao n = new NotificacaoPedidoPronto(new EnvioWhatsApp());
        n.setPlataforma(new EnvioSMS());
        n.enviar("Maria", "Pedido #2");
        System.setOut(System.out);
        assertTrue(out.toString().contains("SMS"));
        assertFalse(out.toString().contains("WhatsApp"));
    }
}
