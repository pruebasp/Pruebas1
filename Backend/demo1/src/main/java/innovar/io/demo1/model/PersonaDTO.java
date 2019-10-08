package innovar.io.demo1.model;

public class PersonaDTO {

    private  String docIdentidad;
    private  String tipoDocIdentidad;
    private  String nombre;
    private  String apellidoPaterno;
    private  String apellidoMaterno;
    private  int edad;
    private  int sexo;
    private  String ocupacion;
    private  String fechaNac;

    public PersonaDTO(String docIdentidad, String tipoDocIdentidad, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, int sexo, String ocupacion, String fechaNac) {
        this.docIdentidad = docIdentidad;
        this.tipoDocIdentidad = tipoDocIdentidad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.fechaNac = fechaNac;
    }

    public PersonaDTO() {

    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getTipoDocIdentidad() {
        return tipoDocIdentidad;
    }

    public void setTipoDocIdentidad(String tipoDocIdentidad) {
        this.tipoDocIdentidad = tipoDocIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
}
