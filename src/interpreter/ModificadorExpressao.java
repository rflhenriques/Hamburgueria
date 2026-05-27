package interpreter;

import cardapio.IItemCardapio;
import cardapio.RemoverIngredienteDecorator;
import cardapio.BaconDecorator;
import cardapio.CheddarDecorator;
import cardapio.OvoDecorator;
import model.Carrinho;

import java.util.List;

/**
 * <<NonTerminalExpression>> (Interpreter)
 * Interpreta modificadores aplicados ao último item adicionado.
 * Ex: "sem alface", "com bacon", "com cheddar"
 * Aplica os Decorators correspondentes via padrão Decorator.
 */
public class ModificadorExpressao implements IExpressao {

    private final String modificador;
    private final String alvo;

    public ModificadorExpressao(String modificador, String alvo) {
        this.modificador = modificador.toLowerCase();
        this.alvo        = alvo.toLowerCase();
    }

    @Override
    public void interpretar(Carrinho contexto) {
        List<IItemCardapio> itens = contexto.getItens();

        if (itens.isEmpty()) {
            System.out.println("[Interpreter/Modificador] Nenhum item no carrinho "
                    + "para modificar.");
            return;
        }

        // Pega o último item adicionado para aplicar o modificador
        IItemCardapio ultimo = itens.get(itens.size() - 1);
        IItemCardapio modificado = aplicarModificador(ultimo);

        if (modificado != ultimo) {
            // Remove o original e adiciona o modificado
            contexto.removerItem(ultimo);
            contexto.adicionarItem(modificado);
            System.out.println("[Interpreter/Modificador] Aplicado \""
                    + modificador + " " + alvo + "\" em: "
                    + modificado.getDescricao());
        }
    }

    private IItemCardapio aplicarModificador(IItemCardapio item) {
        if (modificador.equals("sem")) {
            return new RemoverIngredienteDecorator(item, alvo);
        }
        if (modificador.equals("com") || modificador.equals("adicionar")) {
            switch (alvo) {
                case "bacon":   return new BaconDecorator(item);
                case "cheddar": return new CheddarDecorator(item);
                case "ovo":     return new OvoDecorator(item);
                default:
                    System.out.println("[Interpreter/Modificador] Adicional \""
                            + alvo + "\" não reconhecido.");
                    return item;
            }
        }
        return item;
    }
}
