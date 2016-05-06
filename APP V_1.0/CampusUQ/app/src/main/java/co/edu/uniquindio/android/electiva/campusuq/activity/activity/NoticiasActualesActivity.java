package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

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
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa la pelicula
 */
public class NoticiasActualesActivity extends AppCompatActivity implements ListaDeNoticiasFragment.OnPeliculaSeleccionadaListener{


    private ListaDeNoticiasFragment listaDeNoticiasFragment;
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
     * Metodo que nos permite inicializar el menu que es enviado por parametro
     * @param menu, menu el cual se va a inflar
     * @return true cuando se inicializa correctamente el menu falso en caso contrario
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    /**
     * Metodo que es llamado cuando se selecciona un elemento de un menu
     * @param item, el item  que ha sido seleccionado
     * @return false, para que ocurra el procedimiento normal o true si requiere consusumir o
     * hacer un procedimiento desde el metodo
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * Metodo que permite redirigir la pelicula seleccionada
     * a el frngmento que contiene el detalle de la pelicula
     * @param position, posicion de la pelicula seleccionada
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
