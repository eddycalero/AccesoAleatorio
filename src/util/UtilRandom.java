package Util;

import java.io.File;
import java.io.RandomAccessFile;

public class UtilRandom {

    public static RandomAccessFile GetDataAccess() {

        RandomAccessFile raf = null;

        File archivo = new File("datos_estudiantes.txt");

        try {
            if (archivo.exists()) {
                raf = new RandomAccessFile(archivo, "rw"); //rw = lectura y escritura
            } else {
                raf = new RandomAccessFile(archivo, "rw");
                raf.seek(0);
                raf.writeInt(0);
                raf.seek(4);
                raf.writeInt(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return raf;

    }
}
