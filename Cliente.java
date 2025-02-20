import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String email;

// Lista incicial de clientes
    public List<Cliente> stockC;

    public Cliente() {
        stockC = new ArrayList<>();
        stockC.add(new Cliente("Invitado", "invitado.mail"));
    }

    //      Obtener clientes
    public List<Cliente> getCliente() {
        return new ArrayList<>(stockC);
    }

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void infoUser() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Email:  " + email);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getClientes(){
//        return List<Cliente> clientes;
//    }

}
