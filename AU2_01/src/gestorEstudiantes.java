// -*- coding: utf-8 -*-
import java.util.Scanner;
import java.util.ArrayList;

public class gestorEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
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
        
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } else {
            System.out.println("Error: Por favor, introduce un número válido.");
            scanner.nextLine(); // Limpiar el buffer
            opcion = -1; // Asignar un valor inválido para que no se ejecute ninguna opción
        }

        switch (opcion) {
            case 1:
                try {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    // Validar nombre vacío
                    if (nombre.trim().isEmpty()) {
                        throw new IllegalArgumentException("El nombre no puede estar vacío");
                    }
                    
                    // Validar que el nombre solo contiene letras
                    if (!nombre.matches("^[a-zA-Z\\s]+$")) {
                        throw new IllegalArgumentException("El nombre solo debe contener letras");
                    }
                    
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());
                    
                    // Validar edad negativa
                    if (edad < 0) {
                        throw new IllegalArgumentException("La edad no puede ser negativa");
                    }
                    
                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();
                    
                    System.out.print("Nota: ");
                    double nota = Double.parseDouble(scanner.nextLine());
                    
                    // Validar nota negativa
                    if (nota < 0) {
                        throw new IllegalArgumentException("La nota no puede ser negativa");
                    }
                    
                    estudiantes.add(new Estudiante(nombre, edad, curso, nota));
                    System.out.println("Estudiante añadido correctamente.");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Por favor, introduce un número válido.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("\nLista de estudiantes:");
                for (Estudiante e : estudiantes) {
                    System.out.println(e);
                }
                break;
            case 3:
                System.out.print("Introduce el nombre a buscar: ");
                String buscarNombre = scanner.nextLine();
                boolean encontrado = false;
                for (Estudiante e : estudiantes) {
                    if (e.getNombre().equalsIgnoreCase(buscarNombre)) {
                        System.out.println(e);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró ningún estudiante con ese nombre.");
                }
                break;
            case 4:
                if (estudiantes.isEmpty()) {
                    System.out.println("No hay estudiantes para calcular la media.");
                } else {
                    double sumaNotas = 0;
                    for (Estudiante e : estudiantes) {
                        sumaNotas += e.getNota();
                    }
                    double media = sumaNotas / estudiantes.size();
                    System.out.printf("La media de notas es: %.2f%n", media);
                }
                break;
            case 5:
                if (estudiantes.isEmpty()) {
                    System.out.println("No hay estudiantes para mostrar.");
                } else {
                    Estudiante mejorEstudiante = estudiantes.get(0);
                    for (Estudiante e : estudiantes) {
                        if (e.getNota() > mejorEstudiante.getNota()) {
                            mejorEstudiante = e;
                        }
                    }
                    System.out.println("El mejor estudiante es:");
                    System.out.println(mejorEstudiante);
                }
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    } while (opcion != 6);
    scanner.close();
}
}