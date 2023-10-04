package actividad.pkg4;

import java.util.Scanner;

// Programa Creado:por Juan Antonio Flores Zaher Morales

// Clase Principal Actividad4
public class Actividad4 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Dir directorio = new Dir();
        boolean termina = false;
        directorio.load();
        while (!termina) {
            System.out.printf("\n\n%s\n%s\n%s\n%s\n%s\n\n%s",
                    "======== MENU ========", "1. Listar contactos",
                    "2. Crear nuevos contactos", "3. Borrar un contacto",
                    "4. Salir", "¿Seleccione una Opcion del Menu? ");
            switch (leer.nextInt()) {
                case 1:
                    directorio.list();
                    break;
                case 2:
                    System.out.print("\nIngresa el teléfono: ");
                    String phone = leer.next();
                    System.out.print("Ingresa el nombre: ");
                    String name = leer.next();
                    directorio.create(phone, name);
                    break;
                case 3:
                    System.out.print("\nIngresa el teléfono: ");
                    String contact = leer.next();
                    directorio.delete(contact);
                    break;
                case 4:
                    System.out.println("\nSalir");
                    directorio.save();
                    termina = true;
                    break;
                default:
                    System.out.println("Favor de Seleccionar una opción válida");
                    break;
            }
        }
    }

}