/**
 * @class Display
 * 
 * Se encarga de realizar el procesamiento de la entrada de usuario <br/>
 * y de redirigirla  a la opcion del menu selecionada<br/>
 * asi como de mostrar la informacion en pantalla
 */


package com.dowesoft.herencia.ventana;

import com.dowesoft.herencia.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Edwin Ramiro Ospian Ruiz <edwinandeka@gmail.com>
 */
public class Display {
    
    /**
     * Opciones del menú son utilizadas par aque el switch - case 
     * del menu de opcioens sean entendible por cualquier persona
     * sin necesidad de agregarles comentarios adicionales
     */
    public static final int OPTION_AGREGAR = 1;
    public static final int OPTION_REMOVER = 2;
    public static final int OPTION_ACTUALIZAR = 3;
    public static final int OPTION_LISTAR = 4;
    public static final int OPTION_SALIR = 5;

        
    /**
     * Opciones del menú son utilizadas par aque el switch - case 
     * del menu de opcioens sean entendible por cualquier persona
     * sin necesidad de agregarles comentarios adicionales
     */
    public static final int INPUT_ID = 1;
    public static final int INPUT_NOMBRE = 2;
    public static final int INPUT_APELLIDO = 3;
    public static final int INPUT_SALARIO = 4;

    
        

    private String menu;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private Ventana ventana;
    private Agend agend;
    private Empleado empleado;

    private int selectedOption;
    private int inputOption;
    private boolean modeEdit;

    public Display(Ventana ventana) {
        
        this.ventana = ventana;
        this.agend = new Agend();
        this.selectedOption = -1;
        this.inputOption = 1;
        this.modeEdit = false;

        /**
         * opciones del menu al ser de tipo string y ser menus fijos 
         * se declaran una unica vez en el constructor y no dentro de 
         * sus metodos para evitar que cada vez que se invoque el metodo 
         * se deba hacer esta asignacion de variables 
         * 
         */
        
        menu = "***************** Agenda de Empleados **************** \n\n"
                + "Seleccione una opción \n"
                + "1) Agregar Empleado \n"
                + "2) Remover Empleado \n"
                + "3) Actualizar Empleado \n"
                + "4) Listar Empleados \n"
                + "5) <= Salir \n\n"
                + "****************************************************** \n";

        opcion1 = "***************** Agregar Empleado **************** \n\n"
                + "Ingrese el código de empleado  \n\n";

        opcion2 = "***************** Remover Empleado **************** \n\n"
                + "Ingrese el código de empleado a remover de la agenda. \n\n";

        opcion3 = "***************** Actualizar Empleado **************** \n\n"
                + "Ingrese el código de empleado a actualizar de la agenda. \n\n";

        opcion4 = "***************** Listar Empleado **************** \n\n"
                + "Lista de empleados de la agenda. \n\n";

    }

    
    
    /**
     * enrutador de opciones del menu principal<br/>
     * se encarga de redirigir la entrada del usuario a los diferentes opciones <br/>
     * dependiendo la la selecion del menú principal<br/>
     * @param option
     * @return 
     */
    public String processOptionMenu(String option) {

        ArrayList<Empleado> listaEmpleados;
        
        //enrrutador de proceso
        if (selectedOption != -1) {
            switch (selectedOption) {
                case OPTION_AGREGAR:
                    return this.processAdd(option);
                case OPTION_REMOVER:
                    return this.processRemove(option);
                case OPTION_ACTUALIZAR:
                    return this.processAdd(option);
                case OPTION_LISTAR:
                    return this.processAdd(option);
                case OPTION_SALIR:
                    return this.processAdd(option);
            }
        }
        
        if(Util.validateNumeric(option)!=null){
            
            int optionUser = Util.validateNumeric(option);
            //enrutador de menu
            switch (optionUser) {
                case OPTION_AGREGAR:
                    selectedOption = 1;
                    ventana.showText(this.getOpcion1());
                    break;
                case OPTION_REMOVER:
                    selectedOption = 2;
                    ventana.showText(this.getOpcion2());
                    ventana.addText("Id) Nombre Apellido");
                    ventana.addText("____________________");

                    listaEmpleados = agend.getListaEmpleados();
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        Empleado empleado = listaEmpleados.get(i);
                        ventana.addText(empleado.getId() + ") " + empleado.getNombre() + " " + empleado.getApellido() + " ");
                    }
                    break;
                case OPTION_ACTUALIZAR:
                    selectedOption = 3;
                    ventana.showText(this.getOpcion3());
                    break;
                case OPTION_LISTAR:
                    selectedOption = 4;
                    ventana.showText(this.getOpcion4());
                    ventana.addText("Id) Nombre | Apellido | Salario");
                    ventana.addText("_______________________________");

                    listaEmpleados = agend.getListaEmpleados();
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        Empleado empleado = listaEmpleados.get(i);
                        ventana.addText(empleado.getId() + ") " + empleado.getNombre() + " " + empleado.getApellido() + " ");
                    }
                    break;
                case OPTION_SALIR:

                    System.exit(0);
                    break;

            }
        
        } else {
            selectedOption = -1;
            ventana.addText("Opción no disonible");
        }

        ventana.clear("");
        ventana.focus();

        return "";
    }
    
    
    
    /**
     * Proceso encargado de agregar o actualizar la informacio nde un empleado <br/>
     * dependiendo de un Flag "modeEdit" si el valor es true actualiza la información <br/>
     * si el false agrega un nuevo empleado.
     * @param text entrada ingresada por el usuario
     * @return 
     */
    public String processAdd(String text) {

        switch (inputOption) {

            case INPUT_ID:

                if (Util.validateNumeric(text) != null) {

                    Integer id = Util.validateNumeric(text);
                    if (!agend.exists(id)) {
                        empleado = new Empleado();
                        empleado.setId(id);
                        ventana.addText("Id: " + text);
                        ventana.addText("Ingrese el Nombre del empleado.");
                        inputOption = 2;
                        ventana.clear("");
                    } else {

                        if (this.modeEdit) {
                            empleado = new Empleado();
                            empleado.setId(id);
                            ventana.addText("Id: " + text);
                            ventana.addText("Ingrese el Nombre del empleado.");
                            inputOption = 2;
                        } else {
                            ventana.addText("Ya existe un empleado con este id.");
                        }
                    }
                } else {
                    ventana.addText("Ingrese un id de empleado válido (numerico).");
                }

                break;
            case INPUT_NOMBRE: 

                if (Util.validateAlpha(text)) {
                    empleado.setNombre(text);
                    ventana.addText("Nombre: " + text);
                    ventana.addText("Ingrese el apellido del empleado.");
                    inputOption = 3;
                    ventana.clear("");
                } else {
                    ventana.addText("Ingrese un nombre de empleado válido.");
                }

                break;
            case INPUT_APELLIDO:  
                if (Util.validateAlpha(text)) {
                    empleado.setApellido(text);
                    ventana.addText("Apellido: " + text);
                    ventana.addText("Ingrese el salario del empleado.");
                    inputOption = 4;
                    ventana.clear("");
                } else {
                    ventana.addText("Ingrese un apellido de empleado válido.");
                }
                break;
            case INPUT_SALARIO:
                if (Util.validateNumeric(text) != null) {
                    empleado.setSalario(Util.validateNumeric(text));
                    if (modeEdit) {
                        agend.edit(empleado);
                    } else {
                        agend.add(empleado);
                    }
                    this.reset();
                } else {
                    ventana.addText("Ingrese un salario válido.");
                }
                break;
        }

        return "";
    }
    
    /**
     * se encarga de remover un empleado de la agenda<br/>
     * @param text entrada ingresada por el usuario
     * @return 
     */
    private String processRemove(String text) {

        if (Util.validateNumeric(text) != null) {

            Integer id = Util.validateNumeric(text);
            if (agend.exists(id)) {
                agend.removeEmpleado(id);
                this.reset();
            } else {
                ventana.addText("No existe un empleado con este id.");
            }
        } else {
            ventana.addText("Ingrese un id de empleado válido (numerico).");
        }

        return "";
    }
    
    /**
     * reinicia las variables para salir nuevamente al<br/>
     * menú principal
     */
    public void reset() {
        empleado = null;
        ventana.showText(this.getMenu());
        selectedOption = -1;
        inputOption = 1;
        modeEdit = false;
        ventana.clear("");
    }

    public String getMenu() {
        return menu;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

}
