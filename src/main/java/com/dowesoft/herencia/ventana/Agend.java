package com.dowesoft.herencia.ventana;

/**
 * @class Agend 
 * 
 * Se utiliza como base de datos en memoria para la ejecución del programa
 */

import com.dowesoft.herencia.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Edwin Ramiro Ospian Ruiz <edwinandeka@gmail.com>
 */
public class Agend {
    
    private ArrayList<Empleado> listaEmpleados;

    public Agend() {
        
        listaEmpleados = new ArrayList<Empleado>();
        
    }

    /**
     * Agrega un objeto empleado a la lista
     * @param empleado 
     */
    public void add(Empleado empleado){
        listaEmpleados.add(empleado);
    }
    
    /**
     * Verifica si esxiste un empleado con el codigo enviado por parametros
     * @param id código de empleado
     * @return true si esiste en la lista de lo contrario false
     */
    public boolean exists(Integer id){
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getId()== id) {
                return true;
            }
        }
        return false;
    }
    
    /**
      * Verifica si esxiste un empleado con el codigo enviado por parametros <br/>
      * y lo elimina de la lista de empleados
     * @param id código de empleado
     * @return 
     */
    public void removeEmpleado(Integer id){
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getId()== id) {
                listaEmpleados.remove(i);
            }
        }
    }

    /**
     * Acceso a la lista de empleados
     * @return lista de objetos Empleado
     */
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    /**
     * Actualiza la información de un empleado de la lista
     * @param empleado 
     */
    public void edit(Empleado empleado) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);
            if (e.getId()== empleado.getId()) {
                listaEmpleados.get(i).setNombre(empleado.getNombre());
                listaEmpleados.get(i).setApellido(empleado.getApellido());
                listaEmpleados.get(i).setSalario(empleado.getSalario());
                return;
            }
        }
    }

    
}
