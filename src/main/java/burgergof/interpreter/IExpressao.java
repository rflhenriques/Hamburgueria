package burgergof.interpreter;

import burgergof.model.Carrinho;

/**
 * <<AbstractExpression>> (Interpreter)
 * Interface base de todas as expressões da gramática
 * do chatbot de atendimento.
 * Cada expressão sabe interpretar a si mesma dado um contexto.
 */
public interface IExpressao {
    void interpretar(Carrinho contexto);
}
