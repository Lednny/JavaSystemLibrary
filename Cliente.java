import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public List<Book> searchBook(String title) {
        List<Book> books = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                books.add(book);
            }
        }
        return books;
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

}
