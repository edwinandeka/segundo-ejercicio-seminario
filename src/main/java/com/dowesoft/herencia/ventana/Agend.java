package com.dowesoft.herencia.ventana;

/**
 * @class Agend 
 * 
 * Se utiliza como base de datos en memoria para la ejecución del programa
 */

import com.dowesoft.herencia.Empleado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


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
    
    
    /**
     * @return  el empleado con mayor salario.
     */
    public Empleado getMaxEmpleado() {
        
        Empleado empleado =  Collections.max(listaEmpleados, Comparator.comparing(s -> s.getSalario()));
        return empleado;
    }
    
     /**
     * @return  el empleado con menor salario.
     */
    public Empleado getMinEmpleado() {
        
        Empleado empleado =  Collections.min(listaEmpleados, Comparator.comparing(s -> s.getSalario()));
        return empleado;
    }
    
    /**
     * @return  Ordenar los empleados por nombre.
     */
    public void sortEmpleados() {
        
         Collections.sort(listaEmpleados, Comparator.comparing(s -> s.getNombre()));
        
    }
    
    
    /**
     * @return  Hallar la suma de los salarios de todos los empleados cuyo salario es mayor a 700000.
     */
    public int sumaEmpleados() {
        
        ArrayList<Empleado> empleados = (ArrayList)listaEmpleados.stream().filter(c -> c.getSalario()> 700000).collect(Collectors.toList());
        int result = listaEmpleados.stream().reduce(0, (contador, empl) -> {
            return contador + (int)empl.getSalario();
        }, Integer::sum ); 
        
        
        return result;
    }
    
    
    /**
     * @return  Determinar el número total de empleados cuyo apellido comienza por la letra ‘A’ o ‘a’.
     */
    public int countEmpleados() {
        
        int result = (int)listaEmpleados.stream().filter(e -> e.getApellido().startsWith("A")||e.getApellido().startsWith("a")).count();
        
        return result;
    }
    
      
    /**
     * @return  Los 5 primeros empleados con el mayor salario.
     */
    public ArrayList<Empleado> sortEmpleadosSalario() {
        
         Collections.sort(listaEmpleados, Comparator.comparing(s -> s.getSalario()));
         return (ArrayList)listaEmpleados.stream().limit(5).collect(Collectors.toList());
        
    }
 


    
    
}
