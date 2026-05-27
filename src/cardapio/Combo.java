package cardapio;

import visitor.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class Combo implements IItemCardapio {

    private final String nome;
    private final List<IItemCardapio> itens;
    private final double desconto; // desconto percentual aplicado ao combo

    public Combo(String nome, double desconto) {
        this.nome = nome;
        this.desconto = desconto;
        this.itens = new ArrayList<>();
    }

    public void adicionar(IItemCardapio item) {
        itens.add(item);
        System.out.println("[Combo] Adicionado ao " + nome + ": " + item.getDescricao());
    }

    public void remover(IItemCardapio item) {
        itens.remove(item);
    }

    public List<IItemCardapio> getItens() {
        return new ArrayList<>(itens);
    }

    @Override
    public double getPreco() {
        // Soma recursiva: funciona para combos dentro de combos
        double total = itens.stream()
                .mapToDouble(IItemCardapio::getPreco)
                .sum();
        return total * (1 - desconto / 100.0);
    }

    @Override
    public String getDescricao() {
        StringBuilder sb = new StringBuilder(nome + " (");
        for (int i = 0; i < itens.size(); i++) {
            sb.append(itens.get(i).getDescricao());
            if (i < itens.size() - 1)
                sb.append(", ");
        }
        sb.append(")");
        if (desconto > 0) {
            sb.append(" [").append(String.format("%.0f", desconto)).append("% OFF]");
        }
        return sb.toString();
    }

    @Override
    public void aceitar(IVisitor visitor) {
        visitor.visitarCombo(this);
        // Propaga o visitor para todos os filhos
        for (IItemCardapio item : itens) {
            item.aceitar(visitor);
        }
    }

    @Override
    public String toString() {
        return getDescricao() + " — R$ " + String.format("%.2f", getPreco());
    }
}
