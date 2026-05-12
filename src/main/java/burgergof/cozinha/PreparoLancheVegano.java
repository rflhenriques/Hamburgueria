package burgergof.cozinha;

/**
 * <<ConcreteClass>> (Template Method)
 * Preparo específico do Burger Veggie — proteína de grão-de-bico.
 */
public class PreparoLancheVegano extends PreparoLanche {

    @Override
    protected void prepararProteina() {
        System.out.println("[Template] 2. Aquecendo hambúrguer de grão-de-bico...");
    }
}
