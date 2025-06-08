package MySql_Dos.domain;

public class Sociedad {

    private Integer sociedad;
    private String nombre;
    private String pais;

    public Sociedad(Integer sociedad, String nombre, String pais) {
        this.sociedad = sociedad;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Integer getSociedad() {
        return sociedad;
    }

    public void setSociedad(Integer sociedad) {
        this.sociedad = sociedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Sociedad{" +
                "sociedad=" + sociedad +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
