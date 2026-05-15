package burgergof.cardapio;

import burgergof.visitor.IVisitor;

public interface IItemCardapio {
    double getPreco();

    String getDescricao();

    void aceitar(IVisitor visitor);
}
