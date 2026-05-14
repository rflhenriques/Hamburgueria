package burgergof.test;

import burgergof.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Composite + Decorator")
class CardapioAdicionaisTest {

    @Test @DisplayName("Preço do Combo é soma dos filhos com desconto")
    void testPrecoCombo() {
        Combo combo = new Combo("Teste", 10.0);
        combo.adicionar(new Produto("Item1", 10.00, "Hambúrguer", FabricaInfoNutricional.getInfo("Burger Clássico")));
        combo.adicionar(new Produto("Item2", 10.00, "Bebida",     FabricaInfoNutricional.getInfo("Refrigerante")));
        assertEquals(18.00, combo.getPreco(), 0.01); // (10+10)*0.9
    }

    @Test @DisplayName("Decorator BaconDecorator acumula preço corretamente")
    void testBaconDecorator() {
        Produto base = new Produto("Burger", 20.00, "Hambúrguer", FabricaInfoNutricional.getInfo("Burger Clássico"));
        IItemCardapio comBacon = new BaconDecorator(base);
        assertEquals(23.00, comBacon.getPreco(), 0.01);
        assertTrue(comBacon.getDescricao().contains("+ Bacon"));
    }

    @Test @DisplayName("Múltiplos decorators acumulam preços e descrições")
    void testMultiplosDecorators() {
        Produto base = new Produto("Burger", 20.00, "Hambúrguer", FabricaInfoNutricional.getInfo("Burger Clássico"));
        IItemCardapio dec = new OvoDecorator(new CheddarDecorator(new BaconDecorator(base)));
        assertEquals(27.50, dec.getPreco(), 0.01); // 20+3+2.5+2
        assertTrue(dec.getDescricao().contains("+ Bacon"));
        assertTrue(dec.getDescricao().contains("+ Cheddar"));
        assertTrue(dec.getDescricao().contains("+ Ovo"));
    }

    @Test @DisplayName("RemoverIngredienteDecorator não altera preço")
    void testRemoverIngrediente() {
        Produto base = new Produto("Burger", 20.00, "Hambúrguer", FabricaInfoNutricional.getInfo("Burger Clássico"));
        IItemCardapio semAlface = new RemoverIngredienteDecorator(base, "Alface");
        assertEquals(20.00, semAlface.getPreco(), 0.01);
        assertTrue(semAlface.getDescricao().contains("sem Alface"));
    }
}
