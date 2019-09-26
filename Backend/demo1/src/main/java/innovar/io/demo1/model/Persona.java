package innovar.io.demo1.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    private  String id;
    private  String docIdentidad;
    private  String tipoDocIdentidad;
    private  String nombre;
    private  String apellidoPaterno;
    private  String apellidoMaterno;
    private  int edad;
    private  int sexo;
    private  String ocupacion;
    private  String fechaNac;

    public  Persona(){

    }
     public Persona( String docIdentidad,String tipoDocIdentidad, String nombre, String apellidoMaterno, String apellidoPaterno, int edad, int sexo, String ocupacion,String fechaNac){
         this.apellidoMaterno = apellidoMaterno;
         this.apellidoPaterno = apellidoMaterno;
         this.docIdentidad = docIdentidad;
         this.edad = edad;
         this.fechaNac = fechaNac;

         this.tipoDocIdentidad = tipoDocIdentidad;
         this.nombre = nombre;
         this.sexo = sexo;
         this.ocupacion = ocupacion;
     }

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id){
         this.id = id;
    }

    @Column(name = "doc_identidad", nullable = true)
    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    @Column(name = "tipo_doc_identidad", nullable = true)
    public String getTipoDocIdentidad() {
        return tipoDocIdentidad;
    }

    public void setTipoDocIdentidad(String tipoDocIdentidad) {
        this.tipoDocIdentidad = tipoDocIdentidad;
    }

    @Column(name = "nombre", nullable = true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido_paterno", nullable = true)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Column(name = "apellido_materno", nullable = true)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Column(name = "edad", nullable = true)
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Column(name = "sexo", nullable = true)
    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    @Column(name = "ocupacion", nullable = true)
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Column(name = "fecha_nac", nullable = true)
    public String getFechaNac() {
        return fechaNac;
    }


    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
