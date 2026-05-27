package test;

import atendimento.SistemaHamburgueria;
import estoque.GerenciadorEstoque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Singleton")
class SistemaHamburgueriaTest {

    @Test @DisplayName("SistemaHamburgueria retorna sempre a mesma instância")
    void testMesmaInstancia() {
        SistemaHamburgueria a = SistemaHamburgueria.getInstancia();
        SistemaHamburgueria b = SistemaHamburgueria.getInstancia();
        assertSame(a, b, "Deve ser a mesma referência de memória");
    }

    @Test @DisplayName("GerenciadorEstoque retorna sempre a mesma instância")
    void testEstoqueSingleton() {
        GerenciadorEstoque a = GerenciadorEstoque.getInstancia();
        GerenciadorEstoque b = GerenciadorEstoque.getInstancia();
        assertSame(a, b);
    }

    @Test @DisplayName("Nome do restaurante está correto")
    void testNomeRestaurante() {
        assertEquals("BurgerGoF", SistemaHamburgueria.getInstancia().getNomeRestaurante());
    }
}
