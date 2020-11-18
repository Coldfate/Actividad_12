import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    static Map <String, String> map = new HashMap<>();
/*
    public static void save () throws IOException {
        String file = "D:\\Actividad_12\\Addressbook.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        writer.writeAll(map);
    }
*/
    public static void create() {
        String number;
        String name;

        System.out.print("Introduce el numero telefonico del contacto: ");
        number = sc.nextLine();
        System.out.print("Introduce el nombre del contacto: ");
        name = sc.nextLine();
        map.put(number, name);
    }
    public void list () throws IOException {
        if (map.isEmpty()) {
            System.out.println("lista vacia");
        }else {
            System.out.println("Contactos: ");
            for (Map.Entry<String, String> e : map.entrySet())
                System.out.println(e.getKey() + " : " + e.getValue());
            System.out.println("Presiona ENTER para continuar...");
            System.in.read();
        }
    }
    public void delete () {
        String number;
        System.out.print("Introduce el numero telefonico del contacto a eliminar:");
        number = sc.nextLine();
        if (map.containsKey(number)){
            map.remove(number);
            System.out.println("Contacto eliminado correctamente");
            System.out.println("Presiona ENTER para continuar...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("El numero telefonico no existe");
        }

    }

}
