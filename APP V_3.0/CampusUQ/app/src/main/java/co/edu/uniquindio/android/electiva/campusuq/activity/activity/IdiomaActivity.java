/**
 * Este paquete contiene la parte logica de la actividad IdiomaActivity para la seccion de ayuda
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la actividad.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.edu.uniquindio.android.electiva.campusuq.R;
import co.edu.uniquindio.android.electiva.campusuq.activity.util.Utilidades;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016

 * Actividad (parte logica) para la creacion de la vista idiomas que se mostrara al usuario
 */
public class IdiomaActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * Botones utilizados para cambiar el idioma de la aplicacion
     */
    private Button button;
    private Button button1;

    /**
     * Metodo que permite crear la actividad (pone la actividad en el estado creado)
     *
     * @param savedInstanceState necesario para guardar el estado de la actividad, de tal forma que se pueda recuperar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Metodo de inflado explicito para construir el layout activity_idioma.xml
        setContentView(R.layout.activity_idioma);

        //Se obtienes los controles "Botones" para cambiar el idioma
        button = (Button) findViewById(R.id.espa);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.ingle);
        button1.setOnClickListener(this);
    }

    /**
     * Metodo que permite escuchar los eventos "cuando se haga click sobre alguno de los botones de la
     * interfaz, y determina las tareas a realizar dependiendo del boton presionado por el usuario
     * @param v View boton que se presiona en la interfaz principal
     */
    @Override
    public void onClick(View v) {

        if (button.getId() == v.getId()) {
            //Se cambia el idioma a español
            Utilidades.cambiarIdioma(getBaseContext());
            Intent intent = new Intent(this, Principal.class);
            this.finish();
            startActivity(intent);
        }else{
            if (button1.getId() == v.getId()) {
                //Se cambia el idioma a ingles
                Utilidades.cambiarIdiomaIn(getBaseContext());
                Intent intent = new Intent(this, Principal.class);
                this.finish();
                startActivity(intent);

            }
    }
    }
}
