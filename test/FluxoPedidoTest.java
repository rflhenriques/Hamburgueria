package test;

import cardapio.FabricaInfoNutricional;
import cardapio.Produto;
import cozinha.*;
import model.Pedido;
import notificacao.IObserver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("State + Observer")
class FluxoPedidoTest {

    @Test @DisplayName("Estado inicial é AGUARDANDO_PAGAMENTO")
    void testEstadoInicial() {
        Pedido.resetContador();
        Pedido p = new Pedido("Teste");
        assertEquals("AGUARDANDO_PAGAMENTO", p.getEstadoAtual().getNome());
    }

    @Test @DisplayName("Avanço de estado segue a sequência correta")
    void testSequenciaEstados() {
        Pedido.resetContador();
        Pedido p = new Pedido("Teste");
        p.avancarEstado(); assertEquals("PAGO",        p.getEstadoAtual().getNome());
        p.avancarEstado(); assertEquals("NA_COZINHA",  p.getEstadoAtual().getNome());
        p.avancarEstado(); assertEquals("PRONTO",      p.getEstadoAtual().getNome());
        p.avancarEstado(); assertEquals("ENTREGUE",    p.getEstadoAtual().getNome());
    }

    @Test @DisplayName("Cancelar em estado NaCozinha lança IllegalStateException")
    void testCancelarNaCozinha() {
        Pedido.resetContador();
        Pedido p = new Pedido("Teste");
        p.avancarEstado(); // PAGO
        p.avancarEstado(); // NA_COZINHA
        assertThrows(IllegalStateException.class, p::cancelar);
    }

    @Test @DisplayName("Observer é notificado a cada mudança de estado")
    void testObserverNotificado() {
        Pedido.resetContador();
        List<String> estadosCapturados = new ArrayList<>();
        Pedido p = new Pedido("Teste");
        p.adicionarItem(new Produto("Item", 10.00, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico")));

        IObserver observer = pedido -> estadosCapturados.add(pedido.getEstadoAtual().getNome());
        p.addObserver(observer);

        p.avancarEstado(); // PAGO → notifica
        p.avancarEstado(); // NA_COZINHA → notifica

        assertEquals(2, estadosCapturados.size());
        assertEquals("PAGO",       estadosCapturados.get(0));
        assertEquals("NA_COZINHA", estadosCapturados.get(1));
    }
}
