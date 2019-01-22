package br.com.estudo.filmespopulares.data.network.response;

import com.squareup.moshi.Json;

public class FilmesResponse {

    @Json(name = "poster path")
    private final String caminhoPoster;

    @Json(name = "original_title")
    private final String tituloOriginal;

    public FilmesResponse(String caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
}
