package carrinho;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Invoker do padrão Command.
 * Empilha os comandos executados e permite desfazer
 * múltiplas ações em sequência (histórico completo).
 */
public class GerenciadorComandos {

    private final Deque<IComando> historico = new ArrayDeque<>();

    public void executar(IComando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimo() {
        if (historico.isEmpty()) {
            System.out.println("[GerenciadorComandos] Nenhum comando para desfazer.");
            return;
        }
        IComando ultimo = historico.pop();
        System.out.println("[GerenciadorComandos] Desfazendo: "
                + ultimo.getDescricao());
        ultimo.desfazer();
    }

    public void desfazerTodos() {
        System.out.println("[GerenciadorComandos] Desfazendo todos os comandos...");
        while (!historico.isEmpty()) {
            desfazerUltimo();
        }
    }

    public int totalComandos() {
        return historico.size();
    }
}
