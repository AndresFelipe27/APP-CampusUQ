/**
 * Este paquete contiene la clase AdaptadorDeNoticia
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.util;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la clase.
 */
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.campusuq.activity.fragments.ListaDeNoticiasFragment;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.campusuq.R;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016
 *
 * Clase AdaptadorDeNoticia que representa el adaptador usado para agregar la información en el <<RecyclerView>>
 */
public class AdaptadorDeNoticia extends RecyclerView.Adapter<AdaptadorDeNoticia.NoticiaViewHolder> {

    /**
     * Atributo ArrayList "Lista  de noticias"
     */
    private ArrayList<Noticia> noticias;

    /**
     * Atributo  para escuchar cuando se hace click en una noticia
     */
    private static OnClickAdaptadorDeNoticia listener;

    /**
     * Metodo contructor de la clase
     * @param noticias, el arreglo de noticias a mostrar
     * @param listaDeNoticiasFragment, el fagmento de la lista de Noticias
     */
    public AdaptadorDeNoticia(ArrayList<Noticia>noticias, ListaDeNoticiasFragment listaDeNoticiasFragment) {
        this.noticias= noticias;
        listener= (OnClickAdaptadorDeNoticia) listaDeNoticiasFragment;
    }

    /**
     * Metodo para inflar un View con base al layout <<resumen_de_noticia>>
     *
     * @param parent, el padre del view a inflar, en este caso un ViewGroup
     * @param viewType, El tipo de vista de la nueva vista.
     */
    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Se infla el view con el ImagenView y el TextView del layout resumen_de_noticia
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_de_noticia, parent, false);


        //Se guarda en peliculaVH el view inflado para no tener que cargarlo despues
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);

        //Se retorna
        return noticiaVH;
    }

    /**
     * Metodo que visualizar los datos en la posicion especifica
     * @param holder, guarda la informacion de ese control para no tener que volver a cargarla
     * @param position, la posicion de la vista.
     */
    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        Noticia pelicula = noticias.get(position);
        holder.binPelicual(pelicula);

    }
    /**
     * Metodo que permite contar los elementos de la lista
     * @return el tamaño de la lista de noticias
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    /**
     * Clase NoticiaViewHolder necesaria para usar el patrón <<ViewHolder>>, el cual consiste en almacenar
     * todos los controles que son cargados por el método <<findViewByID>> de cada uno de los ítems del control
     * de selección <<RecyclerView>>, ya que su carga es costosa.
     */
    public static class NoticiaViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{

        /**
         * Atributo Control de seleccion TextView para el titulo de la Noticia
         */
        private TextView txtTitulo;

        /**
         * Metodo contructor de la clase NoticiaViewHolder
         * @param itemView, el item de la lista
         */
        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);


        }

        /**
         * Metodo utilizado para actualizar los datos de una pelicula
         *
         * @param p Noticia a actualizarle el dato titulo
         */
        public void binPelicual(Noticia p) {
            txtTitulo.setText(p.getTitulo());

        }

        /**
         * Metodo que permite identificar el item de la vista presionado
         *
         * Metodo obligatorio de la clase OnClickListener, genera un archivo log de registro diciendo la
         * posicion clickeada y el titulo de la noticia cuando se hace click en el view que ingresa por parametro.
         *
         * @param v, la vista del evento
         */
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtTitulo.getText());

        }
    }

    /**
     * Interface para informarle al adaptador en que posicion de la lista de noticias se hizo click
     */
    public interface OnClickAdaptadorDeNoticia{
        public void onClickPosition(int pos);
    }



}
