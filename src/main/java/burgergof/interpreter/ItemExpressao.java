package burgergof.interpreter;

import burgergof.cardapio.IItemCardapio;
import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;
import burgergof.model.Carrinho;

/**
 * <<TerminalExpression>> (Interpreter)
 * Interpreta o nome de um item do cardápio no texto do cliente
 * e o adiciona ao carrinho.
 * Ex: "classico", "veggie", "batata", "suco"
 */
public class ItemExpressao implements IExpressao {

    private final String nomeItem;

    public ItemExpressao(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public void interpretar(Carrinho contexto) {
        IItemCardapio produto = resolverItem(nomeItem);
        if (produto != null) {
            contexto.adicionarItem(produto);
            System.out.println("[Interpreter/Item] Adicionado: "
                    + produto.getDescricao());
        } else {
            System.out.println("[Interpreter/Item] Item não reconhecido: "
                    + nomeItem);
        }
    }

    private IItemCardapio resolverItem(String nome) {
        switch (nome.toLowerCase()) {
            case "classico":
            case "burguerclassico":
                return new Produto("Burger Clássico", 22.90, "Hambúrguer",
                        FabricaInfoNutricional.getInfo("Burger Clássico"));
            case "veggie":
            case "burguerveggie":
                return new Produto("Burger Veggie", 24.90, "Hambúrguer",
                        FabricaInfoNutricional.getInfo("Burger Veggie"));
            case "batata":
            case "batata frita":
            case "fritas":
                return new Produto("Batata Frita", 10.00, "Acompanhamento",
                        FabricaInfoNutricional.getInfo("Batata Frita"));
            case "refrigerante":
            case "refri":
                return new Produto("Refrigerante", 7.00, "Bebida",
                        FabricaInfoNutricional.getInfo("Refrigerante"));
            case "suco":
                return new Produto("Suco Natural", 9.00, "Bebida",
                        FabricaInfoNutricional.getInfo("Suco Natural"));
            case "sorvete":
                return new Produto("Sorvete", 8.00, "Sobremesa",
                        FabricaInfoNutricional.getInfo("Sorvete"));
            case "brownie":
                return new Produto("Brownie", 9.00, "Sobremesa",
                        FabricaInfoNutricional.getInfo("Brownie"));
            case "onion":
            case "onionrings":
                return new Produto("Onion Rings", 11.00, "Acompanhamento",
                        FabricaInfoNutricional.getInfo("Onion Rings"));
            default:
                return null;
        }
    }
}
