package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.edu.uniquindio.android.electiva.campusuq.R;
import co.edu.uniquindio.android.electiva.campusuq.activity.util.Utilidades;




public class IdiomaActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);
        button = (Button) findViewById(R.id.espa);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.ingle);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (button.getId() == v.getId()) {
            Utilidades.cambiarIdioma(getBaseContext());
            Intent intent = new Intent(this, Principal.class);
            this.finish();
            startActivity(intent);
        }else{
            if (button1.getId() == v.getId()) {
                Utilidades.cambiarIdiomaIn(getBaseContext());
                Intent intent = new Intent(this, Principal.class);
                this.finish();
                startActivity(intent);

            }
    }
    }
}
