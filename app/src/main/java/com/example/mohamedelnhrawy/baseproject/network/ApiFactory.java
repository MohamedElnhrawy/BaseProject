package com.example.mohamedelnhrawy.baseproject.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiFactory {

    private  static Retrofit retrofit=null;
    public   static String BASE_URL= "https://simplifiedcoding.net/demos/";


    static final OkHttpClient okHttpClientSession = new OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
//            .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request().newBuilder()
//                            .addHeader("X-Oc-Merchant-Id", "123")
//                            .build();
//                    return chain.proceed(request);
//
//                }
//            })
            .build();

    static final OkHttpClient okHttpClientAll= new OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
//            .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request().newBuilder()
//                            .addHeader("X-Oc-Merchant-Id", "123")
//                            .addHeader("X-Oc-Session",EcommerceSharedPref.getSecretKey())
//                            .build();
//
//                    return chain.proceed(request);
//
//                }
//            })
            .build();



    public static Service create() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

                retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(okHttpClientAll)
                        .build();


        return retrofit.create(Service.class);
    }



}
