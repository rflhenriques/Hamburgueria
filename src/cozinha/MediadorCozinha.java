package cozinha;

import java.util.HashMap;
import java.util.Map;

/**
 * <<ConcreteMediator>> (Mediator)
 * Centraliza e coordena toda comunicação entre as estações.
 * Contém a lógica de quem avisa quem — as estações não sabem disso.
 */
public class MediadorCozinha implements IMediadorCozinha {

    private final Map<String, EstacaoCozinha> estacoes = new HashMap<>();
    private boolean proteinaProta        = false;
    private boolean acompanhamentoProto  = false;

    public void reiniciar() {
        this.proteinaProta = false;
        this.acompanhamentoProto = false;
    }

    @Override
    public void registrarEstacao(String nome, EstacaoCozinha estacao) {
        estacoes.put(nome, estacao);
        estacao.setMediador(this);
        System.out.println("[Mediator] Estação registrada: " + nome);
    }

    @Override
    public void notificar(EstacaoCozinha remetente, String evento) {
        System.out.println("[Mediator] Evento recebido de "
                + remetente.getNome() + ": " + evento);

        switch (evento) {
            case "PROTEINA_PRONTA":
                proteinaProta = true;
                // Aciona fritadeira assim que proteína fica pronta
                EstacaoCozinha fritadeira = estacoes.get("Fritadeira");
                if (fritadeira != null) {
                    System.out.println("[Mediator] Sinalizando Fritadeira para iniciar...");
                    fritadeira.executar("Batata Frita");
                }
                tentarMontagem();
                break;

            case "ACOMPANHAMENTO_PRONTO":
                acompanhamentoProto = true;
                tentarMontagem();
                break;

            case "PEDIDO_PRONTO":
                System.out.println("[Mediator] 🎉 Pedido finalizado pela cozinha!");
                proteinaProta       = false;
                acompanhamentoProto = false;
                break;

            default:
                System.out.println("[Mediator] Evento desconhecido: " + evento);
        }
    }

    private void tentarMontagem() {
        if (proteinaProta && acompanhamentoProto) {
            EstacaoCozinha montagem = estacoes.get("Montagem");
            if (montagem != null) {
                System.out.println("[Mediator] Tudo pronto! Sinalizando Montagem...");
                montagem.executar("Combo do cliente");
            }
        }
    }
}
