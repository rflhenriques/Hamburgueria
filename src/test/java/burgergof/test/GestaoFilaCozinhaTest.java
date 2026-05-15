package burgergof.test;

import burgergof.cozinha.FilaCozinha;
import burgergof.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Fila da Cozinha — Gestão de Pedidos Aguardando Preparo")
class GestaoFilaCozinhaTest {

    private FilaCozinha fila;
    private Pedido pedido1;
    private Pedido pedido2;

    @BeforeEach
    void setUp() {
        fila = new FilaCozinha();
        pedido1 = new Pedido("Cliente 1");
        pedido2 = new Pedido("Cliente 2");
    }

    @Test
    @DisplayName("adicionar() coloca o pedido na fila e tamanho aumenta")
    void testAdicionarPedido() {
        fila.adicionar(pedido1);
        assertEquals(1, fila.tamanho());
        assertFalse(fila.isEmpty());
    }

    @Test
    @DisplayName("proximoPedido() remove e retorna o primeiro pedido adicionado (FIFO)")
    void testProximoPedido() {
        fila.adicionar(pedido1);
        fila.adicionar(pedido2);
        
        Pedido retirado = fila.proximoPedido();
        
        assertSame(pedido1, retirado, "A fila deve respeitar a ordem FIFO");
        assertEquals(1, fila.tamanho());
    }

    @Test
    @DisplayName("proximoPedido() em fila vazia retorna null")
    void testProximoPedidoFilaVazia() {
        assertNull(fila.proximoPedido());
    }

    @Test
    @DisplayName("exibirFila() não lança exceções ao imprimir")
    void testExibirFila() {
        assertDoesNotThrow(() -> fila.exibirFila());
        fila.adicionar(pedido1);
        assertDoesNotThrow(() -> fila.exibirFila());
    }
}
