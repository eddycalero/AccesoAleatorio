package Interfaces;

import java.io.IOException;

public interface IGestion<T> {
    
    public void Guardar(T obj) throws IOException;
    public void Modificar(T obj) throws IOException;
    public void Eliminar(int id) throws IOException;
}
