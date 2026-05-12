package burgergof.interpreter;

import burgergof.model.Carrinho;
import java.util.ArrayList;
import java.util.List;

/**
 * <<Client>> (Interpreter)
 * Recebe o texto digitado pelo cliente, monta a árvore
 * de expressões e executa a interpretação sobre o carrinho.
 *
 * Gramática suportada:
 *   pedido     ::= item_expr (modificador_expr)*
 *   item_expr  ::= [quantidade] nome_item
 *   modificador_expr ::= ("sem" | "com") ingrediente
 *
 * Exemplos válidos:
 *   "1 classico sem alface"
 *   "2 veggie com bacon"
 *   "batata refri sorvete"
 */
public class InterpretadorPedido {

    // Itens reconhecidos pela gramática
    private static final List<String> ITENS_VALIDOS = List.of(
        "classico", "veggie", "batata", "fritas",
        "refrigerante", "refri", "suco", "sorvete",
        "brownie", "onion", "onionrings"
    );

    public void interpretar(String texto, Carrinho carrinho) {
        System.out.println("\n[Interpreter] Interpretando: \"" + texto + "\"");

        ContextoInterpretador contexto = new ContextoInterpretador(texto);
        List<IExpressao> expressoes    = construirArvore(contexto);

        for (IExpressao expressao : expressoes) {
            expressao.interpretar(carrinho);
        }
    }

    /**
     * Analisa os tokens e constrói a árvore de expressões.
     */
    private List<IExpressao> construirArvore(ContextoInterpretador ctx) {
        List<IExpressao> expressoes = new ArrayList<>();
        String[] tokens = ctx.getTokens();
        int i = 0;

        while (i < tokens.length) {
            String token = tokens[i];

            // Verifica se é um número (quantidade)
            if (token.matches("\\d+")) {
                int quantidade = Integer.parseInt(token);
                i++;
                if (i < tokens.length && ITENS_VALIDOS.contains(tokens[i])) {
                    IExpressao item = new ItemExpressao(tokens[i]);
                    expressoes.add(new QuantidadeExpressao(quantidade, item));
                    i++;
                }
                continue;
            }

            // Verifica se é um item do cardápio
            if (ITENS_VALIDOS.contains(token)) {
                expressoes.add(new ItemExpressao(token));
                i++;
                continue;
            }

            // Verifica se é um modificador "sem" ou "com"
            if ((token.equals("sem") || token.equals("com"))
                    && i + 1 < tokens.length) {
                expressoes.add(new ModificadorExpressao(token, tokens[i + 1]));
                i += 2;
                continue;
            }

            // Token não reconhecido — ignora
            System.out.println("[Interpreter] Token não reconhecido: \""
                    + token + "\" — ignorado.");
            i++;
        }

        return expressoes;
    }
}
