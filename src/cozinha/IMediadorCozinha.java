package cozinha;

/**
 * <<Mediator>>
 * Interface do mediador da cozinha.
 * Centraliza toda comunicação entre as estações,
 * evitando que se referenciem diretamente.
 */
public interface IMediadorCozinha {
    void notificar(EstacaoCozinha remetente, String evento);
    void registrarEstacao(String nome, EstacaoCozinha estacao);
}
