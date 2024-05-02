// Paso 5: Clase principal (AplicacionCajero)
public class AplicacionCajero {
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
