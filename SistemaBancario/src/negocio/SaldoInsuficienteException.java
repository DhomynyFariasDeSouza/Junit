    package negocio;

    public class SaldoInsuficienteException extends RuntimeException {

        public SaldoInsuficienteException() {
            super("Saldo insuficiente na conta.");
        }

        public SaldoInsuficienteException(String message) {
            super(message);
        }
    }
