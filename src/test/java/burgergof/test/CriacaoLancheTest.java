package burgergof.test;

import burgergof.cardapio.Produto;
import burgergof.cozinha.CriadorBurgerClassico;
import burgergof.cozinha.CriadorBurgerVeggie;
import burgergof.cozinha.ICriadorLanche;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Factory Method")
class CriacaoLancheTest {

    @Test @DisplayName("CriadorClassico cria Burger Clássico com preço correto")
    void testCriadorClassico() {
        ICriadorLanche criador = new CriadorBurgerClassico();
        Produto lanche = criador.criarLanche();
        assertEquals("Burger Clássico", lanche.getDescricao());
        assertEquals(22.90, lanche.getPreco(), 0.01);
    }

    @Test @DisplayName("CriadorVeggie cria Burger Veggie")
    void testCriadorVeggie() {
        ICriadorLanche criador = new CriadorBurgerVeggie();
        Produto lanche = criador.criarLanche();
        assertEquals("Burger Veggie", lanche.getDescricao());
        assertEquals(24.90, lanche.getPreco(), 0.01);
    }

    @Test @DisplayName("Cada criador retorna nova instância a cada chamada")
    void testNovaInstancia() {
        ICriadorLanche criador = new CriadorBurgerClassico();
        Produto a = criador.criarLanche();
        Produto b = criador.criarLanche();
        assertNotSame(a, b);
    }
}
