package burgergof.cozinha;

import burgergof.cardapio.Produto;

/**
 * <<Factory Method>>
 * Interface criadora que declara o método fábrica.
 * Subclasses decidem qual produto concreto instanciar.
 */
public interface ICriadorLanche {
    Produto criarLanche();

    /**
     * Método de negócio que usa o Factory Method internamente.
     * O cliente chama este método sem saber qual produto será criado.
     */
    default String descreverLanche() {
        Produto lanche = criarLanche();
        return "Lanche criado: " + lanche.getDescricao()
               + " | Preço: R$ " + String.format("%.2f", lanche.getPreco());
    }
}
