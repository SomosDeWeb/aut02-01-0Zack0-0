public class Estudiante {
    private String nombre;
    private int edad;
    private String  curso;
    private double nota;


public Estudiante(String nombre, int edad, String curso, double nota) {
    this.nombre = nombre;
    this.edad = edad;
    this.curso = curso;
    this.nota = nota;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public double getNota() {
    return nota;
}
@Override
public String toString() {
    return "Estuidante{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", curso='" + curso + '\'' +
            ", nota=" + nota +
            '}';
}
}