package cozinha;

import cardapio.Produto;
import cardapio.FabricaInfoNutricional;

public class CriadorBurgerClassico implements ICriadorLanche {

    @Override
    public Produto criarLanche() {
        return new Produto(
                "Burger Clássico",
                22.90,
                "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Clássico"));
    }
}
