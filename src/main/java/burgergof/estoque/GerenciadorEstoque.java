package burgergof.estoque;

import java.util.HashMap;
import java.util.Map;

/**
 * <<Singleton>>
 * Gerencia o estoque de ingredientes e produtos da hamburgueria.
 * Garante que exista apenas uma instância centralizando o controle.
 */
public class GerenciadorEstoque {

    private static volatile GerenciadorEstoque instancia;
    private final Map<String, Integer> estoque;

    private GerenciadorEstoque() {
        estoque = new HashMap<>();
        inicializarEstoque();
        System.out.println("[Singleton] GerenciadorEstoque inicializado.");
    }

    public static GerenciadorEstoque getInstancia() {
        if (instancia == null) {
            synchronized (GerenciadorEstoque.class) {
                if (instancia == null) {
                    instancia = new GerenciadorEstoque();
                }
            }
        }
        return instancia;
    }

    private void inicializarEstoque() {
        // Estoque inicial de ingredientes
        estoque.put("Pão", 100);
        estoque.put("Carne", 80);
        estoque.put("Bacon", 50);
        estoque.put("Queijo", 60);
        estoque.put("Batata", 200);
        estoque.put("Refrigerante", 150);
    }

    public boolean verificarDisponibilidade(String item, int quantidade) {
        return estoque.getOrDefault(item, 0) >= quantidade;
    }

    public void baixar(String item, int quantidade) {
        int atual = estoque.getOrDefault(item, 0);
        estoque.put(item, atual - quantidade);
        System.out.println("[Estoque] Baixado: " + quantidade + "x " + item);
    }

    public void repor(String item, int quantidade) {
        int atual = estoque.getOrDefault(item, 0);
        estoque.put(item, atual + quantidade);
        System.out.println("[Estoque] Reposto: " + quantidade + "x " + item);
    }

    public int consultar(String item) {
        return estoque.getOrDefault(item, 0);
    }

    public void exibirEstoque() {
        System.out.println("\n=== Estoque Atual ===");
        estoque.forEach((item, qtd) -> 
            System.out.println("  " + item + ": " + qtd + " unidades")
        );
    }
}
