import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Archivos {

    private static final String ARCHIVO = "personas.txt";

    private static String leerTexto(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) System.out.println("Error: campo vacío.");
        } while (texto.isEmpty());
        return texto;
    }

    private static int leerEdad(Scanner sc) {
        int edad = -1;
        while (edad <= 0) {
            System.out.print("Ingrese su edad: ");
            try {
                edad = Integer.parseInt(sc.nextLine());
                if (edad <= 0) System.out.println("Error: debe ser positiva.");
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }
        return edad;
    }

    private static String leerCorreo(Scanner sc) {
        String correo;
        do {
            System.out.print("Ingrese su correo: ");
            correo = sc.nextLine().trim();
            if (!correo.contains("@")) System.out.println("Error: correo inválido.");
        } while (!correo.contains("@"));
        return correo;
    }

    private static String leerTelefono(Scanner sc) {
        String tel;
        do {
            System.out.print("Ingrese su teléfono: ");
            tel = sc.nextLine().trim();
            if (!tel.matches("\\d{8,}")) System.out.println("Error: solo dígitos y al menos 8.");
        } while (!tel.matches("\\d{8,}"));
        return tel;
    }

    private static void guardar(String linea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(linea);
            bw.newLine();
            System.out.println("Registro guardado en personas.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de Persona ===");

        String nombre = leerTexto(sc, "Ingrese su nombre completo: ");
        String id = leerTexto(sc, "Ingrese su identificación: ");
        int edad = leerEdad(sc);
        String correo = leerCorreo(sc);
        String tel = leerTelefono(sc);

        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String linea = String.join("|", nombre, id, String.valueOf(edad), correo, tel, fecha);

        guardar(linea);
    }
}
