package burgergof.cozinha;

import burgergof.cardapio.Produto;
import burgergof.cardapio.FabricaInfoNutricional;

import java.util.ArrayList;
import java.util.List;

/**
 * <<ConcreteBuilder>> (Builder)
 * Constrói passo a passo um lanche totalmente personalizado.
 * Isolando o processo de construção da representação final.
 */
public class MontadorBurgerCustomizado implements IBuilderLanche {

    private String tipoPao    = "Pão Padrão";
    private String tipoCarne  = "Carne Bovina";
    private double precoBase  = 18.00;
    private final List<String> adicionais   = new ArrayList<>();
    private final List<String> removidos    = new ArrayList<>();
    private double precoAdicionais = 0.0;

    @Override
    public IBuilderLanche setPao(String tipoPao) {
        this.tipoPao = tipoPao;
        return this;
    }

    @Override
    public IBuilderLanche setCarne(String tipoCarne) {
        this.tipoCarne = tipoCarne;
        if (tipoCarne.equalsIgnoreCase("Dupla")) precoBase += 8.00;
        return this;
    }

    @Override
    public IBuilderLanche addAdicional(String adicional, double preco) {
        adicionais.add(adicional);
        precoAdicionais += preco;
        return this;
    }

    @Override
    public IBuilderLanche semIngrediente(String ingrediente) {
        removidos.add(ingrediente);
        return this;
    }

    @Override
    public Produto getResultado() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Burger Custom [").append(tipoPao)
                 .append(" + ").append(tipoCarne).append("]");

        if (!adicionais.isEmpty()) {
            descricao.append(" +").append(String.join(", +", adicionais));
        }
        if (!removidos.isEmpty()) {
            descricao.append(" sem ").append(String.join(", sem ", removidos));
        }

        double precoFinal = precoBase + precoAdicionais;
        return new Produto(descricao.toString(), precoFinal, "Hambúrguer",
                FabricaInfoNutricional.getInfo("Burger Custom"));
    }

    @Override
    public void reset() {
        tipoPao           = "Pão Padrão";
        tipoCarne         = "Carne Bovina";
        precoBase         = 18.00;
        precoAdicionais   = 0.0;
        adicionais.clear();
        removidos.clear();
    }
}
