/**
 * Este paquete contiene la clase Utilidades
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.util;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la clase.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016
 *
 * Clase que implementa utilidades para la aplicacion
 */
public class Utilidades {

    /**
     * Atributos cadenas utilizadas para gestinar el idioma de la aplicacion
     */
    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String LENGUAJE_EN = "en";


    /**
     * metodo que nos permite cambiar el idioma a español
     * @param context, el contexto donde se va a cambiar el idioma
     */
    public static void cambiarIdioma(Context context){
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS,
                        context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA,
                LENGUAJE_ES);
        if(language.equals(LENGUAJE_ES)){
            language = LENGUAJE_ES;
        }
        else if(language.equals(LENGUAJE_EN)){
            language = LENGUAJE_ES;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();
        obtenerLenguaje(context);
    }

    /**
     * metodo que nos permite cambiar el idioma a ingles
     * @param context, el contexto donde se va a cambiar el idioma
     */
    public static void cambiarIdiomaIn(Context context){
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS,
                        context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA,
                LENGUAJE_ES);
        if(language.equals(LENGUAJE_ES)){
            language = LENGUAJE_EN;
        }
        else if(language.equals(LENGUAJE_EN)){
            language = LENGUAJE_EN;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();
        obtenerLenguaje(context);
    }

    /**
     * Metodo que nos permite obtener el lenguaje de la aplicacion
     * @param context, el contexto donde se va a cambiar el idioma
     */
    public static void obtenerLenguaje(Context context){
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS,context.MODE_PRIVATE)
                ;
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA,
                LENGUAJE_ES);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        context.getApplicationContext().getResources().updateConfiguration(
                config, null);
    }


}
