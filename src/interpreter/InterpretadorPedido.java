package interpreter;

import model.Carrinho;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterpretadorPedido {
    private static final List<String> ITENS_VALIDOS = Arrays.asList(
        "classico","veggie","batata","fritas","refrigerante","refri",
        "suco","sorvete","brownie","onion","onionrings"
    );

    public void interpretar(String texto, Carrinho carrinho) {
        System.out.println("\n[Interpreter] Interpretando: \"" + texto + "\"");
        ContextoInterpretador ctx = new ContextoInterpretador(texto);
        List<IExpressao> expressoes = construirArvore(ctx);
        for (IExpressao e : expressoes) e.interpretar(carrinho);
    }

    private List<IExpressao> construirArvore(ContextoInterpretador ctx) {
        List<IExpressao> lista  = new ArrayList<>();
        String[] tokens = ctx.getTokens();
        int i = 0;
        while (i < tokens.length) {
            String t = tokens[i];
            if (t.matches("\\d+") && i + 1 < tokens.length
                    && ITENS_VALIDOS.contains(tokens[i + 1])) {
                lista.add(new QuantidadeExpressao(Integer.parseInt(t),
                        new ItemExpressao(tokens[i + 1])));
                i += 2;
            } else if (ITENS_VALIDOS.contains(t)) {
                lista.add(new ItemExpressao(t)); i++;
            } else if ((t.equals("sem") || t.equals("com"))
                    && i + 1 < tokens.length) {
                lista.add(new ModificadorExpressao(t, tokens[i + 1]));
                i += 2;
            } else {
                System.out.println("[Interpreter] Token ignorado: \"" + t + "\"");
                i++;
            }
        }
        return lista;
    }
}
