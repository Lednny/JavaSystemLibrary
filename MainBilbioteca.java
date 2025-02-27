import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {
    static List<Cliente> clientes = new ArrayList<>();
    static ArrayList<Book> LibrosIguales = new ArrayList<>();
    static ArrayList<Cliente> UsuariosIguales = new ArrayList<>();

    public static void prestamoLibro(List<Cliente> clientes, StockBook stockB) {
        Cliente cliente = buscarClientePorNombre(UsuariosIguales);
        Book libro = buscarLibroPorTitulo(stockB, LibrosIguales);
        if (cliente != null && libro != null) {
            Prestamo prestamo = new Prestamo(cliente);
            prestamo.prestarLibro(libro, stockB);
        } else {
            System.out.println( AnsiColors.RED.TXT + "No se encontró el cliente o el libro." + AnsiColors.RESET);
            Timer.main(null);
            CleanScreen.CleanScreen();
        }
    }

    public static Cliente buscarClientePorNombre(ArrayList<Cliente> UsuariosIguales) {
        UsuariosIguales.clear();
        Scanner input = new Scanner(System.in);
        System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del cliente: " + AnsiColors.RESET);
        String nombre = input.nextLine();
        //System.out.println(nombre);
        System.out.println("");
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre.toLowerCase())) {
                UsuariosIguales.add(cliente);
            }
        }
        if(UsuariosIguales.size() == 1){
            return UsuariosIguales.get(0);
        }else{
            System.out.println("Se han encontrado las siguientes coincidencias:");
            for(int i = 0; i < UsuariosIguales.size(); i++){
                int x = i + 1;
                System.out.println(x + ".- Nombre: " + UsuariosIguales.get(i).getNombre() + " / Mail: " + UsuariosIguales.get(i).getEmail());
            }
            System.out.println("Seleccione el usuario: ");
            //input.nextInt(); //Limpiar buffer
            int eleccion = input.nextInt();
            return UsuariosIguales.get(eleccion-1);
        }
        //return null;
    }

    public static Book buscarLibroPorTitulo(StockBook stockB, ArrayList<Book> LibrosIguales) {
        LibrosIguales.clear();
        Scanner input = new Scanner(System.in);
        System.out.println(AnsiColors.BLUE.TXT + "Ingrese el título del libro: " + AnsiColors.RESET);
        String titulo = input.nextLine();
        System.out.println("");
        for (Book book : stockB.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(titulo.toLowerCase())) {
                LibrosIguales.add(book);
            }
        }
        if(LibrosIguales.size() == 1){
            return LibrosIguales.get(0);
        }else{
            System.out.println("Se han encontrado las siguientes coincidencias:");
            for(int i = 0; i < LibrosIguales.size(); i++){
                int x = i + 1;
                System.out.println(x + ".- Título: " + LibrosIguales.get(i).getTitle() + " / Autor: " + LibrosIguales.get(i).getAuthor() + " / Genero:" + LibrosIguales.get(i).getType());
            }
            System.out.println("Seleccione el libro: ");
            //input.nextInt(); //Limpiar buffer
            int eleccion = input.nextInt();
            return LibrosIguales.get(eleccion-1);
        }
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
        String nombre;
        String email;
        String devolucion;
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
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del nuevo usuario: \n" + AnsiColors.RESET);
                    input.nextLine(); //Limpiar buffer
                    nombre = input.nextLine();
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el EMAIL del nuevo usuario: \n" + AnsiColors.RESET);
                    email = input.nextLine();
                    System.out.println();
                    clientes.add(new Cliente(nombre, email));
                    System.out.println(AnsiColors.GREEN.TXT + "Usuario añadido con éxito!" + AnsiColors.RESET);
                    Timer.main(null);
                    CleanScreen.CleanScreen();
                    break;

                case 2: // <FUNCIONANDO>
                    // Variables del case 2
                    boolean encontrado = false;
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Busqueda de libro (título // género // autor)    <<" + AnsiColors.RESET);
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre, género o autor del libro:" + AnsiColors.RESET);
                    input.nextLine(); //Limpiar buffer
                    System.out.println();
                    String choise1 = input.nextLine();
                    String choise = choise1.toLowerCase();
                    //System.out.println(choise1);
                    System.out.println(AnsiColors.INVERTIDO.TXT + "---------------------------------------------------------------------------------------" + AnsiColors.RESET);
                    System.out.println();

                    for (Book book : stockB.getBooks()) {
                        if (book.getType().toLowerCase().contains(choise)
                                || book.getTitle().toLowerCase().contains(choise)
                                || book.getAuthor().toLowerCase().contains(choise)) {
                            System.out.println("");
                            System.out.println(AnsiColors.BLUE.TXT + "                           Libro encontrado: " + AnsiColors.RESET + AnsiColors.YELLOW.TXT + book.getTitle() + AnsiColors.RESET + "\n" + "                           >> Autor: "
                                    + book.getAuthor() + "\n" + "                           >> Género: " + book.getType() + "\n" + "                           >> Stock: " + book.getStock() + "\n");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println(AnsiColors.RED.TXT + "No se encontró el libro." + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                    }
                    if(encontrado){
                        System.out.println("");
                        System.out.println(AnsiColors.RED.TXT + ">> Presione 0 si desea salir al menú principal. " + AnsiColors.RESET);
                        salir = input.nextInt();
                        if (salir == 0) {
                            Timer.main(null);
                            CleanScreen.CleanScreen();
                            break;
                        }
                    }
                    break;

                case 3: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Préstamo de libro    <<" + AnsiColors.RESET);
                    System.out.println();
                    prestamoLibro(clientes, stockB);
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
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del cliente que desea devolver el libro: " + AnsiColors.RESET);
                    input.nextLine(); //Limpiar buffer
                    clienteDevolucion = input.nextLine();
                    //System.out.println(clienteDevolucion);
                    System.out.println();
                    Cliente cliente = null;
                    for (Cliente c: clientes) {
                            if (c.getNombre().equalsIgnoreCase(clienteDevolucion.toLowerCase())) {
                                cliente = c;
                                break;
                            }
                    }

                    if (cliente  == null) {
                        System.out.println(AnsiColors.RED.TXT + "No se encontró el cliente." + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                        break;
                    } 
                    
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el nombre del libro a devolver: " + AnsiColors.RESET);
                    devolucion = input.nextLine();
                    System.out.println();
                    encontrado = false;

                    for (Book libroPrestado : cliente.getLibrosPrestados()) {
                        if (libroPrestado.getTitle().toLowerCase().contains(devolucion.toLowerCase())) {
                            libroPrestado.devolver();
                            cliente.getLibrosPrestados().remove(libroPrestado);
                            System.out.println(AnsiColors.GREEN.TXT + "El libro " + AnsiColors.RESET + devolucion + AnsiColors.GREEN.TXT + " prestado por el cliente " + AnsiColors.RESET +  clienteDevolucion + AnsiColors.GREEN.TXT + " ha sido devuelto con éxito." + AnsiColors.RESET);
                            encontrado = true;
                            Timer.main(null);
                            CleanScreen.CleanScreen();
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println(AnsiColors.RED.TXT + "No se encontró el libro." + AnsiColors.RESET);
                        Timer.main(null);
                        CleanScreen.CleanScreen();
                    }
                    break;

                case 5: // <FUNCIONANDO>
                    System.out.println(AnsiColors.INVERTIDO.TXT + ">>    Registro de nuevo libro    <<" + AnsiColors.RESET);
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + " Ingrese el título del libro: " +  AnsiColors.RESET + input.nextLine());
                    String title = input.nextLine();
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el autor del libro: " + AnsiColors.RESET);
                    String author = input.nextLine();
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el género del libro: " + AnsiColors.RESET);
                    String type = input.nextLine();
                    System.out.println();
                    System.out.println(AnsiColors.BLUE.TXT + "Ingrese el stock del libro: " + AnsiColors.RESET);
                    int stock1 = input.nextInt();
                    System.out.println();


                    stockB.addBook(new Book(title, author, type, stock1));
                    stockB.getBooks().get(stockB.getBooks().size() - 1).toString();
                    System.out.println(AnsiColors.GREEN.TXT + "Libro añadido con éxito!" + AnsiColors.RESET);
                    System.out.println();
                    Timer.main(null);
                    CleanScreen.CleanScreen();
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
