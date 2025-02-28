import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {

    public static void addNewBook(List<Book> books, StockBook stockB, Scanner input, String title, String author, Scanner scanner) {
        if (stockB.getBooks().size() > 0) {
            boolean found = false;
        
            for (Book book : stockB.getBooks()) {
                if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println(AnsiColors.RED.TXT + "El libro ya existe en el inventario." + AnsiColors.RESET);
                    found = true;
                    Timer.main(null);
                    System.out.println();
                    System.out.println( AnsiColors.BLUE.TXT + "¿Desea añadir mas stock a este libro? \n (1) - Si \n (2) - No" + AnsiColors.RESET);
                    int addChoise = input.nextInt();

                    if (addChoise == 1) {
                        System.out.println( AnsiColors.BLUE.TXT + "Ingrese la cantidad a añadir a stock: " + AnsiColors.RESET);
                        int add1 = input.nextInt();
                        book.setStock(book.getStock() + add1);
                        System.out.println(AnsiColors.GREEN.TXT + "Stock actualizado con éxito" + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        return;
                    } else if(addChoise == 2){
                        System.out.println( AnsiColors.RED.TXT + "Saliendo..." + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        return;
                    }

                    System.out.println();
                    
                    break;
                }
            }
        
            if (!found) {
                System.out.println(AnsiColors.BLUE.TXT + "Ingrese el género del libro: " + AnsiColors.RESET);
                String type = input.nextLine();
                System.out.println();
                System.out.println(AnsiColors.BLUE.TXT + "Ingrese el stock del libro: " + AnsiColors.RESET);
                int stock1 = input.nextInt();
                input.nextLine(); 
                System.out.println();
                stockB.addBook(new Book(title, author, type, stock1));
                System.out.println(AnsiColors.GREEN.TXT + "Libro añadido con éxito!" + AnsiColors.RESET);
                Timer.main(null);
                CleanScreen.CleanScreen();
            }
        } else {
            System.out.println(AnsiColors.BLUE.TXT + "Ingrese el género del libro: " + AnsiColors.RESET);
            String type = input.nextLine();
            System.out.println();
            System.out.println(AnsiColors.BLUE.TXT + "Ingrese el stock del libro: " + AnsiColors.RESET);
            int stock1 = input.nextInt();
            input.nextLine(); 
            System.out.println();
            stockB.addBook(new Book(title, author, type, stock1));
            System.out.println(AnsiColors.GREEN.TXT + "Libro añadido con éxito!" + AnsiColors.RESET);
            Timer.main(null);
            CleanScreen.CleanScreen();
        }
        
        }

    public static void userRegist(String nombre, String email, Scanner input) {
        System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del nuevo usuario: \n" + AnsiColors.RED.TXT + "Si desea cancelar la operación, presione Enter (procure que la celda este vacía.)" + AnsiColors.RESET);
        input.nextLine();
        nombre = input.nextLine();//
        if(nombre.trim().isEmpty()){
            System.out.println(AnsiColors.RED.TXT + "Saliendo..." + AnsiColors.RESET);
            Timer.main(null);
            CleanScreen.CleanScreen();
            return;
        } else {
            System.out.println();
            System.out.println(AnsiColors.BLUE.TXT + "Ingrese el EMAIL del nuevo usuario: \n" + AnsiColors.RESET);
            email = input.nextLine();
            System.out.println();
            clientes.add(new Cliente(nombre, email));
            System.out.println(AnsiColors.GREEN.TXT + "Usuario añadido con éxito!" + AnsiColors.RESET);
            Timer.main(null);
            CleanScreen.CleanScreen();
        }
    }


    static List<Cliente> clientes = new ArrayList<>();

    public static void prestamoLibro(List<Cliente> clientes, StockBook stockB) {
        Cliente cliente = buscarClientePorNombre();
        if (cliente != null) {
            Book libro = buscarLibroPorTituloYAutor(stockB);
            if (libro != null) {
                Prestamo prestamo = new Prestamo(cliente);
                prestamo.prestarLibro(libro, stockB);
            } else {
                System.out.println(AnsiColors.RED.TXT + "No se encontró el libro." + AnsiColors.RESET);
            }
        } else {
            System.out.println(AnsiColors.RED.TXT + "No se encontró el cliente." + AnsiColors.RESET);
        }
        Timer.main(null);
        CleanScreen.CleanScreen();
    }

    public static Book buscarLibroPorTituloYAutor(StockBook stockB) {
        Scanner input = new Scanner(System.in);
        System.out.println(AnsiColors.BLUE.TXT + "Ingrese el título del libro: " + AnsiColors.RESET);
        String titulo = input.nextLine();
        System.out.println();
        List<Book> librosEncontrados = new ArrayList<>();
        for (Book book : stockB.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(titulo)) {
                librosEncontrados.add(book);
            }
        }
        if (librosEncontrados.size() == 0) {
            return null;
        } else if (librosEncontrados.size() == 1) {
            return librosEncontrados.get(0);
        } else {
            System.out.println(AnsiColors.BLUE.TXT + "Se encontraron varios libros con el mismo título. Ingrese el nombre del autor: " + AnsiColors.RESET);
            String autor = input.nextLine();
            System.out.println();
            for (Book book : librosEncontrados) {
                if (book.getAuthor().equalsIgnoreCase(autor)) {
                    return book;
                }
            }
            return null;
        }
    }


    public static Cliente buscarClientePorNombre() {
        Scanner input = new Scanner(System.in);
        System.out.println(AnsiColors.RED.TXT + "Si desea cancelar la operación, presione Enter (procure que la celda este vacía.)" + AnsiColors.RESET);
        System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del cliente: " + AnsiColors.RESET);
        String nombre = input.nextLine();
        System.out.println();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre.toLowerCase())) {
                return cliente;
            }
        }
        return null;
    }

    // Funcion < Impresion de clientes >
    public static void printClients(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(
                    AnsiColors.BLUE.TXT + "- Cliente: " + AnsiColors.RESET + clientes.get(i).getNombre() + "\n" + AnsiColors.BLUE.TXT + "- Email: " + AnsiColors.RESET + clientes.get(i).getEmail() + "\n" + AnsiColors.RED.TXT + "- Libros Prestados: " + AnsiColors.RESET + clientes.get(i).getLibrosPrestados().size());
            System.out.println();
            System.out.println(AnsiColors.GREEN.TXT + "Libros prestados: " + AnsiColors.RESET);
            clientes.get(i).showLendBooks();
            System.out .println();
            System.out.println(AnsiColors.INVERTIDO.TXT + "-----------------------------------------------------------------------------------------------" + AnsiColors.RESET);
        }
    }

    // Funcion < Impresión de stock >
    public static void printStock(StockBook stockB) {
        List<Book> books = stockB.getBooks();
        for (Book book : books) {
            System.out.println(AnsiColors.BLUE.TXT + ">> Titulo: " + AnsiColors.RESET + book.getTitle());
            System.out.println(AnsiColors.BLUE.TXT + ">> Autor: " + AnsiColors.RESET + book.getAuthor());
            System.out.println(AnsiColors.BLUE.TXT + ">> Genero: " + AnsiColors.RESET + AnsiColors.RED.TXT +  book.getType() +  AnsiColors.RESET);
            System.out.println(AnsiColors.BLUE.TXT + ">> Stock: " + AnsiColors.RESET + AnsiColors.RED.TXT  + book.getStock() +  AnsiColors.RESET + "\n");

        }
        System.out.println();
    }

    public static void main(String args[]) {
//        List<Cliente> clientes = new ArrayList<>();
        StockBook stockB = new StockBook();
        String nombre = "";
        String email = "";

        String clienteDevolucion;
        int salir;

        // Variables
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        // Menú
        System.out.println();
        System.out.println(AnsiColors.RED.TXT + "¡Hola, Bienvenido a la Biblioteca virtual de Java!" + AnsiColors.RESET);

        System.out.println("");

        while (continuar) {
            System.out.println("");
            System.out.print(AnsiColors.INVERTIDO.TXT + "-------------------------- Menú de la Biblioteca Virtual ----------------------------" + AnsiColors.RESET);
            System.out.println();
            System.out.println();
            System.out.println(AnsiColors.GREEN.TXT + "                           >>>  ¿Qué deseas realizar?  <<<" + AnsiColors.RESET);
            System.out.println();
            System.out.println("                               1. Registro de Usuario ");
            System.out.println("                               2. Búsqueda de Book "); // Despliega lista de Books - busqueda
            System.out.println("                               3. Préstamo de libro "); // Prestamo de libro
            System.out.println("                               4. Devolución de Book ");
            System.out.println();
            System.out.println(AnsiColors.GREEN.TXT + "                           >>>  Opciones de gestión  <<<" + AnsiColors.RESET);
            System.out.println();
            System.out.println("                               5. Registro de nuevo Book. ");
            System.out.println("                               6. Estado de inventario. "); // Impresion de stock
            System.out.println("                               7. Estatus de Usuarios/Clientes.");
            System.out.println(AnsiColors.RED.TXT + "                               0. Cerrar programa." + AnsiColors.RESET);
            System.out.println();
            System.out
                    .println(AnsiColors.INVERTIDO.TXT + "---------------------------------------------------------------------------------------" + AnsiColors.RESET);
            int taskChoise = input.nextInt();
            System.out
                    .println(AnsiColors.INVERTIDO.TXT + "---------------------------------------------------------------------------------------" + AnsiColors.RESET);
            System.out.println();
            Timer.main(null);
            CleanScreen.CleanScreen();

            switch (taskChoise) {
                case 1: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Registro de usuario    <<" + AnsiColors.RESET);
                    System.out.println();
                    userRegist(nombre, email, input);
                    break;
                case 2: // <FUNCIONANDO>
                    // Variables del case 2
                    boolean encontrado = false;
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Busqueda de libro (título // género // autor)    <<" + AnsiColors.RESET);
                    System.out.println();
                    System.out.println( AnsiColors.BLUE.TXT + "Generos disponibles: \n" + AnsiColors.RED.TXT + "Si desea cancelar la operación, presione Enter (procure que la celda este vacía.)" + AnsiColors.RESET + "\n" + "\n" + ">> Terror. \n" + "\n" + ">> Comedia. \n" + "\n" + ">> Fantasia. \n" + "\n" +
                    ">> Ficción. \n" + "\n" + ">> Romance. \n" + "\n" + ">> Documentales. \n" + "\n" + ">> Infantiles. \n" + "\n");
                    System.out.println("");

                    input.nextLine();

                    String choise1 = input.nextLine();
                    String choise = choise1.toLowerCase();
                    if(choise1.trim().isEmpty()){
                    System.out.println(AnsiColors.RED.TXT + "Saliendo..." + AnsiColors.RESET);
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    continue;
                    } else {
                    System.out.println();

                    for (Book book : stockB.getBooks()) {
                        if (book.getType().toLowerCase().contains(choise)
                                || book.getTitle().toLowerCase().contains(choise)
                                || book.getAuthor().toLowerCase().contains(choise)) {
                            System.out.println("");
                            System.out.println(AnsiColors.BLUE.TXT + "                           Libro encontrado: " + AnsiColors.RESET + AnsiColors.YELLOW.TXT + book.getTitle() + AnsiColors.RESET + "\n" + "                           >> Autor: "
                                    + book.getAuthor() + "\n" + "                           >> Género: " + book.getType() + "\n");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println(AnsiColors.RED.TXT + "No se encontró el libro." + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                    }
                    if(encontrado){
                        System.out.println(AnsiColors.RED.TXT + ">> Presione 0 si desea salir al menú principal. " + AnsiColors.RESET);
                        salir = input.nextInt();
                        if (salir == 0) {
                            Timer.main(null);
                            CleanScreen.CleanScreen();
                            break;
                        }
                    }
                }
                    break;

                case 3: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Préstamo de libro    <<" + AnsiColors.RESET);
                    System.out.println();
                    prestamoLibro(clientes, stockB);
                    System.out.println();
                    System.out.println();
                    //Timer.main(null);
                    CleanScreen.CleanScreen();
                    System.out.println("Desea realizar otro préstamo?" + "\n" + AnsiColors.GREEN.TXT + "1. Sí" + AnsiColors.RESET +  "\n" + AnsiColors.RED.TXT + "2. No" + AnsiColors.RESET);
                    System.out.println();
                    int choise2 = input.nextInt();
                    if (choise2 == 1) {
                        prestamoLibro(clientes, stockB);
                        break;
                    }else if(choise2 == 2){
                        System.out.println(AnsiColors.RED.TXT + "Regresando al menú principal..." + AnsiColors.RESET);  
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        break;
                    }
                    break;
                

                case 4: // <FUNCIONANDO>
                System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Devolución de libro    <<" + AnsiColors.RESET);
                System.out.println();
                
                System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del cliente que desea devolver el libro: \n" +
                        AnsiColors.RED.TXT + "Si desea cancelar la operación, presione Enter (procure que la celda esté vacía.)" + AnsiColors.RESET);
                input.nextLine();
                clienteDevolucion = input.nextLine();
                
                if (clienteDevolucion.trim().isEmpty()) {
                    System.out.println(AnsiColors.RED.TXT + "Saliendo..." + AnsiColors.RESET);
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    continue;
                }
            
                Cliente cliente = null;
                for (Cliente c : clientes) {
                    if (c.getNombre().equalsIgnoreCase(clienteDevolucion.toLowerCase())) {
                        cliente = c;
                        break;
                    }
                }
            
                if (cliente == null) {
                    System.out.println(AnsiColors.RED.TXT + "No se encontró el cliente." + AnsiColors.RESET);
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;
                }
            
                System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del libro a devolver: " + AnsiColors.RESET);
                String tituloDevolucion = input.nextLine();
                System.out.println();
            
                List<Book> librosCoincidentes = new ArrayList<>();
                for (Book libroPrestado : cliente.getLibrosPrestados()) {
                    if (libroPrestado.getTitle().equalsIgnoreCase(tituloDevolucion)) {
                        librosCoincidentes.add(libroPrestado);
                    }
                }
            
                if (librosCoincidentes.isEmpty()) {
                    System.out.println(AnsiColors.RED.TXT + "No se encontró el libro prestado con ese título." + AnsiColors.RESET);
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;
                }
            
                Book libroDevolver = null;
            
                if (librosCoincidentes.size() == 1) {
                    libroDevolver = librosCoincidentes.get(0);
                } else {
                    System.out.println(AnsiColors.BLUE.TXT + "Se encontraron varios libros con el mismo título. Ingrese el nombre del autor: " + AnsiColors.RESET);
                    String autorDevolucion = input.nextLine();
                    System.out.println();
            
                    for (Book libro : librosCoincidentes) {
                        if (libro.getAuthor().equalsIgnoreCase(autorDevolucion)) {
                            libroDevolver = libro;
                            break;
                        }
                    }
            
                    if (libroDevolver == null) {
                        System.out.println(AnsiColors.RED.TXT + "No se encontró un libro con ese título y autor." + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        break;
                    }
                }
            
                // Remover el libro del cliente y actualizar el stock
                libroDevolver.devolver();
                cliente.getLibrosPrestados().remove(libroDevolver);
            
                System.out.println(AnsiColors.GREEN.TXT + "El libro " + AnsiColors.RESET + libroDevolver.getTitle() +
                        AnsiColors.GREEN.TXT + " prestado por el cliente " + AnsiColors.RESET + cliente.getNombre() +
                        AnsiColors.GREEN.TXT + " ha sido devuelto con éxito." + AnsiColors.RESET);
            
                Timer.main(null);
                CleanScreen.CleanScreen();
                break;

                case 5: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Registro de nuevo libro    <<" + AnsiColors.RESET);
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el título del libro: " +  AnsiColors.RESET + input.nextLine());
                    String title = input.nextLine();
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el autor del libro: " + AnsiColors.RESET);
                    String author = input.nextLine();
                    System.out.println();
                    addNewBook(null, stockB, input, title, author, input);
                        break;

                case 6: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Estado de inventario    <<" + AnsiColors.RESET);
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Inventario de libros: " + AnsiColors.RESET);
                    System.out.println();
                    printStock(stockB);
                    System.out.println();
                    System.out.println(AnsiColors.RED.TXT + ">> Presione 0 si desea salir al menú principal. " + AnsiColors.RESET);
                    salir = input.nextInt();
                    if (salir == 0) {
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                        break;
                    }
                    break;

                case 7: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Estatus de usuarios    <<" + AnsiColors.RESET);
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Usuarios registrados: " + AnsiColors.RESET + clientes.size() + "\n");
                    printClients(clientes);
                    System.out.println("");
                    System.out.println(AnsiColors.RED.TXT + ">> Presione 0 si desea salir al menú principal. " + AnsiColors.RESET);
                    salir = input.nextInt();
                    if (salir == 0) {
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                        break;
                    }

                    break;
                case 0:
                System.out.println();
                System.out.println();
                    System.out.println(AnsiColors.GREEN.TXT + "Saliendo del programa... " + AnsiColors.RESET);
                    System.out.println();
                    Timer.main(null);
                    System.out.println(AnsiColors.GREEN.TXT + "¡Hasta luego!" + AnsiColors.RESET);
                    continuar = false;
                    break;
                default:
                    System.out.println(AnsiColors.RED.TXT + "Opción no válida, intentelo de nuevo. " + AnsiColors.RESET);
                    break;
            }
        }
        input.close();
    }
}