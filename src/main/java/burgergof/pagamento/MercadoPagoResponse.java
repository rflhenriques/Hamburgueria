package burgergof.pagamento;

/**
 * Objeto de resposta da API externa do Mercado Pago.
 */
public class MercadoPagoResponse {

    private int    statusCode;
    private String message;

    public int    getStatusCode()          { return statusCode; }
    public String getMessage()             { return message; }
    public void   setStatusCode(int code)  { this.statusCode = code; }
    public void   setMessage(String msg)   { this.message = msg; }

    public boolean isApproved() {
        return statusCode == 200 && "APPROVED".equals(message);
    }
}
