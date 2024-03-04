package TestDinero;

public class Cuenta {

    double saldo;
    double kMaxTransferencia = 3000;

    public Cuenta() {
        saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        saldo += cantidad;
        if (saldo < 0) saldo = 0;
        if (saldo > 6000) saldo = 0;
    }

    public void transferir(Cuenta destino, double cantidad) {
        if (cantidad <= 0 || cantidad > kMaxTransferencia) return;
        saldo -= cantidad;
        destino.ingresar(cantidad);
    }
}
