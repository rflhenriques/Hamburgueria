package burgergof.cozinha;

import burgergof.cardapio.Produto;

public interface IFabricaCombo {
    Produto criarBurger();

    Produto criarBebida();

    Produto criarAcompanhamento();

    Produto criarSobremesa();
}
