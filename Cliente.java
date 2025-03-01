import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String email;
    private List<Book> librosPrestados;

//Listado de préstamos a clientes
    public Cliente(){
        librosPrestados = new ArrayList<>();
    }

    // Mostrar lista de libros prestados
    public void showLendBooks(){
        for (Book libro : librosPrestados){
            System.out.println(">> Título: " + libro.getTitle());
            System.out.println(">> Autor: " + libro.getAuthor());
            System.out.println();
        }
    }

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.librosPrestados = new ArrayList<>();
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

    public List<Book> getLibrosPrestados(){
        return librosPrestados;
    }

    public void prestarLibro(Book libro){
        librosPrestados.add(libro);
    }

    public void devolverLibro(Book libro){
        librosPrestados.remove(libro);
    }
}
