package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.campusuq.R;

import co.edu.uniquindio.android.electiva.campusuq.activity.fragments.DetalleDeNoticiaFragment;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;

/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa el detalle de una pelicula
 */
public class DetalleDeNoticiaActivity extends AppCompatActivity {
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_noticia);

        DetalleDeNoticiaFragment detalleDeNoticia = (DetalleDeNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);
        Noticia film = (Noticia) getIntent().getExtras().getParcelable("pelicula");
        detalleDeNoticia.showDetail(film);

    }
}
