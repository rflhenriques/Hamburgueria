package burgergof.cozinha;

import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;

/**
 * <<ConcreteFactory>> (Abstract Factory)
 * Cria a família de produtos do Combo Clássico:
 * Burger Clássico + Refrigerante + Batata Frita + Sorvete.
 */
public class FabricaComboClassico implements IFabricaCombo {

    @Override
    public Produto criarBurger() {
        return new Produto("Burger Clássico", 22.90, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico"));
    }

    @Override
    public Produto criarBebida() {
        return new Produto("Refrigerante", 7.00, "Bebida",
                FabricaInfoNutricional.getInfo("Refrigerante"));
    }

    @Override
    public Produto criarAcompanhamento() {
        return new Produto("Batata Frita", 10.00, "Acompanhamento",
                FabricaInfoNutricional.getInfo("Batata Frita"));
    }

    @Override
    public Produto criarSobremesa() {
        return new Produto("Sorvete", 8.00, "Sobremesa",
                FabricaInfoNutricional.getInfo("Sorvete"));
    }
}
