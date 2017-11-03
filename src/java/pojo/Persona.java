/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */

/*
La instruccion @Entity asigna una entidad
La instruccion @Table es asignada como una entidad, se le asigna un nombre y el nombre
como "Persona" y se le asigna un nombre a la tabla "generationHibernate.

*/
@Entity
@Table(name="Persona",catalog="generationHibernate")
public class Persona {
    
    /*
    El comando Id se le asigna un codigo Primary Key a la columna creada
    GenerateValue asigna un valor autoincrementable cada vez que se cree un objeto.
    Se crean columnas con nombre correspondiente.
    Se crea un objeto privado con los nombres correspondientes.
    */
    @Id @GeneratedValue
    @Column(name="idPersona")
    private int idPersona;
    
    @Column(name="Nombre",nullable=true)
    private String Nombre;
    
    @Column(name="Paterno")
    private String Paterno;
    
     @Column(name="Materno")
    private String Materno;
     
     @Column(name="Telefono")
    private String Telefono;
    
     /*
     ManyToOne hace referencia a "Muchos a uno" que significa que en el objeto a crear
     se podran asignar muchos objetos a la clase local.
     JoinColumn asigna "ManyToOne al objeto a crear.
     
     */
     @ManyToOne
     @JoinColumn(name="idTipoPersona")
    private TipoPersona tipoPersona;

     /*
     Se crean los get's y set's correspondientes a cada objeto.
     */
     
    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
