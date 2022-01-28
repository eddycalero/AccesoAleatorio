package Interfaces;

import java.io.IOException;
import java.util.List;

public interface IBusquedas<T> {

    public List<T> EncontrarTodo() throws IOException;
    public T EncontrarPorId(int id) throws IOException;
    public int ObtenerUltimoId() throws IOException;

}

