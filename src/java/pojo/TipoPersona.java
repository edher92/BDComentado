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
import javax.persistence.Table;

/**
 *  #Pray4Tanque joto
 * @author RigoBono
 */

/*
La instruccion @Entity asigna una entidad
La instruccion @Table es asignada como una entidad, se le asigna un nombre y el nombre
como "Persona" y se le asigna un nombre a la tabla "generationHibernate.

*/

@Entity
@Table(name="TipoPersona", catalog="generationHibernate")
public class TipoPersona {

        /*
    El comando Id se le asigna un codigo Primary Key a la columna creada
    GenerateValue asigna un valor autoincrementable cada vez que se cree un objeto.
    Se crean columnas con nombre correspondiente.
    Se crea un objeto privado con los nombres correspondientes.
    */
    @Id @GeneratedValue
    @Column(name="idTipoPersona")
    private int idTipoPersona;
    
     @Column(name="TipoPersonacol")
    private String TipoPersona;
     
     /*
     Por buenas practicas se crea un constructor de TipoPersona
     */
     public TipoPersona(){
         
     }
     
     /*
     Se crean los get's y set's correspondientes a cada objeto.
     */

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
