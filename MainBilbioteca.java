import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {
    static List<Cliente> clientes = new ArrayList<>();

    public static void prestamoLibro(List<Cliente> clientes, StockBook stockB) {
        Cliente cliente = buscarClientePorNombre();
        Book libro = buscarLibroPorTitulo(stockB);
        if (cliente != null && libro != null) {
            Prestamo prestamo = new Prestamo(cliente);
            prestamo.prestarLibro(libro, stockB);
        } else {
            System.out.println("No se encontró el cliente o el libro.");
            Timer.main(null);
            CleanScreen.CleanScreen();
        }
    }

    public static Cliente buscarClientePorNombre() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = input.nextLine();
        System.out.println("");
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre.toLowerCase())) {
                return cliente;
            }
        }
        return null;
    }

    public static Book buscarLibroPorTitulo(StockBook stockB) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el título del libro: ");
        String titulo = input.nextLine();
        System.out.println("");
        for (Book book : stockB.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(titulo.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    // Funcion < Impresion de clientes >
    public static void printClients(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(
                    "- Cliente: " + clientes.get(i).getNombre() + "\n" + "- Email: " + clientes.get(i).getEmail() + "\n" + "- Libros Prestados: " + clientes.get(i).getLibrosPrestados().size());
            System.out.println();
            System.out.println("Libros prestados: ");
            clientes.get(i).showLendBooks();
            System.out .println();
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    // Funcion < Impresión de stock >
    public static void printStock(StockBook stockB) {
        List<Book> books = stockB.getBooks();
        for (Book book : books) {
            System.out.println(">> Titulo: " + book.getTitle());
            System.out.println(">> Autor: " + book.getAuthor());
            System.out.println(">> Genero: " + book.getType());
            System.out.println(">> Stock: " + book.getStock() + "\n");

        }
        System.out.println();
    }

    public static void main(String args[]) {
//        List<Cliente> clientes = new ArrayList<>();
        StockBook stockB = new StockBook();
        String nombre;
        String email;
        String devolucion;
        String clienteDevolucion;
        int salir;

        // Variables
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        // Menú
        JOptionPane.showMessageDialog(null, "¡Hola, Bienvenido a la Biblioteca virtual de Java!", "Biblioteca Virtual", 1);
        System.out.println("¡Hola, Bienvenido a la Biblioteca virtual de Java!");


        System.out.println("");

        while (continuar) {
            System.out.println("");
            System.out.println("-------------------------- Menú de la Biblioteca Virtual ----------------------------");
            System.out.println(">>>  ¿Qué deseas realizar?  <<<");
            System.out.println("1. Registro de Usuario ");
            System.out.println("2. Búsqueda de Book "); // Despliega lista de Books - busqueda
            System.out.println("3. Préstamo de libro "); // Prestamo de libro
            System.out.println("4. Devolución de Book ");
            System.out.println();
            System.out.println(">>>  Opciones de gestión  <<<");
            System.out.println();
            System.out.println("5. Registro de nuevo Book. ");
            System.out.println("6. Estado de inventario. "); // Impresion de stock
            System.out.println("7. Estatus de Usuarios/Clientes.");
            System.out.println("0. Cerrar programa.");
            System.out.println();
            System.out
                    .println("---------------------------------------------------------------------------------------");
            int taskChoise = input.nextInt();
            System.out
                    .println("---------------------------------------------------------------------------------------");
            System.out.println();
            Timer.main(null);
            CleanScreen.CleanScreen();

            switch (taskChoise) {
                case 1: // <FUNCIONANDO>
                    JOptionPane.showMessageDialog(null, "Registro de usuario", "Biblioteca Virtual", 1);
                    System.out.println(">>    Registro de usuario    <<");
                    System.out.println();
                    nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del nuevo usuario", "Biblioteca Virtual", 3);
                    System.out.println("Ingrese el nombre del nuevo usuario: \n" + nombre);
                    System.out.println();
                    email = JOptionPane.showInputDialog(null, "Ingresa el email del nuevo usuario", "Biblioteca Virtual", 3);
                    System.out.println("Ingrese el EMAIL del nuevo usuario: \n" + email);
                    System.out.println();
                    clientes.add(new Cliente(nombre, email));
                    System.out.println("Usuario añadido con éxito!");
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;

                case 2: // <FUNCIONANDO>
                    // Variables del case 2
                    boolean encontrado = false;
                    JOptionPane.showMessageDialog(null, ">>    Busqueda de libro (título // género // autor)    <<", "Biblioteca Virtual", 1);
                    System.out.println(">>    Busqueda de libro (título // género // autor)    <<");
                    System.out.println();
                    System.out.println("Generos disponibles: \n" + "\n" + ">> Terror. \n" + "\n" + ">> Comedia. \n" + "\n" + ">> Fantasia. \n" + "\n" +
                            ">> Ficción. \n" + "\n" + ">> Romance. \n" + "\n" + ">> Documentales. \n" + "\n" + ">> Infantiles. \n" + "\n");
                    System.out.println("");

                    input.nextLine();

                    String choise1 = input.nextLine();
                    String choise = choise1.toLowerCase();
                    System.out.println();

                    for (Book book : stockB.getBooks()) {
                        if (book.getType().toLowerCase().contains(choise)
                                || book.getTitle().toLowerCase().contains(choise)
                                || book.getAuthor().toLowerCase().contains(choise)) {
                            System.out.println("Libro encontrado: " + book.getTitle() + "\n" + ">> Autor: "
                                    + book.getAuthor() + "\n" + ">> Género: " + book.getType() + "\n");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "No se encontró el libro", "Biblioteca Virtual", 2);
                        System.out.println("No se encontró el libro.");

                    }
                    break;

                case 3: // <FUNCIONANDO>
                    JOptionPane.showMessageDialog(null, ">>    Préstamo de libro    <<", "Biblioteca Virtual", 1);
                    System.out.println(">>    Préstamo de libro    <<");
                    System.out.println();
                    prestamoLibro(clientes, stockB);
                    System.out.println();
                    //Timer.main(null);
                    CleanScreen.CleanScreen();
                    //JOptionPane.showConfirmDialog(null, "Desea realizar otro préstamo?", "Biblioteca Virtual", taskChoise, 3);
                    System.out.println("Desea realizar otro préstamo?" + "\n" + "1. Sí" + "\n" + "2. No");
                    System.out.println();
                    int choise2 = input.nextInt();
                    if (choise2 == 1) {
                        prestamoLibro(clientes, stockB);
                        break;
                    }else if(choise2 == 2){
                        System.out.println("Regresando al menú principal...");
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        break;
                    }
                    break;

                case 4: // <FUNCIONANDO>

                    System.out.println(">>    Devolución de libro    <<");
                    System.out.println();
                    System.out.println("Ingrese el nombre del cliente que desea devolver el libro: ");
                    input.nextLine();
                    clienteDevolucion = input.nextLine();
                    System.out.println();
                    Cliente cliente = null;
                    for (Cliente c: clientes) {
                            if (c.getNombre().equalsIgnoreCase(clienteDevolucion.toLowerCase())) {
                                cliente = c;
                                break;
                            }
                    }

                    if (cliente  == null) {
                        System.out.println("No se encontró el cliente.");
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        break;
                    } 
                    
                    System.out.println("Ingrese el nombre del libro a devolver: ");
                    devolucion = input.nextLine();
                    System.out.println();
                    encontrado = false;

                    for (Book libroPrestado : cliente.getLibrosPrestados()) {
                        if (libroPrestado.getTitle().toLowerCase().contains(devolucion.toLowerCase())) {
                            libroPrestado.devolver();
                            cliente.getLibrosPrestados().remove(libroPrestado);
                            System.out.println("El libro " + devolucion + " prestado por el cliente " +  clienteDevolucion + " ha sido devuelto con éxito.");
                            encontrado = true;
                            Timer.main(null);
                            CleanScreen.CleanScreen();
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró el libro.");
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                    }
                    break;

                case 5: // <FUNCIONANDO>
                    System.out.println(">>    Registro de nuevo libro    <<");
                    System.out.println();

                    System.out.println("Ingrese el título del libro: " + input.nextLine());
                    String title = input.nextLine();
                    System.out.println();
                    System.out.println("Ingrese el autor del libro: ");
                    String author = input.nextLine();
                    System.out.println();
                    System.out.println("Ingrese el género del libro: ");
                    String type = input.nextLine();
                    System.out.println();
                    System.out.println("Ingrese el stock del libro: ");
                    int stock1 = input.nextInt();
                    System.out.println();
                    stockB.addBook(new Book(title, author, type, stock1));
                    stockB.getBooks().get(stockB.getBooks().size() - 1).toString();
                    System.out.println("Libro añadido con éxito!");
                    System.out.println();
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;

                case 6: // <FUNCIONANDO>
                    System.out.println(">>    Estado de inventario    <<");
                    System.out.println();
                    System.out.println("Inventario de libros: ");
                    System.out.println();
                    printStock(stockB);
                    System.out.println();
                    System.out.println(">> Presione 0 si desea salir al menú principal. ");
                    salir = input.nextInt();
                    if (salir == 0) {
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                        break;
                    }
                    break;

                case 7: // <FUNCIONANDO>
                    System.out.println(">>    Estatus de usuarios    <<");
                    System.out.println();
                    System.out.println("Usuarios registrados: " + clientes.size() + "\n");
                    printClients(clientes);
                    System.out.println("");
                    System.out.println(">> Presione 0 si desea salir al menú principal. ");
                    salir = input.nextInt();
                    if (salir == 0) {
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                        break;
                    }

                    break;
                case 0:
                    System.out.println("Saliendo del programa... ");
                    System.out.println();
                    System.out.println("¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, intentelo de nuevo. ");
                    break;
            }
        }
        input.close();
    }
}
