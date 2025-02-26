import javax.swing.JOptionPane;

public class Prestamo{
    private Cliente cliente;

    public Prestamo(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void prestarLibro(Book libro, StockBook stock){
        if (cliente.getLibrosPrestados().size() < 2){
            if(libro.getStock() > 0){
                //libro.lendBooks();
                cliente.prestarLibro(libro);
                libro.setStock(libro.getStock() - 1);
                stock.updateBook(libro);
                JOptionPane.showMessageDialog(null, "El libro: " + libro.getTitle() + " ha sido prestado a: " + cliente.getNombre(), "Biblioteca Virtual", 1);
                System.out.println(AnsiColors.GREEN.TXT + "El libro: " + AnsiColors.RESET + libro.getTitle() + AnsiColors.GREEN.TXT +  " ha sido prestado a: " + AnsiColors.RESET + cliente.getNombre());
                Timer.main(null);
                CleanScreen.CleanScreen();
            } else {
                System.out.println( AnsiColors.RED.TXT + "No hay stock disponible para el libro: " + AnsiColors.RESET + libro.getTitle());
                JOptionPane.showMessageDialog(null, "     No hay stock disponible para el libro: " + libro.getTitle(), "Biblioteca Virtual", 2);
                Timer.main(null);
                CleanScreen.CleanScreen();
            }
        } else { 
            JOptionPane.showMessageDialog(null, "El cliente ya tiene el número máximo de libros prestados.      ", "Biblioteca Virtual", 2);
            System.out.println(AnsiColors.RED.TXT + "El cliente ya tiene el número máximo de libros prestados." + AnsiColors.RESET);
            Timer.main(null);
            CleanScreen.CleanScreen();
        }
    }
    
}
