package br.usjt.paises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * @author Vinicius Maciel
 * RA 816117960
 */
public class ListaPaises extends Activity {
    public static final String PAIS = "br.usjt.pais.pais";
    Activity atividade;
    ArrayList<Pais> paises;
    ArrayList<String> nomes;
    /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE);
        paises = Data.listarPaises(continente);
        nomes = Data.listarNomes(paises);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(atividade, DetalhePais.class);
                intent.putExtra(PAIS, paises.get(position));

                startActivity(intent);

            }

        });
    }
}
