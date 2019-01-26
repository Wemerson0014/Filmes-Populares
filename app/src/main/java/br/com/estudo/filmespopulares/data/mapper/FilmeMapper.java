package br.com.estudo.filmespopulares.data.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.estudo.filmespopulares.data.model.Filme;
import br.com.estudo.filmespopulares.data.network.response.FilmeResponse;

public class FilmeMapper {
    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmesResponse) {
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmesResponse) {
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
            listaFilmes.add(filme);
        }
        return listaFilmes;
    }
}
