package test;

import interpreter.*;
import model.Carrinho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Interpreter — InterpretadorTotem (Processamento de Voz/Texto)")
class InterpretadorTotemTest {

    private InterpretadorPedido interpretador;
    private Carrinho            carrinho;

    @BeforeEach
    void setUp() {
        interpretador = new InterpretadorPedido();
        carrinho      = new Carrinho();
    }

    // ── Itens simples ──────────────────────────────────────────────────

    @Test
    @DisplayName("'classico' — adiciona 1 Burger Clássico ao carrinho")
    void testClassicoSimples() {
        interpretador.interpretar("classico", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Burger Clássico", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'veggie' — adiciona 1 Burger Veggie ao carrinho")
    void testVeggieSimples() {
        interpretador.interpretar("veggie", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Burger Veggie", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'batata' — adiciona Batata Frita ao carrinho")
    void testBatataSimples() {
        interpretador.interpretar("batata", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Batata Frita", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'refri' — adiciona Refrigerante ao carrinho")
    void testRefriSimples() {
        interpretador.interpretar("refri", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Refrigerante", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'refrigerante' — adiciona Refrigerante ao carrinho")
    void testRefrigeranteSimples() {
        interpretador.interpretar("refrigerante", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Refrigerante", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'suco' — adiciona Suco Natural ao carrinho")
    void testSucoSimples() {
        interpretador.interpretar("suco", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Suco Natural", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'sorvete' — adiciona Sorvete ao carrinho")
    void testSorveteSimples() {
        interpretador.interpretar("sorvete", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Sorvete", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'brownie' — adiciona Brownie ao carrinho")
    void testBrownieSimples() {
        interpretador.interpretar("brownie", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Brownie", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'fritas' — adiciona Batata Frita ao carrinho")
    void testFritas() {
        interpretador.interpretar("fritas", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Batata Frita", carrinho.getItens().get(0).getDescricao());
    }

    @Test
    @DisplayName("'onion' — adiciona Onion Rings ao carrinho")
    void testOnionRings() {
        interpretador.interpretar("onion", carrinho);
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Onion Rings", carrinho.getItens().get(0).getDescricao());
    }

    // ── Quantidade ─────────────────────────────────────────────────────

    @Test
    @DisplayName("'1 classico' — adiciona exatamente 1 item")
    void testQuantidadeUm() {
        interpretador.interpretar("1 classico", carrinho);
        assertEquals(1, carrinho.getItens().size());
    }

    @Test
    @DisplayName("'2 batata' — adiciona exatamente 2 itens")
    void testQuantidadeDois() {
        interpretador.interpretar("2 batata", carrinho);
        assertEquals(2, carrinho.getItens().size());
    }

    @Test
    @DisplayName("'3 refri' — adiciona exatamente 3 itens")
    void testQuantidadeTres() {
        interpretador.interpretar("3 refri", carrinho);
        assertEquals(3, carrinho.getItens().size());
    }

    @Test
    @DisplayName("'2 batata' — todos os itens são Batata Frita")
    void testQuantidadeTodosCorretos() {
        interpretador.interpretar("2 batata", carrinho);
        carrinho.getItens().forEach(i ->
                assertEquals("Batata Frita", i.getDescricao()));
    }

    // ── Modificadores ──────────────────────────────────────────────────

    @Test
    @DisplayName("'classico sem alface' — item contém '(sem Alface)' na descrição")
    void testSemAlface() {
        interpretador.interpretar("classico sem alface", carrinho);
        assertTrue(carrinho.getItens().get(0).getDescricao()
                .toLowerCase().contains("sem alface"));
    }

    @Test
    @DisplayName("'classico com bacon' — item contém '+ Bacon' na descrição")
    void testComBacon() {
        interpretador.interpretar("classico com bacon", carrinho);
        assertTrue(carrinho.getItens().get(0).getDescricao().contains("Bacon"));
    }

    @Test
    @DisplayName("'classico com cheddar' — item contém '+ Cheddar' na descrição")
    void testComCheddar() {
        interpretador.interpretar("classico com cheddar", carrinho);
        assertTrue(carrinho.getItens().get(0).getDescricao().contains("Cheddar"));
    }

    @Test
    @DisplayName("'classico com ovo' — item contém '+ Ovo' na descrição")
    void testComOvo() {
        interpretador.interpretar("classico com ovo", carrinho);
        assertTrue(carrinho.getItens().get(0).getDescricao().contains("Ovo"));
    }

    @Test
    @DisplayName("'classico com bacon' — preço acrescido de R$ 3,00")
    void testComBaconPreco() {
        interpretador.interpretar("classico com bacon", carrinho);
        assertEquals(22.90 + 3.00, carrinho.getItens().get(0).getPreco(), 0.01);
    }

    @Test
    @DisplayName("'classico sem cebola' — preço não muda ao remover ingrediente")
    void testSemCebolaPrecoInalterado() {
        interpretador.interpretar("classico sem cebola", carrinho);
        assertEquals(22.90, carrinho.getItens().get(0).getPreco(), 0.01);
    }

    // ── Múltiplos tokens ───────────────────────────────────────────────

    @Test
    @DisplayName("'classico batata refri' — adiciona 3 itens distintos")
    void testTresItensSeguidos() {
        interpretador.interpretar("classico batata refri", carrinho);
        assertEquals(3, carrinho.getItens().size());
    }

    @Test
    @DisplayName("'2 batata refri' — 2 batatas + 1 refri = 3 itens")
    void testQuantidadeMaisItem() {
        interpretador.interpretar("2 batata refri", carrinho);
        assertEquals(3, carrinho.getItens().size());
    }

    // ── Tokens inválidos ───────────────────────────────────────────────

    @Test
    @DisplayName("Token completamente inválido — não lança exceção")
    void testTokenInvalidoNaoLancaExcecao() {
        assertDoesNotThrow(() ->
                interpretador.interpretar("xyzabc", carrinho));
    }

    @Test
    @DisplayName("Token inválido — nenhum item é adicionado ao carrinho")
    void testTokenInvalidoNaoAdicionaItem() {
        interpretador.interpretar("pizzanapolitana", carrinho);
        assertEquals(0, carrinho.getItens().size());
    }

    @Test
    @DisplayName("String vazia — não lança exceção")
    void testStringVaziaNaoLancaExcecao() {
        assertDoesNotThrow(() ->
                interpretador.interpretar("", carrinho));
    }

    @Test
    @DisplayName("String vazia — carrinho permanece vazio")
    void testStringVaziaCarrinhoVazio() {
        interpretador.interpretar("", carrinho);
        assertEquals(0, carrinho.getItens().size());
    }

    // ── ContextoInterpretador ──────────────────────────────────────────

    @Test
    @DisplayName("ContextoInterpretador — tokeniza corretamente por espaços")
    void testContextoTokeniza() {
        ContextoInterpretador ctx = new ContextoInterpretador("1 classico sem alface");
        assertEquals(4, ctx.getTokens().length);
    }

    @Test
    @DisplayName("ContextoInterpretador — getTextoOriginal() retorna texto em minúsculas")
    void testContextoTextoOriginal() {
        ContextoInterpretador ctx = new ContextoInterpretador("CLASSICO");
        assertEquals("classico", ctx.getTextoOriginal());
    }

    @Test
    @DisplayName("ContextoInterpretador — proximoToken() avança a posição")
    void testContextoProximoToken() {
        ContextoInterpretador ctx = new ContextoInterpretador("um dois tres");
        assertEquals("um",   ctx.proximoToken());
        assertEquals("dois", ctx.proximoToken());
        assertEquals("tres", ctx.proximoToken());
    }

    @Test
    @DisplayName("ContextoInterpretador — temProximo() retorna false após esgotar tokens")
    void testContextoTemProximoFalse() {
        ContextoInterpretador ctx = new ContextoInterpretador("token");
        ctx.proximoToken();
        assertFalse(ctx.temProximo());
    }

    // ── ItemExpressao ──────────────────────────────────────────────────

    @Test
    @DisplayName("ItemExpressao 'classico' — interpreta e adiciona ao carrinho")
    void testItemExpressaoClassico() {
        new ItemExpressao("classico").interpretar(carrinho);
        assertEquals(1, carrinho.getItens().size());
    }

    @Test
    @DisplayName("ItemExpressao item inválido — não adiciona nada")
    void testItemExpressaoInvalido() {
        new ItemExpressao("itemInexistente").interpretar(carrinho);
        assertEquals(0, carrinho.getItens().size());
    }

    // ── QuantidadeExpressao ────────────────────────────────────────────

    @Test
    @DisplayName("QuantidadeExpressao(3, classico) — adiciona 3 itens")
    void testQuantidadeExpressaoTres() {
        new QuantidadeExpressao(3, new ItemExpressao("classico"))
                .interpretar(carrinho);
        assertEquals(3, carrinho.getItens().size());
    }

    @Test
    @DisplayName("QuantidadeExpressao(1, veggie) — adiciona 1 item")
    void testQuantidadeExpressaoUm() {
        new QuantidadeExpressao(1, new ItemExpressao("veggie"))
                .interpretar(carrinho);
        assertEquals(1, carrinho.getItens().size());
    }
}
