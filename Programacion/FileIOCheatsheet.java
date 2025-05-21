package Programacion;

/*
 * FileIOCheatsheet.java
 * Hoja de referencia: Operaciones de E/S de ficheros Java IO y NIO.2
 * Incluye clases, interfaces y métodos para lectura y escritura de archivos.
 */

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class FileIOCheatsheet {

    // ===== Flujos de Salida de Bytes =====

    /**
     * java.io.OutputStream: Clase abstracta para escribir flujos de bytes.
     * Métodos:
     *   void write(int b) throws IOException
     *   void write(byte[] b, int off, int len) throws IOException
     *   void flush() throws IOException
     *   void close() throws IOException
     */

    /**
     * FileOutputStream: Escribe bytes en un archivo.
     * Constructores:
     *   FileOutputStream(String nombre)
     *   FileOutputStream(File archivo)
     *   FileOutputStream(String nombre, boolean append)
     */
    public static void ejemploFileOutputStream() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("salida.bin")) {
            fos.write(new byte[]{0x01, 0x02, 0x03});
        }
    }

    /**
     * BufferedOutputStream: Almacena en búfer y escribe en un OutputStream.
     * Constructor: BufferedOutputStream(OutputStream out)
     */
    public static void ejemploBufferedOutputStream() throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("salida_buffer.bin"))) {
            bos.write("Ejemplo de escritura en búfer".getBytes());
        }
    }

    /**
     * ByteArrayOutputStream: Almacena bytes en memoria (Array byte).
     * Metodo: byte[] toByteArray()
     */
    public static void ejemploByteArrayOutputStream() throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write("Bytes en memoria".getBytes());
            byte[] datos = baos.toByteArray();
        }
    }

    /**
     * DataOutputStream: Escribe tipos primitivos Java en un OutputStream.
     * Métodos:
     *   void writeInt(int v)
     *   void writeUTF(String s)
     */
    public static void ejemploDataOutputStream() throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("datos.bin"))) {
            dos.writeInt(123);
            dos.writeUTF("Prueba");
        }
    }

    // ===== Flujos de Salida de Caracteres =====

    /**
     * java.io.Writer: Clase abstracta para escribir flujos de caracteres.
     * Métodos:
     *   void write(int c) throws IOException
     *   void write(char[] cbuf, int off, int len) throws IOException
     *   void flush() throws IOException
     *   void close() throws IOException
     */

    /**
     * FileWriter: Escribe caracteres en un archivo.
     * Constructor: FileWriter(String nombreArchivo)
     */
    public static void ejemploFileWriter() throws IOException {
        try (FileWriter fw = new FileWriter("salida.txt")) {
            fw.write("Hola FileWriter\n");
        }
    }

    /**
     * BufferedWriter: Almacena en búfer y escribe texto de forma eficiente.
     * Constructor: BufferedWriter(Writer out)
     * Métodos: newLine()
     */
    public static void ejemploBufferedWriter() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("salida_buffer.txt"))) {
            bw.write("Línea 1");
            bw.newLine();
            bw.write("Línea 2");
        }
    }

    /**
     * StringWriter: Escribe caracteres en un búfer de String.
     * Método: toString()
     */
    public static void ejemploStringWriter() {
        StringWriter sw = new StringWriter();
        sw.write("Contenido de StringWriter");
        String resultado = sw.toString();
    }

    /**
     * OutputStreamWriter: Puente de flujos de bytes a flujos de caracteres.
     * Constructor: OutputStreamWriter(OutputStream out, Charset cs)
     */
    public static void ejemploOutputStreamWriter() throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("codificado.txt"), StandardCharsets.UTF_8)) {
            osw.write("Texto con codificación UTF-8");
        }
    }

    /**
     * PrintWriter: Imprime representaciones formateadas en un flujo de texto.
     * Constructor: PrintWriter(Writer out)
     * Métodos: println, printf
     */
    public static void ejemploPrintWriter() throws IOException {
        try (PrintWriter pw = new PrintWriter("impresion.txt")) {
            pw.println("Ejemplo PrintWriter");
            pw.printf("Número: %d%n", 42);
        }
    }

    // ===== Flujos de Entrada de Bytes =====

    /**
     * java.io.InputStream: Clase abstracta para leer flujos de bytes.
     * Métodos:
     *   int read() throws IOException
     *   int read(byte[] b, int off, int len) throws IOException
     *   void close() throws IOException
     */

    /**
     * FileInputStream: Lee bytes de un archivo.
     */
    public static void ejemploFileInputStream() throws IOException {
        try (FileInputStream fis = new FileInputStream("entrada.bin")) {
            int b;
            while ((b = fis.read()) != -1) {
                // procesar byte b
            }
        }
    }

    /**
     * BufferedInputStream: Almacena en búfer y lee de un InputStream.
     */
    public static void ejemploBufferedInputStream() throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("entrada.bin"))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                // procesar buffer[0..len]
            }
        }
    }

    /**
     * ByteArrayInputStream: Lee bytes de un array en memoria.
     */
    public static void ejemploByteArrayInputStream() {
        byte[] datos = {0x01, 0x02};
        try (ByteArrayInputStream bais = new ByteArrayInputStream(datos)) {
            int b;
            while ((b = bais.read()) != -1) {
                // procesar byte
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ===== Flujos de Entrada de Caracteres =====

    /**
     * java.io.Reader: Clase abstracta para leer flujos de caracteres.
     * Métodos:
     *   int read() throws IOException
     *   int read(char[] cbuf, int off, int len) throws IOException
     *   void close() throws IOException
     */

    /**
     * FileReader: Lee caracteres de un archivo.
     */
    public static void ejemploFileReader() throws IOException {
        try (FileReader fr = new FileReader("entrada.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                // procesar char c
            }
        }
    }

    /**
     * BufferedReader: Lee texto de forma eficiente, línea por línea.
     * Método: String readLine()
     */
    public static void ejemploBufferedReader() throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader("entrada.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // procesar línea
            }
        }
    }

    /**
     * StringReader: Lee caracteres de un String.
     */
    public static void ejemploStringReader() throws IOException {
        try (StringReader sr = new StringReader("Ejemplo")) {
            int c;
            while ((c = sr.read()) != -1) {
                // procesar char
            }
        }
    }

    /**
     * InputStreamReader: Puente de flujos de bytes a flujos de caracteres.
     */
    public static void ejemploInputStreamReader() throws IOException {
        try (InputStreamReader isr = new InputStreamReader(
                new FileInputStream("codificado.txt"), StandardCharsets.UTF_8)) {
            int c;
            while ((c = isr.read()) != -1) {
                // procesar char
            }
        }
    }

    // ===== Clase java.io.File =====

    /**
     * java.io.File: Representa archivos y directorios.
     * Constructores: File(String ruta), File(String parent, String child)
     * Métodos: createNewFile(), exists(), delete(), mkdir(), listFiles()
     */
    public static void ejemploUsoFile() throws IOException {
        File f = new File(".", "nuevo.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        File[] ficheros = f.getParentFile().listFiles();
    }

    // ===== NIO.2: FileSystem, Path y Files =====

    /**
     * FileSystem: Representa un sistema de archivos.
     * Obtención: FileSystems.getDefault()
     */
    public static void ejemploFileSystem() {
        FileSystem fs = FileSystems.getDefault();
        String separador = fs.getSeparator();
    }

    /**
     * java.nio.file.Path: Representa rutas de archivos/directorios.
     * Obtención: Paths.get(...)
     */
    public static void ejemploUsoPath() {
        Path ruta = Paths.get("c:", "src", "java", "nio", "files");
        Path padre = ruta.getParent();
        Path nombre = ruta.getFileName();
        boolean absoluto = ruta.isAbsolute();
        for (Path elemento : ruta) {
            // elemento.getFileName()
        }
    }

    /**
     * java.nio.file.Files: Utilidades para operaciones de archivos.
     * Métodos clave:
     *   exists, isReadable, isWritable, isExecutable, isSameFile
     *   createFile, createTempFile, createDirectory, createTempDirectory
     *   delete, deleteIfExists, copy, move
     *   newBufferedReader, newBufferedWriter, readAllLines, lines
     *   list, walk, find
     */
    public static void ejemploUsoFiles() throws IOException {
        Path archivo = Paths.get("ejemplo.txt");
        if (!Files.exists(archivo)) {
            Files.createFile(archivo);
        }
        List<String> lineas = Arrays.asList("Línea1","Línea2");
        Files.write(archivo, lineas, StandardCharsets.UTF_8);
        List<String> leido = Files.readAllLines(archivo, StandardCharsets.UTF_8);
        try (Stream<String> flujo = Files.lines(archivo, StandardCharsets.UTF_8)) {
            flujo.filter(s -> s.contains("Línea"))
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        }
        try (Stream<Path> listado = Files.list(Paths.get("."))) {
            listado.forEach(System.out::println);
        }
        try (Stream<Path> recorrido = Files.walk(Paths.get("."), 2)) {
            recorrido.forEach(System.out::println);
        }
        try (Stream<Path> encontrado = Files.find(Paths.get("."), 2,
                (p, attr) -> p.toString().endsWith(".java"))) {
            encontrado.forEach(System.out::println);
        }
    }
}

