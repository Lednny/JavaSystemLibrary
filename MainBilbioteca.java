import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {
List<Cliente> clientes = new ArrayList<>();
    // Funciones de soporte para < PRESTAMO >
private static void inicializarDatos(StockBook stockB, List<Cliente> clientes) {
    //  Libros
    stockB.getBooks();

    // Agregar clientes
    
    
}

    // Funcion < Ejecución de prestamo >

    public void lendBook() {
        Scanner scanner = new Scanner(System.in);
        inicializarDatos();

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Ver préstamos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarPrestamo(scanner);
                    break;
                case 2:
                    verPrestamos();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    
    private static void registrarPrestamo(Scanner scanner, List<Book> stockB) {
        System.out.println("Lista de libros:");
        for (int i = 0; i < stockB.size(); i++) {
            System.out.println((i + 1) + ". " + stockB.get(i));
        }
        System.out.print("Seleccione el número del libro a prestar: ");
        int indiceLibro = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir el salto de línea

        if (indiceLibro < 0 || indiceLibro >= stockB.size()) {
            System.out.println("Número de libro no válido.");
            return;
        }

        Book libro = stockB.get(indiceLibro);
        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        System.out.println("Lista de clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
        System.out.print("Seleccione el número del cliente: ");
        int indiceCliente = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir el salto de línea

        if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
            System.out.println("Número de cliente no válido.");
            return;
        }

        Cliente cliente = clientes.get(indiceCliente);

        System.out.print("Ingrese la fecha de préstamo (YYYY-MM-DD): ");
        String fechaPrestamo = scanner.nextLine();
        System.out.print("Ingrese la fecha de devolución (YYYY-MM-DD): ");
        String fechaDevolucion = scanner.nextLine();

        Prestamo prestamo = new Prestamo(libro, cliente, fechaPrestamo, fechaDevolucion);
        prestamos.add(prestamo);

        System.out.println("Préstamo registrado exitosamente.");
    }

































    // Funcion < Impresion de clientes >
    public static void printClients(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(
                    "-Cliente: " + clientes.get(i).getNombre() + "\n" + "Email: " + clientes.get(i).getEmail());
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
        Cliente clientes = new Cliente();
        StockBook stockB = new StockBook();
        String nombre;
        String email;
        String devolucion = "";
        String prestamo = "";
        // Cliente nuevoUsuario = new Cliente("", "");

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
            System.out.println("2. Búsqueda de Book "); // Despliega lista de Books - busqueda - opcion de prestamo
            System.out.println("3. Devolución de Book ");
            System.out.println();
            System.out.println(">>>  Opciones de gestión  <<<");
            System.out.println();
            System.out.println("4. Registro de nuevo Book. ");
            System.out.println("5. Estado de inventario. "); // Impresion de stock
            System.out.println("6. Estatus de Usuarios/Clientes.");
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
                    System.out.println("1. Registro de Usuario ");
                    System.out.println("Ingrese el nombre del nuevo usuario: ");
                    input.nextLine();
                    nombre = input.nextLine();
                    System.out.println("Ingrese el EMAIL del nuevo usuario: ");
                    email = input.nextLine();
                    System.out.println();
                    clientes.add(new Cliente(nombre, email));
                    clientes.get(clientes.size() - 1).infoUser();
                    System.out.println("Usuario añadido con éxito!");
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;

                case 2: // <FUNCIONANDO>
                    // Variables del case 2
                    boolean encontrado = false;

                    System.out.println("2. Búsqueda de Libro (Género, título o autor). ");
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
                case 3: // EN DESARROLLO <pendiente>

                    System.out.println("3. Devolución de Book ");
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

                case 4: // <FUNCIONANDO>
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

                case 5: // <FUNCIONANDO>
                    System.out.println(">>    Estado de inventario    <<");
                    System.out.println();
                    System.out.println("Inventario de libros: ");
                    System.out.println();
                    printStock(stockB);
                    break;

                case 6:
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
