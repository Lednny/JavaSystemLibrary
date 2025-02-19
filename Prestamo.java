import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Prestamo{
    private Cliente cliente;
    private Book libro;
    private Date fechaPrestamo;
    private Book book;

    public Prestamo(Cliente cliente, Book book) {
        this.cliente = cliente;
        this.book = book;
        this.fechaPrestamo = new Date();
        
    }

//    public Prestamo(Cliente cliente, Book libro, Date fechaPrestamo){
//        this.cliente = cliente;
//        this.libro = libro;
//        this.fechaPrestamo = fechaPrestamo;
//    }

    public Cliente getCliente(){
        return cliente;
    }

    public Book getLibro(){
        return libro;
    }

    public Date getFechaPrestamo(){
        return fechaPrestamo;
    }
//    private List<Book> borrowedList = new ArrayList<>();
//
//    public void addBorrowedBook(Book book) {
//        borrowedList.add(book);
//    }
//
//    public void borrowedBooks() {
//        System.out.println("📚 Libros Prestados:");
//        for (Book book : borrowedList) {
//            System.out.println(">>  Título: " + book.getTitle() + "\n" +">>  Cantidad: " + StockBook.getQuantity());
//        }
//    }
}
