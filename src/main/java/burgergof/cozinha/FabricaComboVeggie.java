package burgergof.cozinha;

import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;

/**
 * <<ConcreteFactory>> (Abstract Factory)
 * Cria a família de produtos do Combo Veggie:
 * Burger Veggie + Suco Natural + Onion Rings + Brownie.
 * Nenhum produto de origem animal é instanciado.
 */
public class FabricaComboVeggie implements IFabricaCombo {

    @Override
    public Produto criarBurger() {
        return new Produto("Burger Veggie", 24.90, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Veggie"));
    }

    @Override
    public Produto criarBebida() {
        return new Produto("Suco Natural", 9.00, "Bebida",
                FabricaInfoNutricional.getInfo("Suco Natural"));
    }

    @Override
    public Produto criarAcompanhamento() {
        return new Produto("Onion Rings", 11.00, "Acompanhamento",
                FabricaInfoNutricional.getInfo("Onion Rings"));
    }

    @Override
    public Produto criarSobremesa() {
        return new Produto("Brownie", 9.00, "Sobremesa",
                FabricaInfoNutricional.getInfo("Brownie"));
    }
}
