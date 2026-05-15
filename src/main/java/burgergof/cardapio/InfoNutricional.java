package burgergof.cardapio;

public class InfoNutricional {

    private final String nomeIngrediente;
    private final int calorias;
    private final String alergenos;
    private final String descricaoDetalhada;

    public InfoNutricional(String nomeIngrediente, int calorias,
            String alergenos, String descricaoDetalhada) {
        this.nomeIngrediente = nomeIngrediente;
        this.calorias = calorias;
        this.alergenos = alergenos;
        this.descricaoDetalhada = descricaoDetalhada;
        System.out.println("[Flyweight] InfoNutricional criada para: " + nomeIngrediente);
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getAlergenos() {
        return alergenos;
    }

    public String getDescricao() {
        return descricaoDetalhada;
    }
}
