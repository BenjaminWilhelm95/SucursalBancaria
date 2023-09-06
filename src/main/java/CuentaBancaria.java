

public class CuentaBancaria {
    private String numeroCuenta;
    private String fechaApertura;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String fechaApertura, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    private SucursalBancaria sucursalAsociada;

    public CuentaBancaria(String numeroCuenta, String fechaApertura, double saldo, SucursalBancaria sucursalAsociada) {

        this.sucursalAsociada = sucursalAsociada;
    }

    public SucursalBancaria getSucursalAsociada() {
        return sucursalAsociada;
    }

    public void setSucursalAsociada(SucursalBancaria sucursalAsociada) {
        this.sucursalAsociada = sucursalAsociada;
    }
}