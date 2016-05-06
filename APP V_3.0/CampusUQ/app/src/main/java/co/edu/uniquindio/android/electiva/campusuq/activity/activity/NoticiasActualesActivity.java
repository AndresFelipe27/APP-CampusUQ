/**
 * Este paquete contiene la parte logica de la actividad NoticiasActualesActivity
 * que contiene el fragmento con la lista de noticias a ser mostradas*
 * */
package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la actividad.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;



import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.campusuq.activity.fragments.DetalleDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.campusuq.activity.fragments.ListaDeNoticiasFragment;
import co.edu.uniquindio.android.electiva.campusuq.activity.util.Utilidades;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.campusuq.R;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016

 * Actividad (parte logica) para la creacion de la vista con el fragmento listaDeNoticiasFragment que
 * se mostrara al usuario
 */
public class NoticiasActualesActivity extends AppCompatActivity implements ListaDeNoticiasFragment.OnPeliculaSeleccionadaListener{

    private ListaDeNoticiasFragment listaDeNoticiasFragment;

    /**
     * Atributo noticias que representa una lista de objetos Noticia
     */
    private ArrayList<Noticia> noticias;

    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(this);
        setContentView(R.layout.activity_noticias_actuales);
        setTitle(R.string.app_name);

        noticias = new ArrayList();
        noticias.add(new Noticia("Interestelar", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        noticias.add(new Noticia("El Padrino", "2015", "https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        noticias.add(new Noticia("Regreso al futuro", "2015", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        noticias.add(new Noticia("Titanic", "2014", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        noticias.add(new Noticia("StarWars", "2014", "https://www.youtube.com/watch?v=yyDUC1LUXSU"));

        noticias.add(new Noticia("El bueno, el malo y el feo", "2014", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        noticias.add(new Noticia("La Pantera Rosa", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        noticias.add(new Noticia("Interestelar", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        noticias.add(new Noticia("El Padrino", "2015", "https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        noticias .add(new Noticia("Regreso al futuro", "2015", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        noticias.add(new Noticia("Titanic", "2014", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        noticias.add(new Noticia("StarWars", "2014", "https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        noticias.add(new Noticia("El bueno, el malo y el feo", "2014", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        noticias.add(new Noticia("La Pantera Rosa", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));

        listaDeNoticiasFragment= (ListaDeNoticiasFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_noticias);
        listaDeNoticiasFragment.setPeliculas(noticias);

    }

    /**
     * Metodo que permite redirigir la noticia seleccionada
     * a el fragmento que contiene el detalle de la noticia
     * @param position, posicion de la noticia seleccionada
     */
    @Override
    public void onPeliculaSeleccionada(int position) {
        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia) != null;
        if (esFragmento) {
            ((DetalleDeNoticiaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia)).showDetail(noticias.get(position));
        } else {
            Intent intent = new Intent(NoticiasActualesActivity.this,
                    DetalleDeNoticiaActivity.class);
            intent.putExtra("pelicula", noticias.get(position));
            startActivity(intent);
        }
    }

}
