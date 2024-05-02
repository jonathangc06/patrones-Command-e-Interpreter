// Clase principal que sirve como punto de entrada de la aplicación
public class Main {
    public static void main(String[] args) {
        // Crear objeto CajeroAutomatico con saldo inicial de $10,000
        CajeroAutomatico cajero = new CajeroAutomatico(10000.0);
        // Crear objeto TerminalCajero
        TerminalCajero terminal = new TerminalCajero();

        // Crear y asignar comando RetirarDinero al terminal y ejecutarlo
        Command comandoRetirar = new RetirarDinero(cajero, 100.0);
        terminal.setComando(comandoRetirar);
        terminal.ejecutarComando();

        // Crear y asignar comando ConsultarSaldo al terminal y ejecutarlo
        Command comandoConsultar = new ConsultarSaldo(cajero);
        terminal.setComando(comandoConsultar);
        terminal.ejecutarComando();
    }
}

// Definición de la interfaz Command
interface Command {
    void ejecutar();
}

// Clase de comando concreta para retirar dinero
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

// Clase de comando concreta para consultar saldo
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

// Clase que representa el receptor de los comandos
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

// Clase que actúa como invocador del patrón Command
class TerminalCajero {
    private Command comando;

    public void setComando(Command comando) {
        this.comando = comando;
    }

    public void ejecutarComando() {
        comando.ejecutar();
    }
}
