package carrinho;

/**
 * <<Command>>
 * Interface de todos os comandos do carrinho.
 * Garante que qualquer ação possa ser executada e desfeita.
 */
public interface IComando {
    void executar();
    void desfazer();
    String getDescricao();
}
