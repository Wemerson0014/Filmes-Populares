package br.com.estudo.filmespopulares.ui.detalhesfilme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.estudo.filmespopulares.R;
import br.com.estudo.filmespopulares.data.model.Filme;

public class DetalhesFilmeActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        TextView textTituloFilme = findViewById(R.id.text_titulo_filme);

        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);

        textTituloFilme.setText(filme.getTitulo());


    }
}
