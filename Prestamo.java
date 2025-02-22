import java.util.List;

public class Prestamo{
    private Cliente cliente;

    public Prestamo(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void prestarLibro(Book libro, StockBook stock){
        if (cliente.getLibrosPrestados().size() < 2 ){
            if(libro.getStock() > 0){
                libro.getBooks();
                cliente.prestarLibro(libro);
               // libro.setStock(libro.getStock() - 1);
               // stock.updateBook(libro);
                System.out.println("El libro: " + libro.getTitle() + " ha sido prestado a: " + cliente.getNombre());
            } else {
                System.out.println("No hay stock disponible para el libro: " + libro.getTitle());
            }
        }
    }

    
}
