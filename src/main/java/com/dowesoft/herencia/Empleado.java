package com.dowesoft.herencia;


/**
 *
 * @author Edwin Ramiro Ospian Ruiz <edwinandeka@gmail.com>
 */
public class Empleado extends Persona{
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return this.getId()+ ") " + this.getNombre()+ " " + this.getApellido()+ " $"+ this.getSalario()+ " "; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
