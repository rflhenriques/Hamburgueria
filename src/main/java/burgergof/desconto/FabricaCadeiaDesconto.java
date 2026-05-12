package burgergof.desconto;

/**
 * Monta a cadeia de responsabilidade na ordem correta.
 * Centraliza a construção para não repetir lógica no Main.
 */
public class FabricaCadeiaDesconto {

    public static ProcessadorDesconto construir() {
        ProcessadorDesconto gerente       = new DescontoGerente();
        ProcessadorDesconto promocao      = new DescontoPromocaoDia();
        ProcessadorDesconto aniversario   = new DescontoAniversariante();
        ProcessadorDesconto semDesconto   = new SemDescontoHandler();

        // Monta a cadeia: Gerente → Promoção → Aniversário → Sem Desconto
        gerente.setProximo(promocao)
               .setProximo(aniversario)
               .setProximo(semDesconto);

        return gerente;
    }
}
