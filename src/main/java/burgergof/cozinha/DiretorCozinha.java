package burgergof.cozinha;

import burgergof.cardapio.Produto;

/**
 * <<Director>> (Builder)
 * Conhece as "receitas" — sequências de passos do builder
 * para montar lanches pré-definidos (ex: Duplo Bacon, Vegano).
 * O cliente usa o Diretor sem precisar conhecer os passos.
 */
public class DiretorCozinha {

    private IBuilderLanche builder;

    public DiretorCozinha(IBuilderLanche builder) {
        this.builder = builder;
    }

    public void setBuilder(IBuilderLanche builder) {
        this.builder = builder;
    }

    /** Receita: Duplo Bacon — pão brioche, carne dupla, bacon e cheddar */
    public Produto construirDuploBacon() {
        builder.reset();
        return builder
                .setPao("Pão Brioche")
                .setCarne("Dupla")
                .addAdicional("Bacon",  3.00)
                .addAdicional("Cheddar", 2.50)
                .getResultado();
    }

    /** Receita: Vegano — pão integral, grão-de-bico, sem molho */
    public Produto construirVegano() {
        builder.reset();
        return builder
                .setPao("Pão Integral")
                .setCarne("Grão-de-bico")
                .semIngrediente("Molho Especial")
                .getResultado();
    }

    /** Receita: Simples — pão padrão, carne simples */
    public Produto construirSimples() {
        builder.reset();
        return builder
                .setPao("Pão Padrão")
                .setCarne("Carne Bovina")
                .getResultado();
    }
}
