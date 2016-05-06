/**
 * Este paquete contiene la parte logica de la actividad DetalleDeNoticiaActivity
 * que contiene el fragmento con el detalle de las noticias a ser mostradas
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la actividad.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.campusuq.R;

import co.edu.uniquindio.android.electiva.campusuq.activity.fragments.DetalleDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016
 * Actividad (parte logica) para la creacion de la vista con el fragmento detalle de noticia que
 * se mostrara al usuario
 */
public class DetalleDeNoticiaActivity extends AppCompatActivity {

    /**
     * Metodo que permite crear la actividad (pone la actividad en el estado creado) que contiene el fragmento con el detalle
     * noticia
     *
     * @param savedInstanceState necesario para guardar el estado de la actividad, de tal forma que se pueda recuperar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Metodo de inflado explicito para construir el layout activity_detalle_de_noticia.xml que contiene el fragment.
        setContentView(R.layout.activity_detalle_de_noticia);

        //Se inicializa el fragmento detalleDeNoticia apartir de la configuracion del layout fragmento_detalle_de_noticia
        DetalleDeNoticiaFragment detalleDeNoticia = (DetalleDeNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);

        //Se crea un nuevo objeto noticia
        Noticia film = (Noticia) getIntent().getExtras().getParcelable("pelicula");

        //Se llama al metodo mostrar noticia del fragmento detalleDeNoticia para que esta sea mostrada al usuario
        detalleDeNoticia.showDetail(film);

    }
}
