package model;

import cardapio.IItemCardapio;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Carrinho {

    private final List<IItemCardapio> itens = new ArrayList<>();
    private final Deque<PedidoMemento> historico = new ArrayDeque<>();

    private void salvarSnapshot() {
        historico.push(new PedidoMemento(new ArrayList<>(itens)));
    }

    public boolean desfazer() {
        if (historico.isEmpty()) {
            System.out.println("[Carrinho] Nada para desfazer.");
            return false;
        }
        PedidoMemento ultimo = historico.pop();
        itens.clear();
        itens.addAll(ultimo.getItensSalvos());
        System.out.println("[Carrinho] Ação desfeita. Itens restaurados: " + itens.size());
        return true;
    }

    public void adicionarItem(IItemCardapio item) {
        salvarSnapshot();
        itens.add(item);
        System.out.println("[Carrinho] Adicionado: " + item.getDescricao());
    }

    public void removerItem(IItemCardapio item) {
        salvarSnapshot();
        itens.remove(item);
        System.out.println("[Carrinho] Removido: " + item.getDescricao());
    }

    public void limpar() {
        salvarSnapshot();
        itens.clear();
        System.out.println("[Carrinho] Carrinho esvaziado.");
    }

    public List<IItemCardapio> getItens() {
        return new ArrayList<>(itens);
    }

    public boolean isEmpty() {
        return itens.isEmpty();
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(IItemCardapio::getPreco).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== Carrinho ===\n");
        itens.forEach(i -> sb.append("  • ").append(i.getDescricao())
                .append(" — R$ ").append(String.format("%.2f", i.getPreco()))
                .append("\n"));
        sb.append("Total: R$ ").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}
