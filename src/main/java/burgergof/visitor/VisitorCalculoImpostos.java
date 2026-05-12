package burgergof.visitor;

import burgergof.cardapio.Combo;
import burgergof.cardapio.Produto;

/**
 * <<ConcreteVisitor>>
 * Percorre toda a árvore do pedido calculando
 * os impostos (ICMS simulado) de cada item.
 * Opera sem alterar nenhuma classe do cardápio.
 */
public class VisitorCalculoImpostos implements IVisitor {

    // Alíquotas simuladas por categoria
    private static final double ICMS_ALIMENTO  = 0.07; // 7%
    private static final double ICMS_BEBIDA    = 0.12; // 12%
    private static final double ICMS_SOBREMESA = 0.09; // 9%

    private double totalImpostos = 0.0;

    @Override
    public void visitarProduto(Produto produto) {
        double aliquota = resolverAliquota(produto.getCategoria());
        double imposto  = produto.getPreco() * aliquota;
        totalImpostos  += imposto;

        System.out.println("[Visitor/Impostos] "
                + produto.getDescricao()
                + " | Categoria: " + produto.getCategoria()
                + " | Alíquota: " + (int)(aliquota * 100) + "%"
                + " | Imposto: R$ " + String.format("%.2f", imposto));
    }

    @Override
    public void visitarCombo(Combo combo) {
        System.out.println("[Visitor/Impostos] Visitando combo: "
                + combo.getDescricao());
    }

    private double resolverAliquota(String categoria) {
        switch (categoria.toLowerCase()) {
            case "bebida":      return ICMS_BEBIDA;
            case "sobremesa":   return ICMS_SOBREMESA;
            default:            return ICMS_ALIMENTO;
        }
    }

    public double getTotalImpostos() {
        return totalImpostos;
    }

    public void reset() {
        totalImpostos = 0.0;
    }

    public void exibirResumo() {
        System.out.println("[Visitor/Impostos] Total de impostos do pedido: R$ "
                + String.format("%.2f", totalImpostos));
    }
}
