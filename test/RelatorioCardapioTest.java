package test;

import cardapio.*;
import iterator.IteradorCardapio;
import visitor.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Visitor + Iterator")
class RelatorioCardapioTest {

    private Combo combo;
    private Produto batata;

    @BeforeEach void setUp() {
        combo = new Combo("Combo", 0.0);
        combo.adicionar(new Produto("Burger Clássico", 22.90, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico")));
        combo.adicionar(new Produto("Refrigerante", 7.00, "Bebida",
                FabricaInfoNutricional.getInfo("Refrigerante")));
        batata = new Produto("Batata Frita", 10.00, "Acompanhamento",
                FabricaInfoNutricional.getInfo("Batata Frita"));
    }

    @Test @DisplayName("VisitorCalculoCalorias soma calorias sem alterar preços")
    void testVisitorCalorias() {
        VisitorCalculoCalorias v = new VisitorCalculoCalorias();
        combo.aceitar(v);
        assertEquals(650 + 150, v.getTotalCalorias());
    }

    @Test @DisplayName("VisitorCalculoImpostos calcula impostos por categoria")
    void testVisitorImpostos() {
        VisitorCalculoImpostos v = new VisitorCalculoImpostos();
        batata.aceitar(v);
        assertEquals(10.00 * 0.07, v.getTotalImpostos(), 0.001);
    }

    @Test @DisplayName("Iterator planifica combo em itens lineares")
    void testIteradorPlanifica() {
        List<IItemCardapio> cardapio = Arrays.asList(combo, batata);
        IteradorCardapio it = new IteradorCardapio(cardapio);
        assertEquals(4, it.totalItens()); // combo + 2 filhos + batata
    }

    @Test @DisplayName("Iterator percorre todos os itens sem expor estrutura")
    void testIteradorPercorre() {
        List<IItemCardapio> cardapio = Arrays.asList(combo, batata);
        IteradorCardapio it = new IteradorCardapio(cardapio);
        int count = 0;
        while (it.temProximo()) { it.proximo(); count++; }
        assertEquals(4, count);
    }
}
