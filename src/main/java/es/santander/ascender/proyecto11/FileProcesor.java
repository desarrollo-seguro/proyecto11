package es.santander.ascender.proyecto11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileProcesor implements IFileProcesor {

    // Método para leer el archivo
    @Override
    public String leerFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim();
    }


    // Método para eliminar las vocales de un texto
    @Override
    public String eliminarVocales(String input) {
        return input.replaceAll("[AEIOUaeiouÁÉÍÓÚáéíóúÜü]", "");
    }

    // Método para escribir el contenido a un archivo
    @Override
    public void escribirAFile(String filePath, String content) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(content.getBytes());
        }
    }
}