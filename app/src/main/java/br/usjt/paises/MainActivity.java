package br.usjt.paises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
/**
 * @author Vinicius Maciel
 * RA 816117960
 */
public class MainActivity extends Activity {

    Spinner spinnerContinente;
    public static final String CHAVE = "br.usjt.desmob.geodata.txtContinente";
    String continente = "Todos";
    /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = (Spinner)findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new PaisSelecionado());
    }
    /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    public void listarPaises(View view){
        Intent intent = new Intent(this, ListaPaises.class);

        intent.putExtra(CHAVE, continente);
        startActivity(intent);
    }
    /**
     * @author Vinicius Maciel
     * RA 816117960
     */
    private class PaisSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
        }
        /**
         * @author Vinicius Maciel
         * RA 816117960
         */
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}

