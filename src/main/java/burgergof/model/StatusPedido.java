package burgergof.model;

/**
 * Enum que representa os estados possíveis de um pedido.
 * Utilizado pelo padrão State para controlar transições válidas.
 */
public enum StatusPedido {
    AGUARDANDO_PAGAMENTO,
    PAGO,
    NA_COZINHA,
    PRONTO,
    ENTREGUE,
    CANCELADO
}
