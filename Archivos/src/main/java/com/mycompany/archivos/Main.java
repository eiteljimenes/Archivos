
package com.mycompany.archivos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Archivos archivo = new Archivos(); // usar tu clase con la lógica

        System.out.println("Ingrese nombre completo:");
        String nombre = archivo.leerNoVacio(sc);

        System.out.println("Ingrese ID o cédula:");
        String id = archivo.leerNoVacio(sc);

        System.out.println("Ingrese edad:");
        int edad = archivo.leerEnteroPositivo(sc);

        System.out.println("Ingrese correo electrónico:");
        String correo = archivo.leerEmailValido(sc);

        System.out.println("Ingrese teléfono:");
        String telefono = archivo.leerTelefonoValido(sc);

        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String linea = nombre + "|" + id + "|" + edad + "|" + correo + "|" + telefono + "|" + fechaHora;

        archivo.guardarLinea(linea);

        System.out.println("✅ Registro guardado en personas.txt");
        sc.close();
    }
}

   
   
