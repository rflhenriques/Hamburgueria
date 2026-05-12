package burgergof.cozinha;

/**
 * <<ConcreteClass>> (Template Method)
 * Preparo específico do Burger Clássico — proteína de carne bovina.
 */
public class PreparoLancheClassico extends PreparoLanche {

    @Override
    protected void prepararProteina() {
        System.out.println("[Template] 2. Grelhando carne bovina 160g na chapa...");
    }
}
