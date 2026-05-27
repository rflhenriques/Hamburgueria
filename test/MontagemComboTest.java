package test;

import cardapio.Combo;
import cozinha.FabricaComboClassico;
import cozinha.FabricaComboVeggie;
import cozinha.IFabricaCombo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Abstract Factory")
class MontagemComboTest {

    @Test @DisplayName("Combo Clássico não contém produtos veganos")
    void testComboClassicoNaoVegano() {
        IFabricaCombo fab = new FabricaComboClassico();
        assertFalse(fab.criarBurger().getDescricao().contains("Veggie"));
        assertEquals("Refrigerante", fab.criarBebida().getDescricao());
        assertEquals("Batata Frita", fab.criarAcompanhamento().getDescricao());
    }

    @Test @DisplayName("Combo Veggie não contém itens de origem animal")
    void testComboVeggieNaoAnimal() {
        IFabricaCombo fab = new FabricaComboVeggie();
        assertEquals("Burger Veggie", fab.criarBurger().getDescricao());
        assertEquals("Suco Natural",  fab.criarBebida().getDescricao());
        assertEquals("Onion Rings",   fab.criarAcompanhamento().getDescricao());
        assertEquals("Brownie",       fab.criarSobremesa().getDescricao());
    }

    @Test @DisplayName("Preço do combo com 10% desconto é calculado corretamente")
    void testPrecoComboComDesconto() {
        IFabricaCombo fab = new FabricaComboClassico();
        Combo combo = new Combo("Combo Clássico", 10.0);
        combo.adicionar(fab.criarBurger());
        combo.adicionar(fab.criarBebida());
        combo.adicionar(fab.criarAcompanhamento());
        combo.adicionar(fab.criarSobremesa());
        double esperado = (22.90 + 7.00 + 10.00 + 8.00) * 0.90;
        assertEquals(esperado, combo.getPreco(), 0.01);
    }
}
