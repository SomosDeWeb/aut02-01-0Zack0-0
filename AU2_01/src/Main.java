import Java.util.Scanner;
import Java.util.ArrayList;

public class gestorEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estuidante> estudiantes = new ArrayList<>();
        int opcion;

        do{
            System.out.println("\n=== GESTOR DE ESTUDIANTES ===");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Calcular media de notas");
            System.out.println("5. Mostrar mejor estudiante");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
        }
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
    }
}