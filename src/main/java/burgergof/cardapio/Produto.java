package burgergof.cardapio;

import burgergof.visitor.IVisitor;
import burgergof.cardapio.InfoNutricional;

/**
 * <<Leaf>> (Composite)
 * Representa um produto simples do cardápio: hambúrguer base,
 * bebida, sobremesa ou acompanhamento.
 * Carrega uma referência ao Flyweight de informações nutricionais.
 */
public class Produto implements IItemCardapio {

    private final String     nome;
    private final double     preco;
    private final String     categoria;
    private final InfoNutricional infoNutricional; // <<Flyweight>>

    public Produto(String nome, double preco, String categoria, InfoNutricional info) {
        this.nome            = nome;
        this.preco           = preco;
        this.categoria       = categoria;
        this.infoNutricional = info;
    }

    @Override public double getPreco()      { return preco; }
    @Override public String getDescricao()  { return nome; }
    public String getCategoria()            { return categoria; }
    public InfoNutricional getInfo()        { return infoNutricional; }

    @Override
    public void aceitar(IVisitor visitor) {
        visitor.visitarProduto(this);
    }

    @Override
    public String toString() {
        return nome + " — R$ " + String.format("%.2f", preco);
    }
}
