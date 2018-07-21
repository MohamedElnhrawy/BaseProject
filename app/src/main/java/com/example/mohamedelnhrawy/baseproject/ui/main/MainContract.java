package com.example.mohamedelnhrawy.baseproject.ui.main;

import com.example.mohamedelnhrawy.baseproject.response.Movie;

import java.util.ArrayList;

/**
 * Created by mohamedelnhrawy on 7/21/18.
 */

public interface MainContract {

    void onSucces(ArrayList<Movie> movies);
    void onError(String msg);
}
