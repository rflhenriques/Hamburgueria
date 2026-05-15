package burgergof.cozinha;

import burgergof.cardapio.Produto;

public interface IBuilderLanche {
    IBuilderLanche setPao(String tipoPao);

    IBuilderLanche setCarne(String tipoCarne);

    IBuilderLanche addAdicional(String adicional, double preco);

    IBuilderLanche semIngrediente(String ingrediente);

    Produto getResultado();

    void reset();
}
