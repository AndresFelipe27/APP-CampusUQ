package co.edu.uniquindio.android.electiva.campusuq.activity.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.edu.uniquindio.android.electiva.campusuq.R;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    public final static String url = "https://www.uniquindio.edu.co";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (button.getId() == v.getId()) {

            Intent intent = new Intent(this, SugerenciasActivity.class);
            startActivity(intent);

        } else {
            if (button1.getId() == v.getId()) {

                    Intent intent = new Intent(this, NoticiasActualesActivity.class);
                    startActivity(intent);

            } else {
                if (button2.getId() == v.getId()) {

                    Intent intent = new Intent(this, AyudaActivity.class);
                    startActivity(intent);

                } else {
                    if (button3.getId() == v.getId()) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } else {
                        if (button4.getId() == v.getId()) {
                            Intent intent = new Intent(this, IdiomaActivity.class);
                            this.finish();
                            startActivity(intent);
                        } else {
                            if (button5.getId() == v.getId()) {
                                Intent intent = new Intent(this, DirectorioActivity.class);
                                startActivity(intent);
                            }
                        }

                    }
                }
            }
        }

    }
}
