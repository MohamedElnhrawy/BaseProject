package com.example.mohamedelnhrawy.baseproject.requests;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.mohamedelnhrawy.baseproject.app.BaseApplication;
import com.example.mohamedelnhrawy.baseproject.network.Service;
import com.example.mohamedelnhrawy.baseproject.response.Movie;
import com.example.mohamedelnhrawy.baseproject.ui.main.MainContract;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohamedelnhrawy on 7/21/18.
 */

public class BasicRequests {

    public static void getMovies(final MainContract mainContract) {

        final ArrayList<Movie> movies=new ArrayList<>();
      Service Service = BaseApplication.getAppService();

        Call<ResponseBody> call = Service.getMovies();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.code() == 200) {
                    try {
                        JSONArray success = new JSONArray(response.body().string());
                        for (int i=0;i<success.length();i++){
                            JSONObject object=success.getJSONObject(i);
                            Movie movie=new Movie();
                            Gson gson=new Gson();
                            movie=gson.fromJson(String.valueOf(object), Movie.class);
                            movies.add(movie);
                        }

                        mainContract.onSucces(movies);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    JSONObject jObjError = null;
                    try {
                        jObjError = new JSONObject(response.errorBody().string());
                        JSONObject error = jObjError.getJSONObject("error");
                        Log.e("mess", error.getString("message"));
                        mainContract.onError( error.getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               mainContract.onError(t.getMessage());
            }
        });


    }
}
