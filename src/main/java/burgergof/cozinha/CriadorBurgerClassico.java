package burgergof.cozinha;

import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;

/**
 * <<ConcreteCreator>> (Factory Method)
 * Instancia o Burger Clássico com suas informações nutricionais
 * obtidas via Flyweight.
 */
public class CriadorBurgerClassico implements ICriadorLanche {

    @Override
    public Produto criarLanche() {
        return new Produto(
            "Burger Clássico",
            22.90,
            "Hambúrguer",
            FabricaInfoNutricional.getInfo("Burger Clássico")
        );
    }
}
