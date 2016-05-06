/**
 * Este paquete contiene la parte logica de la actividad Principal para la seccion de ayuda
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la actividad.
 */
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.edu.uniquindio.android.electiva.campusuq.R;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016

 * Actividad (parte logica) para la creacion de la vista Principal de la app que se mostrara al usuario
 */
public class Principal extends AppCompatActivity implements View.OnClickListener {

    /**
     * Atributos Botones que permiten navegar a cada una de las secciones de la aplicacion
     */
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    /**
     * Atributo url que representa la direccion URL de la pagina web de la Universidad del Quindio
     */
    public final static String url = "https://www.uniquindio.edu.co";

    /**
     * Metodo que permite crear la actividad (pone la actividad en el estado creado)
     *
     * @param savedInstanceState necesario para guardar el estado de la actividad, de tal forma que se pueda recuperar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Metodo de inflado explicito para construir el layout activity_principal.xml
        setContentView(R.layout.activity_principal);

        //Se obtienen todos los botones controles de seleccion de el layout activity_principal.xml
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }


    /**
     * Metodo que permite escuchar los eventos "cuando se haga click sobre alguno de los botones de la
     * interfaz principal, y determina las tareas a realizar dependiendo del boton presionado por el usuario
     * @param v View control de seleccion que se selecciona en la interfaz principal
     */
    @Override
    public void onClick(View v) {

        if (button.getId() == v.getId()) {

            Intent intent = new Intent(this, SugerenciasActivity.class);
            startActivity(intent);

        } else {
            if (button1.getId() == v.getId()) {

                    Intent intent = new Intent(this, NoticiasActualesActivity.class);
                    startActivity(intent);

            } else {
                if (button2.getId() == v.getId()) {

                    Intent intent = new Intent(this, AyudaActivity.class);
                    startActivity(intent);

                } else {
                    if (button3.getId() == v.getId()) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } else {
                        if (button4.getId() == v.getId()) {
                            Intent intent = new Intent(this, IdiomaActivity.class);
                            this.finish();
                            startActivity(intent);
                        } else {
                            if (button5.getId() == v.getId()) {
                                Intent intent = new Intent(this, DirectorioActivity.class);
                                startActivity(intent);
                            }
                        }

                    }
                }
            }
        }

    }
}
