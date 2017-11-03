/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
//Se importan todas las clases necesarias para la implementacion del programa
import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 */

/*Se crea la clase publica session que es una interfaz de comunicacion creacion de hilos
con este se pueden crear, leer o borrar las instancias creadas.
*/
public class PersonaDAO {
    Session session;
    
    /*
    Se importa la session .getLocalSession para generar un hilo cada vez que
    se requiera iniciar una sesion.
    */
    public PersonaDAO(){
        session=HibernateUtil.getLocalSession();
    }
    
    public  Persona getPersonaById(int id){
        return (Persona)session.load(Persona.class, id);
    }
    
    public List<Persona>  getPersonaByName(String nombre){
        List<Persona> listaDePersonas=(List<Persona>)
                session.createCriteria(Persona.class)
                .add(Restrictions.eq("Nombre", nombre));
        return listaDePersonas;
    }
    
    /*
    Se hace un metodo booleano para actualizar la lista mediante Id.
    dentro se coloca un int seleccionando el dato a cambiar (id),
    Persona 
    
    Se crea una variable persona (personaAModificar) que tendra la instruccion
    de obtener el Id por persona.
    */
    public boolean updateById(int id,Persona persona){
        Persona personaAModificar=getPersonaById(id);
        /*
        La instruccion try se cersioar que el servidor puede realizar una modificacion
        dentro de la base de datos.
        Se genera una variable transaction  para iniciar una "transaction".
        A la variable personaAModificar se le inserta la instruccion setNombre y dentro
        del parentesis se ubica la instruccion dentro de la clase indicada (persona).
        El metodo session con la instriccion update actualiza los cambios que se hicieron
        en personaAModificar.
        Por ultimo se genera la instruccion commit dentro de la variable transaccion para
        actualizar la base de datos.
        */
        try{
            Transaction transaccion=session.beginTransaction();
            personaAModificar.setNombre(persona.getNombre());
            session.update(personaAModificar);
            transaccion.commit();
            return true;
        /*
            En caso de tener un error toda la documentacion se colocara en una
            variable e.
            */
        }catch(Exception e){
            return false;
        }
    }
    
    /*
    Para crear un dato dentro de la base de datos se crea una booleana savePersona y
    dentro de los parametros se colocan los valores que se van a insertar.
    Se crea una variable Persona para crea un objeto tipo Persona.
    Se crea una variable tipo persona para crear el nuevo objeto.
    Se crea una variable tipoPersona y se hace una conversion para cargar el dato por Id
    dentro de la base de datos para buscarlo y el objeto Persona personaDeTanque para
    ingresar los datos a modificar dentro de los datos asignados dentro de la Id que se
    encontro (nombre, materno, paterno, telefono, IdTipoPersona)
    Con el metodo "try" se crea la variable Transaction para iniciar una
    transaccion en la sesion
    Con la instruccion "save" se guarda la session "savePersona" dentro de
    la base de datos y la variable personaDeTanque hasta que se actualize la
    base de datos dentro de commit.
    */
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        Persona personaDeTanque=new Persona();
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona);
        personaDeTanque.setNombre(nombre);
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        personaDeTanque.setTipoPersona(tipoDeTanque);
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaDeTanque);
            transaccion.commit();
            return true;
        /*En caso de tener un error toda la documentacion se colocara en una
            variable e.
            */
        }catch(Exception e){
            
        }finally{
            
        }
        return true;
    }
    
}
