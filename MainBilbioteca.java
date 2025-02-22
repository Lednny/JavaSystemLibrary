import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {
    static List<Cliente> clientes = new ArrayList<>();

    // Función para préstamo
    // private static void inicializarDatos(StockBook stockB, List<Cliente>
    // clientes) {
    // //Libros
    // stockB.getBooks();
    // }

    public static Cliente buscarClientePorNombre() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = input.nextLine();
        System.out.println("");
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().toLowerCase().equalsIgnoreCase(nombre.toLowerCase())) {
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
            if (book.getTitle().toLowerCase().equalsIgnoreCase(titulo.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    // Funcion < Impresion de clientes >
    public static void printClients(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(
                    "- Cliente: " + clientes.get(i).getNombre() + "\n" + "- Email: " + clientes.get(i).getEmail());
            System.out.println("");
        }
    }

    // Funcion < Impresión de stock >
    public static void printStock(StockBook stockB) {
        List<Book> books = stockB.getBooks();
        for (Book book : books) {
            System.out.println("Titulo: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Genero: " + book.getType());
            System.out.println("Stock: " + book.getStock() + "\n");

        }
        System.out.println();
    }

    public static void main(String args[]) {
        List<Cliente> clientes = new ArrayList<>();
        StockBook stockB = new StockBook();
        String nombre;
        String email;
        String devolucion = "";

        // Variables
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        // Menú
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
            System.out.println("8. Cerrar programa.");
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
                    System.out.println("1. Registro de Usuario ");
                    System.out.println("Ingrese el nombre del nuevo usuario: ");
                    input.nextLine();
                    nombre = input.nextLine();
                    System.out.println("Ingrese el EMAIL del nuevo usuario: ");
                    email = input.nextLine();
                    System.out.println();
                    clientes.add(new Cliente(nombre, email));
                    // clientes.getCliente().get(clientes.getCliente().size());
                    System.out.println("Usuario añadido con éxito!");
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;

                case 2: // <FUNCIONANDO>
                    // Variables del case 2
                    boolean encontrado = false;
                    System.out.println("2. Búsqueda de Libro (Género, título o autor). ");
                    System.out.println();
                    System.out.println("Generos disponibles: \n" + "-Terror. \n" + "-Comedia. \n" + "-Fantasia. \n"
                            + "-Ficción. \n" + "-Romance. \n" + "-Documentales. \n" + "-Infantiles. \n");
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
                        System.out.println("No se encontró el libro.");

                    }
                    break;

                case 3: //
                    System.out.println("3. Préstamo de libro ");
                    System.out.println();
                    Cliente cliente = buscarClientePorNombre();
                    Book libro = buscarLibroPorTitulo(stockB);
                    if (cliente != null && libro != null) {
                        Prestamo prestamo = new Prestamo(cliente);
                        prestamo.prestarLibro(libro, stockB);
                    } else {
                        System.out.println("No se encontró el cliente o el libro.");
                    }
                    break;

                case 4: // EN DESARROLLO <pendiente>

                    System.out.println("3. Devolución de Book ");
                    System.out.println("<TEST> - EN DESARROLLO");
                    System.out.println();
                    System.out.println("Ingrese el nombre del libro a devolver: ");
                    devolucion = input.nextLine();
                    encontrado = false;

                    for (Book book : stockB.getBooks()) {
                        if (book.getTitle().toLowerCase().contains(devolucion.toLowerCase())) {
                            book.devolver();
                            System.out.println("El libro" + book.getTitle() + " ha sido devuelto con éxito.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró el libro.");
                    }
                    break;

                case 5: // <FUNCIONANDO>
                    System.out.println("4. Registro de nuevo Book");
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
                    break;

                case 6: // <FUNCIONANDO>
                    System.out.println(">>    Estado de inventario    <<");
                    System.out.println();
                    System.out.println("Inventario de libros: ");
                    System.out.println();
                    printStock(stockB);
                    break;

                case 7: // <FUNCIONANDO>
                    System.out.println("6. Estatus de Usuarios/Clientes.");
                    System.out.println();
                    System.out.println("Lista de clientes registrados:");
                    System.out.println();
                    System.out.println("Usuarios registrados: " + clientes.size() + "\n");
                    printClients(clientes);
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Saliendo del programa... ");
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
