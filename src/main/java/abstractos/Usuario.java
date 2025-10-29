package abstractos;

public abstract class Usuario {

    protected String usuario;
    protected String password;
    protected String nombre;

    public Usuario(String usuario, String password, String nombre) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
    }

    public boolean login(String usuario, String password) {
        if (this.usuario == null || usuario == null) {
            return false;
        }
        if (this.password == null || password == null) {
            return false;
        }
        if (!this.usuario.equals(usuario)) {
            return false;
        }
        if (!this.password.equals(password)) {
            return false;
        }
        return true;
    }

    // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }
}
