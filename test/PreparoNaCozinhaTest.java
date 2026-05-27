package test;

import cozinha.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Template Method + Mediator")
class PreparoNaCozinhaTest {

    @Test @DisplayName("Template Method executa etapas na ordem correta")
    void testOrdemPreparo() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        PreparoLanche preparo = new PreparoLancheClassico();
        preparo.prepararLanche(new CriadorBurgerClassico().criarLanche());

        System.setOut(System.out);
        String saida = out.toString();

        int idx1 = saida.indexOf("1. Tostando");
        int idx2 = saida.indexOf("2. Grelhando");
        int idx3 = saida.indexOf("3. Montando");
        int idx4 = saida.indexOf("4. Embalando");

        assertTrue(idx1 < idx2 && idx2 < idx3 && idx3 < idx4,
                "Etapas devem seguir a ordem correta do Template Method");
    }

    @Test @DisplayName("Mediator coordena Chapa → Fritadeira → Montagem")
    void testMediadorCoordenacao() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MediadorCozinha mediador = new MediadorCozinha();
        EstacaoChapa     chapa   = new EstacaoChapa();
        EstacaoFritadeira frit   = new EstacaoFritadeira();
        EstacaoMontagem   mont   = new EstacaoMontagem();
        mediador.registrarEstacao("Chapa",      chapa);
        mediador.registrarEstacao("Fritadeira", frit);
        mediador.registrarEstacao("Montagem",   mont);
        chapa.executar("Carne Bovina");

        System.setOut(System.out);
        String saida = out.toString();

        assertTrue(saida.contains("Fritadeira"));
        assertTrue(saida.contains("Montagem"));
        assertTrue(saida.contains("PEDIDO_PRONTO") || saida.contains("montado"));
    }
}
