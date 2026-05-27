package cozinha;

import cardapio.Produto;

public interface IFabricaCombo {
    Produto criarBurger();

    Produto criarBebida();

    Produto criarAcompanhamento();

    Produto criarSobremesa();
}
