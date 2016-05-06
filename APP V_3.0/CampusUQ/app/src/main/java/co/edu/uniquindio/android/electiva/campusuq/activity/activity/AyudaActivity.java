/**
 * Este paquete contiene la parte logica de la actividad AyudaActivity para la seccion de ayuda
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la actividad.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import co.edu.uniquindio.android.electiva.campusuq.R;


/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016

 * Actividad (parte logica) para la creacion de la vista ayuda que se mostrara al usuario
 */
public class AyudaActivity extends AppCompatActivity {

    /**
     * Metodo que permite crear la actividad (pone la actividad en el estado creado)
     *
     * @param savedInstanceState necesario para guardar el estado de la actividad, de tal forma que se pueda recuperar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Metodo de inflado explicito para construir el layout activity_ayuda.xml
        setContentView(R.layout.activity_ayuda);
    }
}
