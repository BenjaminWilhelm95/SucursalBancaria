import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionBanco {
    private List<Cliente> clientes;
    private List<SucursalBancaria> sucursales;
    private Map<Cliente, List<CuentaBancaria>> cuentasPorCliente;
    private Map<SucursalBancaria, List<CuentaAhorro>> cuentasAhorroPorSucursal;
    private Map<SucursalBancaria, List<CuentaCorriente>> cuentasCorrientesPorSucursal;

    public GestionBanco() {
        clientes = new ArrayList<>();
        sucursales = new ArrayList<>();
        cuentasPorCliente = new HashMap<>();
        cuentasAhorroPorSucursal = new HashMap<>();
        cuentasCorrientesPorSucursal = new HashMap<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        cuentasPorCliente.put(cliente, new ArrayList<>());
    }

    public void agregarCuentaBancaria(Cliente cliente, CuentaBancaria cuenta, SucursalBancaria sucursal) {
        List<CuentaBancaria> cuentasCliente = cuentasPorCliente.get(cliente);
        cuentasCliente.add(cuenta);

        if (cuenta instanceof CuentaAhorro) {
            asociarCuentaAhorroASucursal(cuenta, sucursal);
        } else if (cuenta instanceof CuentaCorriente) {
            asociarCuentaCorrienteASucursal(cuenta, sucursal);
        }
    }
    public void agregarSucursalBancaria(SucursalBancaria sucursal) {
        sucursales.add(sucursal);
    }

    public void visualizarCuentasCliente(Cliente cliente) {
        List<CuentaBancaria> cuentasCliente = cuentasPorCliente.get(cliente);
        if (cuentasCliente != null) {
            System.out.println("Cuentas de " + cliente.getNombre() + ":");
            for (CuentaBancaria cuenta : cuentasCliente) {
                System.out.println(cuenta);
            }
        } else {
            System.out.println("El cliente no existe.");
        }
    }

    public List<CuentaAhorro> obtenerCuentasAhorroPorSucursal(SucursalBancaria sucursal) {
        return cuentasAhorroPorSucursal.getOrDefault(sucursal, new ArrayList<>());
    }

    public List<CuentaCorriente> obtenerCuentasCorrientesPorSucursal(SucursalBancaria sucursal) {
        return cuentasCorrientesPorSucursal.getOrDefault(sucursal, new ArrayList<>());
    }

    private void asociarCuentaAhorroASucursal(CuentaBancaria cuenta, SucursalBancaria sucursal) {
        List<CuentaAhorro> cuentasAhorro = cuentasAhorroPorSucursal.getOrDefault(sucursal, new ArrayList<>());
        cuentasAhorro.add((CuentaAhorro) cuenta);
        cuentasAhorroPorSucursal.put(sucursal, cuentasAhorro);
    }

    private void asociarCuentaCorrienteASucursal(CuentaBancaria cuenta, SucursalBancaria sucursal) {
        List<CuentaCorriente> cuentasCorrientes = cuentasCorrientesPorSucursal.getOrDefault(sucursal, new ArrayList<>());
        cuentasCorrientes.add((CuentaCorriente) cuenta);
        cuentasCorrientesPorSucursal.put(sucursal, cuentasCorrientes);
    }
}