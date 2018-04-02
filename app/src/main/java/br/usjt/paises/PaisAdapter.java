package br.usjt.paises;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.TypedArrayUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 /**
     * @author Vinicius Maciel
     * RA 816117960
     */

public class PaisAdapter extends BaseAdapter {

    Activity contexto;
    Pais[] paises;

    public PaisAdapter(Activity contexto, Pais[] paises) {
        this.contexto = contexto;
        this.paises = paises;
    }
 /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    @Override
    public int getCount(){
        return paises.length;
    }
 /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    @Override
    public Object getItem(int position){
        if(position >= 0 && position < paises.length){
            return paises[position];
        } else {
            return null;
        }
    }
 /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    @Override
    public long getItemId(int position){
        return position;
    }
 /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        LayoutInflater inflater = (LayoutInflater)
                contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_lista_paises, parent, false);

        ImageView foto = (ImageView) view.findViewById(R.id.foto_pais);
        TextView nome = (TextView) view.findViewById(R.id.nome_pais);
        TextView regiao = (TextView) view.findViewById(R.id.regiao_pais);
        TextView capital = (TextView) view.findViewById(R.id.capital_pais);

        nome.setText(paises[position].getNome());
        regiao.setText(paises[position].getRegiao());
        capital.setText(paises[position].getCapital());

        Drawable drawable = br.usjt.paises.Util.getDrawable(contexto, paises[position].getBandeira());
        foto.setImageDrawable(drawable);

        return view;

    }




}
