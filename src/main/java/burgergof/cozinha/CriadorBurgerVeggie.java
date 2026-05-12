package burgergof.cozinha;

import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;

/**
 * <<ConcreteCreator>> (Factory Method)
 * Instancia o Burger Veggie — sem produtos de origem animal.
 */
public class CriadorBurgerVeggie implements ICriadorLanche {

    @Override
    public Produto criarLanche() {
        return new Produto(
            "Burger Veggie",
            24.90,
            "Hambúrguer",
            FabricaInfoNutricional.getInfo("Burger Veggie")
        );
    }
}
