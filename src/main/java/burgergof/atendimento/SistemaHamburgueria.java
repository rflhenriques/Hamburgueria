package burgergof.atendimento;

/**
 * <<Singleton>>
 * Garante que exista apenas uma instância do gerenciador central
 * do restaurante — conexão com banco, configurações globais, etc.
 * Implementado com double-checked locking para thread safety.
 */
public class SistemaHamburgueria {

    private static volatile SistemaHamburgueria instancia;

    private String nomeRestaurante;
    private boolean aberto;

    private SistemaHamburgueria() {
        this.nomeRestaurante = "BurgerGoF";
        this.aberto          = true;
        System.out.println("[Singleton] SistemaHamburgueria inicializado.");
    }

    public static SistemaHamburgueria getInstancia() {
        if (instancia == null) {
            synchronized (SistemaHamburgueria.class) {
                if (instancia == null) {
                    instancia = new SistemaHamburgueria();
                }
            }
        }
        return instancia;
    }

    public String getNomeRestaurante() { return nomeRestaurante; }
    public boolean isAberto()          { return aberto; }
    public void fechar()               { this.aberto = false; }

    @Override
    public String toString() {
        return nomeRestaurante + " | Aberto: " + aberto;
    }
}
