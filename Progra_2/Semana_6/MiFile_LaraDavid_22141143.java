package Semana_6;

import java.io.*;
import java.util.Date;
import java.util.Objects;

public class MiFile_LaraDavid_22141143 {

    // Atributos
    private File files; // Objeto File

    public void setFile(String path) {
        files = new File(path);
    } // Fin setFile

    public void vistaInfo() { // Metodo para ver la información del archivo
        if (files.exists()) { // Si existe el archivo
            System.out.println("\n Si existe: \n****"); // Se muestra que existe
            System.out.println("Nombre: " + files.getName()); // Se muestra el nombre
            System.out.println("Ruta: " + files.getPath()); // Se muestra la ruta
            System.out.println("Absoluta: " + files.getAbsolutePath()); // Se muestra la ruta absoluta
            System.out.println("Padre: " + files.getAbsoluteFile().getParentFile().getName()); // Se muestra el padre
            System.out.println("Bytes: " + files.length()); // Se muestra el tamaño del archivo
            if (files.isFile()) { // Si es un archivo
                System.out.println("Es un archivo"); // Se muestra que es un archivo
            } else if (files.isDirectory()) { // Si es un directorio
                System.out.println("Es un folder"); // Se muestra que es un folder
            }
            System.out.println("Ultima modificación: " + new Date(files.lastModified())); // Se muestra la ultima modificación
        } else { // Si no existe el archivo
            System.out.println("No existe"); // Se muestra que no existe
        }
    }

    public void createFile() throws IOException { // Metodo para crear un archivo
        if (files.createNewFile()) { // Si se creo el archivo
            System.out.println("Se creo el archivo");
        } else { // Si no se creo el archivo
            System.out.println("No se pudo crear el archivo");
        }
    }

    public void createDirectory() { // Metodo para crear un directorio
        if (files.mkdir()) { // Si se creo el directorio
            System.out.println("Se creo el directorio");
        } else { // Si no se creo el directorio
            System.out.println("No se pudo crear el directorio");
        }
    }

    public void dirCMD() { // Metodo para ver el directorio actual
        if (files.isDirectory()) { // Si es un directorio
            System.out.println("Directorio de : " + files.getAbsolutePath()); // Se muestra el directorio actual
            int cFile = 0, cDirs = 0, tBytes = 0; // Se crean las variables para contar los archivos, directorios y bytes

            for (File item : Objects.requireNonNull(files.listFiles())) { // Se recorre el directorio
                if (!item.isHidden()) { // Si no es un archivo oculto
                    Date ultime = new Date(item.lastModified()); // Se crea la variable para la última modificación
                    System.out.println(ultime + "\t"); // Se muestra la última modificación
                    if (item.isDirectory()) { // Si es un directorio
                        cDirs++; // Se aumenta el contador de directorios
                        System.out.println("<DIR>\t\t" + item.getName() + "\t" + ultime); // Se muestra el directorio
                    } else if (item.isFile()) { // Si es un archivo
                        cFile++;
                        System.out.print("     \t" +
                                item.length() + "\t"); // Se muestra el tamaño del archivo
                    }
                    System.out.println(item.getName()); // Se muestra el nombre del archivo
                }
            }
            System.out.println(cFile + " archivos\t" + tBytes); // Se muestra el total de archivos y bytes
            System.out.println(cDirs + " directorios\t" + files.getFreeSpace() +
                    "free bytes"); // Se muestra el total de directorios y bytes libres
        }
    }

    public void tree() { // Metodo para ver el árbol de directorios
        tree(files, "-"); // Se llama al metodo para ver el árbol de directorios

    }

    private void tree(File dir, String tab) { // Metodo para ver el árbol de directorios
        if (dir.isDirectory()) { // Si es un directorio
            System.out.println(tab + dir.getName()); // Se muestra el nombre del directorio
            for (File item : Objects.requireNonNull(dir.listFiles())) { // Se recorre el directorio
                if (!item.isHidden()) { // Si no es un archivo oculto
                    tree(item, tab + "--"); // Se llama al metodo para ver el árbol de directorios
                }
            }
        }
    }

    // Metodo para escribir con FileWriter
    public void escribir(boolean append) throws IOException { // append = true
        FileWriter fw = new FileWriter(files, append); // true para agregar al final
        do { // Ciclo para escribir
            String txt = testFile_LaraDavid_22141143.leer.nextLine(); // lee una linea
            if (!txt.equals(":P")) { // si no es :P
                fw.write(txt + "\n"); // escribe la linea
                fw.flush(); // Se guarda en el archivo
            } else { // si es :P
                fw.close(); // Se cierra el archivo
                break; // Se termina el ciclo
            }
        } while (true); // Se repite hasta que se cierre el archivo
    }

    // Metodo para escribir con BufferedWriter
    public void escribirBuffer() throws IOException { // Escribir con buffer
        BufferedWriter bw = new BufferedWriter(new FileWriter(files)); // Se crea el buffer
        do { // Ciclo para escribir
            String txt = testFile_LaraDavid_22141143.leer.nextLine(); // Se escribe el texto
            if (!txt.equals(":P")) { // Si no es :P
                bw.write(txt + "\n"); // Se escribe en el buffer
                bw.flush(); // Se guarda el texto
            } else { // Si es :P
                bw.close(); // Se cierra el buffer
                break; // Se termina el ciclo
            }
        } while (true); // Se repite hasta que se cierre el buffer
    }

    // Metodo para leer con FileReader
    public void leer() throws IOException { // Leer con FileReader
        FileReader fr = new FileReader(files); // Se crea el FileReader
        int c; // Variable para leer el archivo
        while ((c = fr.read()) != -1) { // Se lee letra por letra hasta que se termine el archivo
            System.out.print((char) c); // Se imprime el carácter
        } // Se termina el ciclo
        fr.close(); // Se cierra el archivo
    }

    // Metodo para leer con BufferedReader
    public void leerBuffer() throws IOException { // leer con buffer
        BufferedReader br = new BufferedReader(new FileReader(files)); // Se crea el buffer
        String linea; // Se almacena la línea leida
        while ((linea = br.readLine()) != null) { // Si no es null
            System.out.println(linea); // Imprimir con buffer
        } // Se termina el ciclo
        br.close(); // Se cierra el buffer
    }

}
