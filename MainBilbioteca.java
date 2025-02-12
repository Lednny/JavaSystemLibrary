import java.util.Scanner;
public class MainBilbioteca{
    public static void main(String args[]){

        //Variables
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        //Menú
        System.out.println("¡Hola, Bienvenido a la Biblioteca virtual de Java!");

        while (continuar) {
            System.out.println("");
            System.out.println("----Menú de la Biblioteca---");
            System.out.println("¿Qué deseas realizar?");
            System.out.println("1. Búsqueda de libro");
            System.out.println("2. Préstamo de Libros ");
            System.out.println("3. Registro de ");
            System.out.println("4. División.");
            System.out.println("Presiona la tecla 5 si deseas salir.");

            System.out.println("");

            int taskChoise = 0; 
            input.nextInt();

            System.out.println("");

            switch (taskChoise) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3: 
                    
                    break;
                default:
                    System.out.println("Opción no válida, intentelo de nuevo. ");
                    break;
            }
    }
        input.close();
    }
}