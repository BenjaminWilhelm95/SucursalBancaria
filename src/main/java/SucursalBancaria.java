
public class SucursalBancaria {
    private int codigoSucursal;
    private String codigoPostal;

    public SucursalBancaria(int codigoSucursal, String codigoPostal) {
        this.codigoSucursal = codigoSucursal;
        this.codigoPostal = codigoPostal;
    }

    // Métodos getters y setters
    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
