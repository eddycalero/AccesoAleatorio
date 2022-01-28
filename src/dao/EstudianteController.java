package dao;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import Interfaces.IDataController;
import Pojos.Estudiante;
import Util.UtilRandom;

public class EstudianteController implements IDataController<Estudiante> {

    private RandomAccessFile raf;
    private final int Max = 100;

    public EstudianteController() {
        raf = UtilRandom.GetDataAccess();
    }

    @Override
    public void Guardar(Estudiante obj) throws IOException {
        obj.setIdEstudiante(ObtenerUltimoId());

        raf.seek(0);
        int n = raf.readInt();
        int k = raf.readInt();

        int pos = 8 + k * Max; // determina la posicion en la cual vamos a guardar el registro
        raf.seek(pos);

        raf.writeInt(obj.getIdEstudiante()); // si necesitamos guardar entero, usamos writeInt
        raf.writeUTF(obj.getNombre()); // para cadenas usamos writeUTF
        raf.writeInt(obj.getEdad());
        raf.writeBoolean(true);// para booleans usamos writeboolean

        raf.seek(0);
        raf.writeInt(++n);
        raf.writeInt(++k);
    }

    @Override
    public void Modificar(Estudiante obj) throws IOException {

        Estudiante original = EncontrarPorId(obj.getIdEstudiante());

        raf.seek(0);

        int pos = 8 + (obj.getIdEstudiante() - 1) * Max;
        raf.seek(pos);

        //NOTA IMPORTANTE: Los identificadores nunca deben ser editables, por eso lo dejamos como comentario
        raf.writeInt(obj.getIdEstudiante());
        raf.writeUTF(obj.getNombre());
        raf.writeInt(obj.getEdad());
        raf.writeBoolean(original.isActivo());// el estado no es necesario editarlo

        raf.seek(0);
    }

    @Override
    public void Eliminar(int id) throws IOException {
        Estudiante original = EncontrarPorId(id);

        raf.seek(0);

        int pos = 8 + (original.getIdEstudiante() - 1) * Max;
        raf.seek(pos);

        raf.writeInt(original.getIdEstudiante());
        raf.writeUTF(original.getNombre());
        raf.writeInt(original.getEdad());
        raf.writeBoolean(false);

        raf.seek(0);
    }

    @Override
    public List<Estudiante> EncontrarTodo() throws IOException {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();

        raf.seek(0);
        int n = raf.readInt();

        for (int i = 1; i <= n; i++) {
            Estudiante est = EncontrarPorId(i);
            if (est != null) {
                if (est.isActivo()) { //validamos que solo se muestren los registros activos (true)
                    estudiantes.add(est);
                }
            }

        }

        return estudiantes;
    }

    @Override
    public Estudiante EncontrarPorId(int id) throws IOException {
        raf.seek(0);
        int k = raf.readInt();

        if (id < 0 || id > k) {
            return null;
        }

        int pos = 8 + (id - 1) * Max;
        raf.seek(pos);

        Estudiante e = new Estudiante();
        e.setIdEstudiante(raf.readInt());
        e.setNombre(raf.readUTF());
        e.setEdad(raf.readInt());
        e.setActivo(raf.readBoolean());

        return e;
    }

    @Override
    public int ObtenerUltimoId() throws IOException {
        raf.seek(4);
        return raf.readInt() + 1;
    }

}
