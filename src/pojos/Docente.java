package Pojos;

public class Docente {

    private int IdDocente;
    private String Nombre;
    private boolean Activo;

    public int getIdDocente() {
        return IdDocente;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        this.Activo = activo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setIdDocente(int idDocente) {
        this.IdDocente = idDocente;
    }
}
