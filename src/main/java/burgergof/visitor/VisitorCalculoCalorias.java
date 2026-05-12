package burgergof.visitor;

import burgergof.cardapio.Combo;
import burgergof.cardapio.Produto;

/**
 * <<ConcreteVisitor>>
 * Percorre toda a árvore do pedido somando as calorias
 * de cada item sem alterar nenhuma classe do cardápio.
 */
public class VisitorCalculoCalorias implements IVisitor {

    private int totalCalorias = 0;

    @Override
    public void visitarProduto(Produto produto) {
        int calorias = produto.getInfo().getCalorias();
        totalCalorias += calorias;
        System.out.println("[Visitor/Calorias] "
                + produto.getDescricao()
                + " → " + calorias + " kcal");
    }

    @Override
    public void visitarCombo(Combo combo) {
        // O Combo propaga o visitor para os filhos em aceitar()
        // Aqui apenas registramos que entramos no combo
        System.out.println("[Visitor/Calorias] Visitando combo: "
                + combo.getDescricao());
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void reset() {
        totalCalorias = 0;
    }

    public void exibirResumo() {
        System.out.println("[Visitor/Calorias] Total do pedido: "
                + totalCalorias + " kcal");
    }
}
