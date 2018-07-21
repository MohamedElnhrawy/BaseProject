package com.example.mohamedelnhrawy.baseproject.ui.main;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mohamedelnhrawy.baseproject.R;
import com.example.mohamedelnhrawy.baseproject.adapters.Main_Adapter;
import com.example.mohamedelnhrawy.baseproject.base.AppBaseActivity;
import com.example.mohamedelnhrawy.baseproject.event_bus.AddressMessageEvent;
import com.example.mohamedelnhrawy.baseproject.requests.BasicRequests;
import com.example.mohamedelnhrawy.baseproject.response.Movie;
import com.example.mohamedelnhrawy.baseproject.util.GetLocation;
import com.example.mohamedelnhrawy.baseproject.util.MyProgress;
import com.example.mohamedelnhrawy.baseproject.util.SharedPref;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import static com.example.mohamedelnhrawy.baseproject.util.Utils.checkGpsenabled;

public class MainActivity extends AppBaseActivity implements Main_Adapter.onItemClicked {

    private RecyclerView movielist;
    private Main_Adapter adapter;
    private ArrayList<Movie> movies=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        checkGpsenabled(this);
        new GetLocation(this).PermissionChecked();

    }


    public void init(){
        movielist=findViewById(R.id.movielist);
        movielist.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Main_Adapter(this,movies);
        adapter.setonItemClickedCallback(this);
        movielist.setAdapter(adapter);

    }

    public void changeLanguage(View view) {
        Log.e("chooseLang",chooseLang());
        setLocale(chooseLang());
    }

    String chooseLang(){
        String lang = null;
       String current_lang=SharedPref.getLanguage();
       switch (current_lang){
           case "ar":
               lang= "en";
               break;

           case "en":
               lang= "ar";
               break;
       }


        return lang;
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(AddressMessageEvent eventGps) {
        String message = eventGps.getAddress();
        if (!message.isEmpty()) {
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        }
    }

    public void getMovies(View view) {
        MyProgress.show(this);
        BasicRequests.getMovies(new MainContract() {
            @Override
            public void onSucces(ArrayList<Movie> movies) {

                Log.e("list",""+movies.size());
                adapter.updateList(movies);
                MyProgress.dismiss();

            }

            @Override
            public void onError(String msg) {
                Log.e("error",msg);
                MyProgress.dismiss();

            }
        });
    }


    @Override
    public void onItemClicked(View view, Movie item, int position) {
        Toast.makeText(this, ""+item.getRealname(), Toast.LENGTH_SHORT).show();
    }
}
