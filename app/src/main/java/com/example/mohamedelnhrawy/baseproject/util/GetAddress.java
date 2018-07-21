package com.example.mohamedelnhrawy.baseproject.util;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.mohamedelnhrawy.baseproject.event_bus.AddressMessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;


@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class GetAddress extends AsyncTask<String,Void,String> {

    private Context mContext;
    double lat,lng;
    AddressMessageEvent event;

    public GetAddress(Context context){
        mContext = context;
    }
   // ProgressDialog dialog = new ProgressDialog(MainActivity.this);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        dialog.setMessage("Please wait...");
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
             lat = Double.parseDouble(strings[0].split(",")[0]);
             lng = Double.parseDouble(strings[0].split(",")[1]);
            String response;
            HttpDataHandler http = new HttpDataHandler();
            //https://maps.googleapis.com/maps/api/geocode/json?key=AbCdEfGhIjKlMnOpQrStUvWxYz&address=Dallas&sensor=true
            //AIzaSyAyy_bL4fqYJQpYD5gf4TS6vgWXSE82NZs old
            String url = String.format(Locale.ENGLISH,"https://maps.googleapis.com/maps/api/geocode/json?latlng=%.4f,%.4f&sensor=false&key=AIzaSyCY9qnVYeMKLMoodPQPIa7_lEch9jinaqU",lat,lng);
            response = http.GetHTTPData(url);
            return response;
        }
        catch (Exception ex)
        {

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if (s != null) {
        try {
            JSONObject jsonObject = new JSONObject(s);
          //  Log.e("all",jsonObject.toString());
           // SharedPref.SaveGeoAddress(mContext, ((JSONArray) jsonObject.get("results")).getJSONObject(0).get("formatted_address").toString());
            event=new AddressMessageEvent();
            event.setAddress( ((JSONArray) jsonObject.get("results")).getJSONObject(0).get("formatted_address").toString());
           event.setLat(((JSONArray) jsonObject.get("results")).getJSONObject(0)
                   .getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
            event.setLng(((JSONArray) jsonObject.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
            EventBus.getDefault().post(event);


//
//               Log.e("lat",((JSONArray) jsonObject.get("results")).getJSONObject(0)
//                   .getJSONObject("geometry").getJSONObject("location").get("lat").toString());
//
//            Log.e("lng",((JSONArray) jsonObject.get("results")).getJSONObject(0)
//                    .getJSONObject("geometry").getJSONObject("location").get("lng").toString());
//
//            SharedPref.SaveLatitude(mContext,((JSONArray) jsonObject.get("results")).getJSONObject(0)
//                    .getJSONObject("geometry").getJSONObject("location").get("lat").toString());
//
//            SharedPref.SaveLongitude(mContext,((JSONArray) jsonObject.get("results")).getJSONObject(0)
//                    .getJSONObject("geometry").getJSONObject("location").get("lng").toString());
//
//            Log.e("Address here ", ((JSONArray) jsonObject.get("results")).getJSONObject(0).get("formatted_address").toString());

//                       Log.e("country ", ((JSONArray)
//                    jsonObject.get("results")).getJSONObject(1).getJSONArray("address_components").getJSONObject(4).get("short_name")
//                    .toString());
//
//            String Current_Country=((JSONArray)
//                    jsonObject.get("results")).getJSONObject(1).getJSONArray("address_components").getJSONObject(4).get("short_name")
//                    .toString();
//            if (Current_Country != null)
//            {
//                SharedPref.SetCountry(mContext,Current_Country);
//            }
//
//
//            Constants.addressList = new ArrayList<String>(Arrays.asList(((JSONArray) jsonObject.get("results"))
//                    .getJSONObject(0).get("formatted_address").toString().split(", ")));
//
//
//            if ( Constants.CITY_LAT== null  )
//            {
//                Constants.CITY_LAT = Double.valueOf(((JSONArray) jsonObject.get("results")).getJSONObject(0)
//                        .getJSONObject("geometry").getJSONObject("location").get("lat").toString());
//
//                Constants.CITY_LONG = Double.valueOf(((JSONArray) jsonObject.get("results")).getJSONObject(0)
//                        .getJSONObject("geometry").getJSONObject("location").get("lng").toString());
//
//            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    }
}