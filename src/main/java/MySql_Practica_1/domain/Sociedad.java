package MySql_Practica_1.domain;

public class Sociedad {

    private Integer idSociedad;
    private String nombre;
    private String pais;

    public Sociedad() {
    }

    public Integer getIdSociedad() {
        return idSociedad;
    }

    public void setIdSociedad(Integer idSociedad) {
        this.idSociedad = idSociedad;
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
                "idSociedad=" + idSociedad +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
