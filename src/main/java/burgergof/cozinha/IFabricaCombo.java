package burgergof.cozinha;

import burgergof.cardapio.Produto;

/**
 * <<Abstract Factory>>
 * Define a interface para criação de famílias de produtos
 * relacionados (combos). Garante que os produtos de um combo
 * sejam sempre compatíveis entre si.
 */
public interface IFabricaCombo {
    Produto criarBurger();
    Produto criarBebida();
    Produto criarAcompanhamento();
    Produto criarSobremesa();
}
