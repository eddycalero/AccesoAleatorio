package Pojos;

public class Estudiante {

    private int IdEstudiante;
    private String Nombre;
    private int edad;
    private boolean Activo;

    public int getIdEstudiante() {
        return IdEstudiante;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        this.Activo = activo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.IdEstudiante = idEstudiante;
    }
}
