package cozinha;

/**
 * <<ConcreteColleague>> (Mediator)
 * Estação de montagem final do pedido.
 * Só inicia quando mediador confirma que proteína
 * e acompanhamento estão prontos.
 */
public class EstacaoMontagem extends EstacaoCozinha {

    public EstacaoMontagem() {
        super("Montagem");
    }

    @Override
    public void executar(String tarefa) {
        System.out.println("[Mediator/Montagem] Montando pedido: " + tarefa);
        System.out.println("[Mediator/Montagem] ✅ Pedido montado e embalado!");
        avisar("PEDIDO_PRONTO");
    }
}
