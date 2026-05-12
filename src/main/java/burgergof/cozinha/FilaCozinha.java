package burgergof.cozinha;

import burgergof.model.Pedido;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Fila de pedidos aguardando preparo na cozinha.
 * Será usada pelo Mediator para coordenar as estações.
 */
public class FilaCozinha {

    private final Queue<Pedido> fila = new LinkedList<>();

    public void adicionar(Pedido pedido) {
        fila.offer(pedido);
        System.out.println("[FilaCozinha] Pedido #" + pedido.getId() + " adicionado à fila.");
    }

    public Pedido proximoPedido() {
        Pedido pedido = fila.poll();
        if (pedido != null) {
            System.out.println("[FilaCozinha] Pedido #" + pedido.getId() + " retirado da fila.");
        }
        return pedido;
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int tamanho() {
        return fila.size();
    }

    public void exibirFila() {
        System.out.println("\n=== Fila da Cozinha ===");
        if (fila.isEmpty()) {
            System.out.println("  (vazia)");
        } else {
            fila.forEach(p -> System.out.println("  • Pedido #" + p.getId() 
                + " — " + p.getNomeCliente()));
        }
    }
}
