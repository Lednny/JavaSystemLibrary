import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {

    //     Funcion < Impresion de clientes  >
    public static void printClients(List<Cliente> clientes){
        for(int i = 0; i < clientes.size(); i++){                  
            System.out.println("-Cliente: " + clientes.get(i).getNombre() + "\n" +"Email: " + clientes.get(i).getEmail());
            System.out.println("");
        }
    }
    

    //      Funcion < Impresión de stock >
    public static void printStock(StockBook stockB){
        List<Book> books = stockB.getBooks();
        for (Book  book : books) {
            System.out.println("Titulo: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Genero: " + book.getType());
            System.out.println("Stock: " + book.getStock() + "\n");

        }
        System.out.println();
    }


    public static void main(String args[]) {
        List<Cliente> clientes = new ArrayList<>();        //   INSTANCIA 
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
            System.out.println("2. Búsqueda de Book ");         // Despliega lista de Books - busqueda - opcion de prestamo
            System.out.println("3. Devolución de Book ");
            System.out.println();
            System.out.println(">>>  Opciones de gestión  <<<");
            System.out.println();
            System.out.println("4. Registro de nuevo Book. ");
            System.out.println("5. Estado de inventario. ");     // Impresion de stock
            System.out.println("6. Estatus de Usuarios/Clientes.");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------");
            int taskChoise = input.nextInt();
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println();
            Timer.main(null);
            CleanScreen.CleanScreen();


            switch (taskChoise) {
                case 1:
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

                case 2:
                    //Instancia
                    StockBook stock = new StockBook();
                    List<Book> allBooks = stock.getBooks();

                    //Variables del case 2
                    boolean encontrado = false;
                    
                    System.out.println("2. Búsqueda de Libro (Género, título o autor). ");
                    System.out.println("Generos disponibles: \n" + "-Terror. \n" + "-Comedia. \n" + "-Fantasia. \n" + "-Ficción. \n" + "-Romance. \n" + "-Documentales. \n" + "-Infantiles. \n");
                    System.out.println("");
                    
                    input.nextLine();

                    String choise1 = input.nextLine();
                    String choise = choise1.toLowerCase();
                    System.out.println();

                    for (Book book : allBooks){
                        if (book.getType().toLowerCase().contains(choise) || book.getTitle().toLowerCase().contains(choise) || book.getAuthor().toLowerCase().contains(choise)){
                        System.out.println("Libro encontrado: " + book.getTitle() + "\n" + ">> Autor: " + book.getAuthor() + "\n" + ">> Género: " + book.getType() + "\n");
                        encontrado = true;
                        }
                    }
                    if(!encontrado){
                        System.out.println("No se encontró el libro.");
                        
                    }


                System.out.println("¿Desea realizar un préstamo? \n 1. Sí \n 2. No");
                int lendChoise = input.nextInt();

                if(lendChoise == 1){
                    //
   //                 System.out.println("Ingrese el nombre del libro a prestar: ");
   //             prestamo = input.nextLine();
   //             String prestamo1 = prestamo.toLowerCase();
   //                 for(Book book : stock.getBooks()) {
   //                     if (book.getTitle().toLowerCase().contains(prestamo1)){
   //                         encontrado = true;
   //                         if(!encontrado){
   //                             System.out.println("No se encontró el libro.");
   //                         }
   //                         if(book.prestamo()){
   //                             System.out.println("El libro: " + book.getTitle() + " fue prestado con éxito" + "al usuario: " + clientes.get(clientes.size() - 1).getNombre());
   //                         }else{
   //                             System.out.println("El libro: " + book.getTitle() + " no está disponible.");
   //                         }
   //                         break;
   //                     }
   //                 }
   //                 if(!encontrado){
   //                     System.out.println("No se encontró el libro.");
   //                 }

                    //Préstamo de libro 
//                    encontrado = false;
//
//                    System.out.println("Ingrese el nombre del libro a prestar: ");
//                prestamo = input.nextLine();
//                    for(Book book : stock.getBooks()) {
//                        if (book.getTitle().equalsIgnoreCase(prestamo)){
//                            encontrado = true;
//                            if(!encontrado){
//                                System.out.println("No se encontró el libro.");
//                            }
//                            if(book.prestamo()){
//                                System.out.println("El libro: " + book.getTitle() + " fue prestado con éxito" + "al usuario: " + clientes.get(clientes.size() - 1).getNombre());
//                            }else{
//                                System.out.println("El libro: " + book.getTitle() + " no está disponible.");
//                            }
//                            break;
//                        }
//                    }
//                    if(!encontrado){
//                        System.out.println("No se encontró el libro.");
//                    }

                        break;
                    }
                case 3:
                    System.out.println("3. Devolución de Book ");
                    System.out.println("Ingrese el nombre del libro a devolver: ");
                    devolucion = input.nextLine();
                    encontrado = false;
                    
                    for (Book book : stockB.getBooks()){
                        if (book.getTitle().toLowerCase().contains(devolucion.toLowerCase())){
                            book.devolver();
                            System.out.println("El libro" + book.getTitle() + " ha sido devuelto con éxito.");
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("No se encontró el libro.");
                    }
                        break;
                case 4:
                System.out.println("4. Registro de nuevo Book");
                System.out.println("Ingrese el título del libro: " + input.nextLine());
                String title = input.nextLine();
                System.out.println("Ingrese el autor del libro: ");
                String author = input.nextLine();
                System.out.println("Ingrese el género del libro: ");
                String type = input.nextLine();
                System.out.println("Ingrese el stock del libro: ");
                int stock1 = input.nextInt();
//                allBooks.add(new Book(title, author, type, stock));       ERROR AL MOMENTO DE ALMACENAR EL NUEVO OBJETO
//                allBooks.get(allBooks.size() - 1).infoBook();
                System.out.println("Libro añadido con éxito!");
                    System.out.println();

                        break;
                case 5: 
                    System.out.println(">>    Estado de inventario    <<");
                    System.out.println("Inventario de libros: ");
                    System.out.println();
                    printStock(stockB);
                        break;
                case 6:
                    System.out.println("Lista de clientes registrados:");
                    System.out.println("Usuarios registrados: " + clientes.size() + "\n");
                    printClients(clientes); 
                    System.out.println("");
                        break;
                default:
                    System.out.println("Opción no válida, intentelo de nuevo. ");
                        break;
            }
        }
        input.close();
    }
}
