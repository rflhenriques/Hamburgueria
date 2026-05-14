package burgergof.test;

import burgergof.cardapio.FabricaInfoNutricional;
import burgergof.cardapio.InfoNutricional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Flyweight")
class InfoNutricionalCacheTest {

    @Test @DisplayName("Mesma instância de InfoNutricional para mesmo ingrediente")
    void testMesmaInstancia() {
        InfoNutricional a = FabricaInfoNutricional.getInfo("Burger Clássico");
        InfoNutricional b = FabricaInfoNutricional.getInfo("Burger Clássico");
        assertSame(a, b, "Flyweight deve retornar exatamente o mesmo objeto");
    }

    @Test @DisplayName("Instâncias diferentes para ingredientes diferentes")
    void testInstanciasDiferentes() {
        InfoNutricional a = FabricaInfoNutricional.getInfo("Burger Clássico");
        InfoNutricional b = FabricaInfoNutricional.getInfo("Burger Veggie");
        assertNotSame(a, b);
    }

    @Test @DisplayName("Calorias corretas para Burger Clássico")
    void testCaloriasClassico() {
        InfoNutricional info = FabricaInfoNutricional.getInfo("Burger Clássico");
        assertEquals(650, info.getCalorias());
    }

    @Test @DisplayName("Total de instâncias em cache é fixo")
    void testTotalInstancias() {
        assertEquals(9, FabricaInfoNutricional.totalInstancias());
    }
}
