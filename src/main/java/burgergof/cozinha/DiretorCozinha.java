package burgergof.cozinha;

import burgergof.cardapio.Produto;

public class DiretorCozinha {

    private IBuilderLanche builder;

    public DiretorCozinha(IBuilderLanche builder) {
        this.builder = builder;
    }

    public void setBuilder(IBuilderLanche builder) {
        this.builder = builder;
    }

    public Produto construirDuploBacon() {
        builder.reset();
        return builder
                .setPao("Pão Brioche")
                .setCarne("Dupla")
                .addAdicional("Bacon", 3.00)
                .addAdicional("Cheddar", 2.50)
                .getResultado();
    }

    public Produto construirVegano() {
        builder.reset();
        return builder
                .setPao("Pão Integral")
                .setCarne("Grão-de-bico")
                .semIngrediente("Molho Especial")
                .getResultado();
    }

    public Produto construirSimples() {
        builder.reset();
        return builder
                .setPao("Pão Padrão")
                .setCarne("Carne Bovina")
                .getResultado();
    }
}
