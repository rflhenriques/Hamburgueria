package burgergof.cozinha;

import burgergof.cardapio.Produto;

public interface ICriadorLanche {
    Produto criarLanche();

    default String descreverLanche() {
        Produto lanche = criarLanche();
        return "Lanche criado: " + lanche.getDescricao()
                + " | Preço: R$ " + String.format("%.2f", lanche.getPreco());
    }
}
