package burgergof.desconto;

public class FabricaCadeiaDesconto {
    public static ProcessadorDesconto construir() {
        ProcessadorDesconto gerente     = new DescontoGerente();
        ProcessadorDesconto promocao    = new DescontoPromocaoDia();
        ProcessadorDesconto aniversario = new DescontoAniversariante();
        ProcessadorDesconto semDesconto = new SemDescontoHandler();
        gerente.setProximo(promocao).setProximo(aniversario).setProximo(semDesconto);
        return gerente;
    }
}
