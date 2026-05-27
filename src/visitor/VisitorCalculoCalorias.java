package visitor;

import cardapio.Combo;
import cardapio.Produto;

public class VisitorCalculoCalorias implements IVisitor {
    private int totalCalorias = 0;

    @Override public void visitarProduto(Produto p) {
        int cal = p.getInfo().getCalorias();
        totalCalorias += cal;
        System.out.println("[Visitor/Calorias] " + p.getDescricao() + " → " + cal + " kcal");
    }

    @Override public void visitarCombo(Combo c) {
        System.out.println("[Visitor/Calorias] Visitando combo: " + c.getDescricao());
    }

    public int getTotalCalorias()  { return totalCalorias; }
    public void reset()            { totalCalorias = 0; }
    public void exibirResumo()     { System.out.println("[Visitor/Calorias] Total: " + totalCalorias + " kcal"); }
}
