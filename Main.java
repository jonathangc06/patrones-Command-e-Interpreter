// Paso 1: Definir la interfaz Command
interface Command {
    void ejecutar();
}

// Paso 2: Crear las clases de comando concretas
class RetirarDinero implements Command {
    private CajeroAutomatico cajero;
    private double monto;

    public RetirarDinero(CajeroAutomatico cajero, double monto) {
        this.cajero = cajero;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cajero.retirarDinero(monto);
    }
}

class ConsultarSaldo implements Command {
    private CajeroAutomatico cajero;

    public ConsultarSaldo(CajeroAutomatico cajero) {
        this.cajero = cajero;
    }

    @Override
    public void ejecutar() {
        cajero.consultarSaldo();
    }
}

// Paso 3: Crear la clase Receptor (CajeroAutomatico)
class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirarDinero(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Se retiraron $" + monto + ". Saldo restante: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente para retirar $" + monto);
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }
}

// Paso 4: Crear la clase Invoker (TerminalCajero)
class TerminalCajero {
    private Command comando;

    public void setComando(Command comando) {
        this.comando = comando;
    }

    public void ejecutarComando() {
        comando.ejecutar();
    }
}
