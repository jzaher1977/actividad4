package actividad.pkg4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Programa Creado:por Juan Antonio Flores Zaher Morales

public class Dir {

    HashMap<String, String> addressBook = new HashMap<>();
    File file = new File("C:\\Practicas\\actividad4\\data\\Directorio.txt");

    public void save() {
        String phone;
        String name;
        String contacts = "";
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            // Concatenar toda la información
            if (!addressBook.entrySet().isEmpty()) {
                for (Map.Entry<String, String> entry : addressBook.entrySet()) {
                    phone = entry.getKey();
                    name = entry.getValue();
                    contacts += phone + "," + name + "\r\n";
                }
            }
            // Se inicia la lectura del archivo
            BufferedWriter fileToSave = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file, false), "utf-8"));
            // Se Escribe la información en el archivo
            fileToSave.write(contacts);
            fileToSave.close();

        } catch (Exception e) {
            System.out.println("save(): " + e.getMessage());
        }
    }

    public void load() {
        try {
            if (file.exists()) {
                // Se inicia la lectura del archivo
                BufferedReader loadedFile = new BufferedReader(new FileReader(file));
                String lineaActual;
                // Ciclo para agregar el contenido del txt al addressBook
                while ((lineaActual = loadedFile.readLine()) != null) {
                    String[] contacto = lineaActual.split(",");
                    addressBook.put(contacto[0], contacto[1]);
                }
                // Cerrar la lectura
                loadedFile.close();
            }

        } catch (Exception e) {
            System.out.println("load(): " + e.getMessage());
        }
    }

    public void create(String phone, String name) {
        if (!addressBook.containsKey(phone)) {
            addressBook.put(phone, name);
            System.out.printf("\n%s%s%s", "Se agregó a ", name,
                    " a los contactos");
        } else {
            System.out.println("\nYa existe ese contacto");
        }
    }

    public void list() {
        if (addressBook.entrySet().isEmpty()) {
            System.out.println("\nNo tienes contactos agregados");
        } else {
            System.out.println("Contactos: ");
            for (Map.Entry<String, String> entry : addressBook.entrySet()) {
                System.out.printf("\n%s%s%s", entry.getKey(),
                        ": ", entry.getValue());
            }
        }
    }

    public void delete(String phone) {
        if (addressBook.containsKey(phone)) {
            System.out.printf("\n%s%s%s", "Se ha eliminado a ",
                    addressBook.get(phone), " de tus contactos");
            addressBook.remove(phone);
        } else if (addressBook.entrySet().isEmpty()) {
            System.out.println("\nNo tienes contactos agregados");
        } else {
            System.out.println("\nEse número no está en tus contactos");
        }
    }

}