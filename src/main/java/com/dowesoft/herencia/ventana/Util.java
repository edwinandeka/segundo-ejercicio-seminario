package com.dowesoft.herencia.ventana;

/**
 *
 * @author Edwin Ramiro Ospian Ruiz <edwinandeka@gmail.com>
 */
public class Util {
    
    
    /**
     * Realiza la conversion de texto a numerico
     * @param text texto a convertir
     * @return int valor parseado o null en caso de que no se pueda convertir
     */
    public static Integer validateNumeric(String text) {
        try {
          return Integer.parseInt(text);
        } catch (NumberFormatException e) {
          return null;
        }
    }
    
    /**
     * valida que un texto sea alfabetico 
     * @param text texto a validar
     * @return true si es alfabetico false si no lo es
     */
    public static boolean validateAlpha(String text) {
        return text.matches("[a-zA-Z ]*");
    }
    
}
