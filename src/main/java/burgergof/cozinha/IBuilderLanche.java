package burgergof.cozinha;

import burgergof.cardapio.Produto;

/**
 * <<Builder>>
 * Define os passos de construção de um lanche customizado.
 * Cada método retorna o próprio builder para permitir fluent API.
 */
public interface IBuilderLanche {
    IBuilderLanche setPao(String tipoPao);
    IBuilderLanche setCarne(String tipoCarne);
    IBuilderLanche addAdicional(String adicional, double preco);
    IBuilderLanche semIngrediente(String ingrediente);
    Produto getResultado();
    void reset();
}
