import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBilbioteca {
    public static void main(String args[]) {
        List<Cliente> clientes = new ArrayList<>();
        List<Book> book = new ArrayList<>();
        String nombre;
        String email;
        // Cliente nuevoUsuario = new Cliente("", "");

        // Variables
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        // Menú
        System.out.println("¡Hola, Bienvenido a la Biblioteca virtual de Java!");

        System.out.println("");

        while (continuar) {
            System.out.println("");
            System.out.println("---------------------------Menú de la Biblioteca Virtual-----------------------------");
            System.out.println("  ¿Qué deseas realizar? ");
            System.out.println("1. Registro de Usuario");
            System.out.println("2. Búsqueda de libro ");
            System.out.println("3. Préstamo de libro ");
            System.out.println("4. Registro de libro");
            System.out.println("Presiona la tecla 5 si deseas salir.");
            System.out.println("");
            int taskChoise = 0;
            input.nextInt();
            System.out.println("");
            switch (taskChoise) {
                case 1:
                    System.out.println("1. Registro de Usuario");
                    // Solicitar Nombre
                    nombre = "uno";
                    email = "dos";
                    clientes.add(new Cliente(nombre, email));
                    break;
                case 2:
                    System.out.println("2. Búsqueda de libro");
                    break;
                case 3:
                    System.out.println("3. Préstamo de libro");
                    break;
                case 4:
                    System.out.println("4. Registro de libro");
                    break;

                default:
                    System.out.println("Opción no válida, intentelo de nuevo. ");
                    break;
            }
        }
        input.close();
    }
}