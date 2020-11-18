import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        Boolean end = true;
        AddressBook addressBook = new AddressBook();

        do {
            System.out.println("DIRECTORIO\nSelecciona una opcion:\n1-Mostrar contactos\n2-Crear contacto\n3-Borrar contacto\n0-Salir");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            try {
                switch (option) {
                    case 1:
                        addressBook.list();
                        break;
                    case 2:
                        addressBook.create();
                        System.out.println("Contacto guardado exitosamente");
                        break;
                    case 3:
                        addressBook.delete();
                        break;
                    case 0:
                        System.out.println("Terminando procesos...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Selecciona una opcion valida");
                        main(null);
                        break;
                }
            }catch ( IOException | InputMismatchException ex ) {
                System.err.format("Parametro introducido no establecido en los limites de opciones...\nReiniciando...");
                main(null);
            }

            do {
                System.out.println("\nSeleccionar otra opción? (s/n)");
                String redo = sc.next();
                if (redo.equals("s")) {
                    main(null);
                }
                else if (redo.equals("n")) {
                    end = false;
                }
                else {
                    System.out.println("Selecciona una opcion valida");
                }
            }while(end);
        }while(end);
    }
}
