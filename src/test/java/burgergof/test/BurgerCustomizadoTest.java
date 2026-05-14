package burgergof.test;

import burgergof.cardapio.Produto;
import burgergof.cozinha.DiretorCozinha;
import burgergof.cozinha.IBuilderLanche;
import burgergof.cozinha.MontadorBurgerCustomizado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Builder")
class BurgerCustomizadoTest {

    private IBuilderLanche builder;
    private DiretorCozinha diretor;

    @BeforeEach void setUp() {
        builder = new MontadorBurgerCustomizado();
        diretor = new DiretorCozinha(builder);
    }

    @Test @DisplayName("Duplo Bacon contém Bacon e Cheddar na descrição")
    void testDuploBacon() {
        Produto p = diretor.construirDuploBacon();
        assertTrue(p.getDescricao().contains("Bacon"));
        assertTrue(p.getDescricao().contains("Cheddar"));
    }

    @Test @DisplayName("Duplo Bacon tem preço correto: base(18+8) + bacon(3) + cheddar(2.5)")
    void testDuploBaconPreco() {
        Produto p = diretor.construirDuploBacon();
        assertEquals(33.50, p.getPreco(), 0.01);
    }

    @Test @DisplayName("Lanche vegano contém 'sem Molho Especial'")
    void testVegano() {
        Produto p = diretor.construirVegano();
        assertTrue(p.getDescricao().contains("sem Molho Especial"));
    }

    @Test @DisplayName("Reset limpa o builder corretamente")
    void testReset() {
        builder.addAdicional("Bacon", 3.00);
        builder.reset();
        Produto p = builder.getResultado();
        assertEquals(18.00, p.getPreco(), 0.01);
    }
}
