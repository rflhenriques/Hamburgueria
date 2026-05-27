package test;

import interpreter.InterpretadorPedido;
import model.Carrinho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Interpreter")
class ChatbotAtendimentoTest {

    private InterpretadorPedido interpretador;
    private Carrinho            carrinho;

    @BeforeEach void setUp() {
        interpretador = new InterpretadorPedido();
        carrinho      = new Carrinho();
    }

    @Test @DisplayName("Interpreta '1 classico' e adiciona 1 item")
    void testUmClassico() {
        interpretador.interpretar("1 classico", carrinho);
        assertEquals(1, carrinho.getItens().size());
    }

    @Test @DisplayName("Interpreta '2 batata' e adiciona 2 itens")
    void testDoisItens() {
        interpretador.interpretar("2 batata", carrinho);
        assertEquals(2, carrinho.getItens().size());
    }

    @Test @DisplayName("Interpreta 'refri' e adiciona refrigerante")
    void testRefri() {
        interpretador.interpretar("refri", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Refrigerante", carrinho.getItens().get(0).getDescricao());
    }

    @Test @DisplayName("Token inválido não lança exceção")
    void testTokenInvalido() {
        assertDoesNotThrow(() -> interpretador.interpretar("xyz abc", carrinho));
        assertEquals(0, carrinho.getItens().size());
    }
}
