package cozinha;

import cardapio.Produto;

/**
 * <<Template Method>>
 * Define o esqueleto fixo do preparo de qualquer lanche.
 * A ordem das etapas nunca muda — apenas a preparação
 * da proteína varia conforme a subclasse.
 */
public abstract class PreparoLanche {

    /**
     * Template Method — método final garante que a ordem
     * das etapas nunca seja alterada pelas subclasses.
     */
    public final void prepararLanche(Produto lanche) {
        System.out.println("\n[Template] Iniciando preparo: "
                + lanche.getDescricao());
        tostarPao();
        prepararProteina();  // passo variável — definido pela subclasse
        montar();
        embalar();
        System.out.println("[Template] ✅ Lanche pronto: "
                + lanche.getDescricao());
    }

    // Etapas fixas — iguais para todos os lanches
    private void tostarPao() {
        System.out.println("[Template] 1. Tostando o pão...");
    }

    private void montar() {
        System.out.println("[Template] 3. Montando o lanche...");
    }

    private void embalar() {
        System.out.println("[Template] 4. Embalando o pedido...");
    }

    // Etapa variável — cada subclasse define como prepara a proteína
    protected abstract void prepararProteina();
}
