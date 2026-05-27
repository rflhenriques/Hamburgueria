package test;

import cardapio.FabricaInfoNutricional;
import cardapio.Produto;
import desconto.*;
import model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Chain of Responsibility")
class CupomDescontoTest {

    private Pedido             pedido;
    private ProcessadorDesconto cadeia;

    @BeforeEach void setUp() {
        Pedido.resetContador();
        pedido = new Pedido("Teste");
        pedido.adicionarItem(new Produto("Item", 100.00, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico")));
        cadeia = FabricaCadeiaDesconto.construir();
    }

    @Test @DisplayName("Cupom inválido não aplica desconto")
    void testCupomInvalido() {
        assertEquals(100.00, cadeia.calcular(pedido, "INVALIDO"), 0.01);
    }

    @Test @DisplayName("Cupom PROMO10 aplica 10% de desconto")
    void testPromo10() {
        assertEquals(90.00, cadeia.calcular(pedido, "PROMO10"), 0.01);
    }

    @Test @DisplayName("Cupom ANIVERSARIO aplica 20% de desconto")
    void testAniversario() {
        assertEquals(80.00, cadeia.calcular(pedido, "ANIVERSARIO"), 0.01);
    }

    @Test @DisplayName("Cupom GERENTE50 aplica 50% de desconto")
    void testGerente50() {
        assertEquals(50.00, cadeia.calcular(pedido, "GERENTE50"), 0.01);
    }

    @Test @DisplayName("Cupom é case-insensitive")
    void testCaseInsensitive() {
        assertEquals(90.00, cadeia.calcular(pedido, "promo10"), 0.01);
    }
}
