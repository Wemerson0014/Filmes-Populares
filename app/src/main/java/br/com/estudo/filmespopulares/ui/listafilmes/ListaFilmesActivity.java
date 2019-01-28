package br.com.estudo.filmespopulares.ui.listafilmes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import java.util.Arrays;
import java.util.List;

import br.com.estudo.filmespopulares.R;
import br.com.estudo.filmespopulares.data.mapper.FilmeMapper;
import br.com.estudo.filmespopulares.data.model.Filme;
import br.com.estudo.filmespopulares.data.network.ApiService;
import br.com.estudo.filmespopulares.data.network.response.FilmesResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaFilmesActivity extends AppCompatActivity implements ListaFilmesContrato.ListaFilmesView{

    private RecyclerView recyclerFilmes;
    private ListaFilmesAdapter filmesAdapter;
    private ListaFilmesContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraToolbar();

        configuraAdapter();

       presenter = new ListaFilmesPresenter(this);
       presenter.obtemFilmes();


    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        recyclerFilmes = findViewById(R.id.recycler_filmes);

        filmesAdapter = new ListaFilmesAdapter();

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerFilmes.setLayoutManager(gridLayoutManager);
        recyclerFilmes.setAdapter(filmesAdapter);

    }

    @Override
    public void mostraFilmes(List<Filme> filmes) {
        filmesAdapter.setFilmes(filmes);
    }

    @Override
    public void mostraErro() {
        Toast.makeText(this, "Erro ao obter lista de filmes.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }
}
