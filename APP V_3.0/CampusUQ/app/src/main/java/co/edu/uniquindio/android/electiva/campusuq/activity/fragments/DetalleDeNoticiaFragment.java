/**
 * Este paquete contiene el fragmento DetalleDeNoticiaFragment
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.fragments;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la clase.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.campusuq.R;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016
 * Clase DetalleDeNoticiaFragment que representa la logica del fragmento con el detalle de la pelicula a mostrar
 */

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleDeNoticiaFragment extends Fragment {

    /**
     * Atributo titulo que representa el control textView para el titulo de la noticia
     */
    private TextView titulo;

    /**
     * Atributo pelicula que representa un objeto noticia
     */
    private Noticia noticia;

    /**
     * Metodo constructor del fragmento
     */

    public DetalleDeNoticiaFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo que nos permite asociar el fragmento con un layout
     * @param inflater, el layout para inflar el fragmento
     * @param container, es la vista padre que contiene el fragmento.
     * @param savedInstanceState, bundle que nos permite guar estados.
     * @return retorna el fragmento inflado con el layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_noticia, container, false);
    }

    /**
     * Metodo que nos permite ver los detalles de una noticia
     * @param noticia, la noticia que se requiere ver los detalles
     */
    public void showDetail(Noticia noticia) {
        this.noticia= noticia;
        noticia.getTitulo();
        titulo = (TextView) getView().findViewById(R.id.titulo_de_detalle_pelicula);
        titulo.setText(noticia.getTitulo());
    }
}
