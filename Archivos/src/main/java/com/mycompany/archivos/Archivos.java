package com.mycompany.archivos;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Archivos {

    private static final String ARCHIVO = "personas.txt";

    public String leerNoVacio(Scanner sc) {
        String texto;
        do {
            texto = sc.nextLine();
            if (texto.isEmpty()) {
                System.out.print("Dato vacío. Intente de nuevo: ");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public int leerEnteroPositivo(Scanner sc) {
        int numero = -1;
        while (numero <= 0) {
            try {
                numero = Integer.parseInt(sc.nextLine());
                if (numero <= 0) {
                    System.out.print("Ingrese un número positivo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
        return numero;
    }

    public String leerEmailValido(Scanner sc) {
        String correo;
        do {
            correo = sc.nextLine();
            if (!correo.contains("@")) {
                System.out.print("Correo inválido. Intente de nuevo: ");
            }
        } while (!correo.contains("@"));
        return correo;
    }

    public String leerTelefonoValido(Scanner sc) {
        String tel;
        do {
            tel = sc.nextLine();
            if (!tel.matches("\\d{8,}")) {
                System.out.print("Teléfono inválido. Solo dígitos (mínimo 8): ");
            }
        } while (!tel.matches("\\d{8,}"));
        return tel;
    }

    public void guardarLinea(String linea) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(linea);
            writer.newLine();
            System.out.println("Registro guardado en personas.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}

   

