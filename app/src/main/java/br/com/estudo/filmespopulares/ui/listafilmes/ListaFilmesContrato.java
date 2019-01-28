package br.com.estudo.filmespopulares.ui.listafilmes;

import java.util.List;

import br.com.estudo.filmespopulares.data.model.Filme;

public interface ListaFilmesContrato {

    interface ListaFilmesView{
        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface  ListaFilmesPresenter{

        void obtemFilmes();

        void destruirView();
    }
}
