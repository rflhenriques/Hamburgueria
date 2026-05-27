package visitor;

import cardapio.Combo;
import cardapio.Produto;

public class VisitorCalculoImpostos implements IVisitor {
    private static final double ICMS_ALIMENTO  = 0.07;
    private static final double ICMS_BEBIDA    = 0.12;
    private static final double ICMS_SOBREMESA = 0.09;
    private double totalImpostos = 0.0;

    @Override public void visitarProduto(Produto p) {
        double aliquota = resolverAliquota(p.getCategoria());
        double imposto  = p.getPreco() * aliquota;
        totalImpostos  += imposto;
        System.out.println("[Visitor/Impostos] " + p.getDescricao()
                + " | " + (int)(aliquota*100) + "% | R$ " + String.format("%.2f", imposto));
    }

    @Override public void visitarCombo(Combo c) {
        System.out.println("[Visitor/Impostos] Combo: " + c.getDescricao());
    }

    private double resolverAliquota(String cat) {
        switch (cat.toLowerCase()) {
            case "bebida":    return ICMS_BEBIDA;
            case "sobremesa": return ICMS_SOBREMESA;
            default:          return ICMS_ALIMENTO;
        }
    }

    public double getTotalImpostos() { return totalImpostos; }
    public void reset()              { totalImpostos = 0.0; }
    public void exibirResumo()       { System.out.println("[Visitor/Impostos] Total: R$ " + String.format("%.2f", totalImpostos)); }
}
