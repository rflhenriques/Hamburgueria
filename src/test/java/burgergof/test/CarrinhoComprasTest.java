package burgergof.test;

import burgergof.cardapio.FabricaInfoNutricional;
import burgergof.cardapio.Produto;
import burgergof.carrinho.*;
import burgergof.model.Carrinho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Command + Memento")
class CarrinhoComprasTest {

    private Carrinho            carrinho;
    private GerenciadorComandos gerenciador;
    private Produto             item;

    @BeforeEach void setUp() {
        carrinho    = new Carrinho();
        gerenciador = new GerenciadorComandos();
        item        = new Produto("Batata Frita", 10.00, "Acompanhamento",
                FabricaInfoNutricional.getInfo("Batata Frita"));
    }

    @Test @DisplayName("Executar ComandoAdicionarItem adiciona item ao carrinho")
    void testAdicionarItem() {
        gerenciador.executar(new ComandoAdicionarItem(carrinho, item));
        assertEquals(1, carrinho.getItens().size());
    }

    @Test @DisplayName("Desfazer ComandoAdicionarItem remove item do carrinho")
    void testDesfazerAdicionar() {
        gerenciador.executar(new ComandoAdicionarItem(carrinho, item));
        gerenciador.desfazerUltimo();
        assertEquals(0, carrinho.getItens().size());
    }

    @Test @DisplayName("Limpar e desfazer restaura itens")
    void testDesfazerLimpar() {
        gerenciador.executar(new ComandoAdicionarItem(carrinho, item));
        carrinho.limpar();
        assertEquals(0, carrinho.getItens().size());
        carrinho.desfazer();
        assertEquals(1, carrinho.getItens().size());
    }

    @Test @DisplayName("Desfazer sem histórico não lança exceção")
    void testDesfazerVazio() {
        assertDoesNotThrow(() -> gerenciador.desfazerUltimo());
    }
}
