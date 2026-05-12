package burgergof.cardapio;

import java.util.HashMap;
import java.util.Map;

/**
 * <<FlyweightFactory>>
 * Gerencia o pool de objetos InfoNutricional.
 * Garante que cada ingrediente tenha apenas 1 instância em memória,
 * independente de quantos pedidos o referenciem.
 */
public class FabricaInfoNutricional {

    private static final Map<String, InfoNutricional> cache = new HashMap<>();

    // Pool pré-carregado com os ingredientes do cardápio
    static {
        cache.put("Burger Clássico", new InfoNutricional(
                "Burger Clássico", 650, "Glúten, Lactose",
                "Pão brioche, carne bovina 160g, queijo, alface, tomate"));
        cache.put("Burger Veggie", new InfoNutricional(
                "Burger Veggie", 480, "Glúten",
                "Pão integral, grão-de-bico 150g, alface, tomate, molho tahine"));
        cache.put("Refrigerante", new InfoNutricional(
                "Refrigerante", 150, "Nenhum",
                "Bebida gaseificada 350ml"));
        cache.put("Suco Natural", new InfoNutricional(
                "Suco Natural", 90, "Nenhum",
                "Suco de fruta natural 300ml, sem adição de açúcar"));
        cache.put("Batata Frita", new InfoNutricional(
                "Batata Frita", 320, "Nenhum",
                "Batata palito crocante, frita em óleo de canola, porção 150g"));
        cache.put("Onion Rings", new InfoNutricional(
                "Onion Rings", 280, "Glúten",
                "Anéis de cebola empanados, porção 100g"));
        cache.put("Sorvete", new InfoNutricional(
                "Sorvete", 210, "Lactose",
                "Sorvete de creme 2 bolas"));
        cache.put("Brownie", new InfoNutricional(
                "Brownie", 390, "Glúten, Lactose",
                "Brownie de chocolate meio amargo, 80g"));
        cache.put("Burger Custom", new InfoNutricional(
                "Burger Custom", 0, "Variável",
                "Lanche montado pelo cliente"));
    }

    private FabricaInfoNutricional() {}

    public static InfoNutricional getInfo(String nomeIngrediente) {
        return cache.getOrDefault(nomeIngrediente,
                cache.get("Burger Custom"));
    }

    /** Retorna quantos objetos distintos existem em memória */
    public static int totalInstancias() {
        return cache.size();
    }
}
