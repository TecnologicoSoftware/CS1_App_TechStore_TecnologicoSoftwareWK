package modelos;

import abstractos.Usuario;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

public class SistemaTechStore {

    private Inventario inventario;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venta> ventas;
    private ArrayList<Usuario> usuarios;
    private ArrayList<ServicioDigital> servicios = new ArrayList<>();
    private ArrayList<Tecnico> tecnicos;
    private Usuario usuarioActual;
    
    public Image cargarIconoTechStore() {
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/tech_store.png");
        return icono.getImage();
    }

    public SistemaTechStore() {
        this.inventario = new Inventario();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        // Usuarios
        usuarios.add(new Usuario("admin", "123", "Administrador") {});
        usuarios.add(new Usuario("vendedor", "123", "Vendedor 1") {});

        // Productos físicos
        ProductoFisico laptop = new ProductoFisico("P001", "Laptop HP", 1999.99, enums.Categoria.COMPUTADORAS, "123456789", "Pasillo 1, Estante 1");
        laptop.setStock(10);
        inventario.agregarProducto(laptop);

        ProductoFisico celular = new ProductoFisico("P002", "iPhone 13", 999.99, enums.Categoria.SMARTPHONES, "987654321", "Pasillo 2, Estante 2");
        celular.setStock(3);
        inventario.agregarProducto(celular);
        
        // Servicios digitales
        ServicioDigital servicio1 = new ServicioDigital("S001", "Instalación Windows", 50000, "Instalación y configuración de Windows 11", 60);
        servicios.add(servicio1);
        
        ServicioDigital servicio2 = new ServicioDigital("S002", "Limpieza de Computador", 30000, "Limpieza física interna y externa", 45);
        servicios.add(servicio2);
        
        // Técnicos de prueba
        Tecnico tecnico1 = new Tecnico("TEC-001", "123", "Carlos Méndez", "Sistemas Operativos");
        Tecnico tecnico2 = new Tecnico("TEC-002", "123", "Ana Rodríguez", "Hardware");
        tecnicos.add(tecnico1);
        tecnicos.add(tecnico2);

        // Clientes
        clientes.add(new Cliente("CLI-001", "Wilson Tapias", "12345678", "3001112233"));
        Cliente cliente2 = new Cliente("CLI-002", "Kelly Restrepo", "87654321", "3004445566");
        cliente2.aumentarCompras();
        cliente2.aumentarCompras();
        cliente2.aumentarCompras();
        clientes.add(cliente2);
    }
    
    public boolean editarServicio(String id, String nuevoNombre, double nuevoPrecio, String nuevaDescripcion, int nuevaDuracion) {
        for (int i = 0; i < servicios.size(); i++) {
            ServicioDigital servicio = servicios.get(i);
            if (servicio.getId().equals(id)) {
                servicio.setNombre(nuevoNombre);
                servicio.setPrecio(nuevoPrecio);
                servicio.setDescripcion(nuevaDescripcion);
                servicio.setDuracionMinutos(nuevaDuracion);
                return true;
            }
        }
        return false;
    }
    
    public void agregarTecnico(Tecnico tecnico) {
        tecnicos.add(tecnico);
    }
    
    public List<ServicioDigital> getServicios() {
        return new ArrayList<>(servicios);
    }
    
    public ServicioDigital buscarServicioPorId(String id) {
        for (int i = 0; i < servicios.size(); i++) {
            ServicioDigital servicio = servicios.get(i);
            if (servicio.getId().equals(id)) {
                return servicio;
            }
        }
        return null;
    }
    
    public List<Tecnico> getTecnicos() {
        return new ArrayList<>(tecnicos);
    }
    
    public List<Tecnico> getTecnicosDisponibles() {
        List<Tecnico> disponibles = new ArrayList<>();
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.isDisponible()) {
                disponibles.add(tecnico);
            }
        }
        return disponibles;
    }
    
    public boolean asignarTecnicoAServicio(String idServicio, String idTecnico) {
        ServicioDigital servicio = buscarServicioPorId(idServicio);
        Tecnico tecnico = buscarTecnicoPorId(idTecnico);

        if (servicio != null && tecnico != null && tecnico.isDisponible()) {
            for (int i = 0; i < servicios.size(); i++) {
                if (servicios.get(i).getId().equals(idServicio)) {
                    servicios.get(i).asignarTecnicoDisponible(Arrays.asList(tecnico));
                    tecnico.asignarServicio();
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean liberarTecnicoDeServicio(String idServicio) {
        ServicioDigital servicio = buscarServicioPorId(idServicio);

        if (servicio != null && servicio.getTecnicoAsignado() != null) {
            Tecnico tecnico = servicio.getTecnicoAsignado();
            servicio.liberarTecnico();
            tecnico.liberarServicio();
            return true;
        }
        return false;
    }
    
    public Tecnico buscarTecnicoPorId(String id) {
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getUsuario().equals(id)) {
                return tecnico;
            }
        }
        return null;
    }
    
    public String generarIdTecnico() {
        return "TEC-00" + (tecnicos.size() + 1);
    }
    
    public void liberarTecnicosDeVenta(Venta venta) {
        for (ItemVenta item : venta.getItems()) {
            if (item.getProducto() instanceof ServicioDigital) {
                ServicioDigital servicio = (ServicioDigital) item.getProducto();
                servicio.liberarTecnico();
            }
        }
    }

    public void agregarServicio(ServicioDigital servicio) {
        servicios.add(servicio);
    }

    public boolean login(String usuario, String password) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.login(usuario, password)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        usuarioActual = null;
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public String generarIdCliente() {
        return "CLI-00" + (clientes.size() + 1);
    }
    
    public String generarIdServicio() {
        return "S00" + (servicios.size() + 1);
    }

    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    // Getters
    public Inventario getInventario() {
        return inventario;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public boolean eliminarProducto(String id) {
        return inventario.eliminarProducto(id);
    }
    
    public boolean eliminarServicio(String id) {
        for (int i = 0; i < servicios.size(); i++) {
            ServicioDigital servicio = servicios.get(i);
            if (servicio.getId().equals(id)) {
                servicios.remove(i);
                return true;
            }
        }
        return false;
    }
}
