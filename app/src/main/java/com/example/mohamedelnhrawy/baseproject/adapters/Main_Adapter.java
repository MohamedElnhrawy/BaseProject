package com.example.mohamedelnhrawy.baseproject.adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mohamedelnhrawy.baseproject.R;
import com.example.mohamedelnhrawy.baseproject.response.Movie;
import com.example.mohamedelnhrawy.baseproject.util.NenoRegularTextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by cems-it on 6/18/2018.
 */

public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.ViewHolder>  {
    public ArrayList<Movie> reposDataArrayList;
    public ArrayList<Movie> filterlist;
    private Context context;
//    Account_Addresses.Addresses item = new Account_Addresses.Addresses();

    private onItemClicked onItemClicked;

    public interface onItemClicked{
        void onItemClicked(View view,Movie item, int position);
    }
//    private onRecyclerViewShareIconClicked ShareCallback;
    ///////////////////constructor//////////////////
    public Main_Adapter(Context context, ArrayList<Movie> reposDataArrayList){
        this.context=context;
        this.reposDataArrayList =reposDataArrayList;
        this.filterlist=new ArrayList<>();
        filterlist.addAll(reposDataArrayList);
//        this.mCallback=  mCallback;
//        this.FavCallback=  FavCallback;
//        this.ShareCallback=  ShareCallback;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = null;
        rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(rootview,context, reposDataArrayList);
        return viewHolder;
    }




    ///////////////////////define data in card//////////////////////////////
    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_address;
        private CardView card;
        private ImageView iv_poster;
        private NenoRegularTextView tv_movname;

        ArrayList<Movie> reposDataArrayList1 = new ArrayList<>();
        Context context;

        public ViewHolder(View layout, final Context context, ArrayList<Movie> reposDataArrayList) {
            super(layout);
            this.reposDataArrayList1 = reposDataArrayList;
            this.context = context;
            card=itemView.findViewById(R.id.card);

            iv_poster = (ImageView) itemView.findViewById(R.id.iv_poster);
            tv_movname = (NenoRegularTextView) itemView.findViewById(R.id.tv_movname);
           // ll_address = (LinearLayout) itemView.findViewById(R.id.ll_address);




        }


    }

    /////////////////////set data to card///////////////////
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_movname.setText( reposDataArrayList.get(position).getName());


            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicked.onItemClicked(v,reposDataArrayList.get(position),position);
                }
//                    onAddressItemClicked.onAddressItemClicked(v,reposDataArrayList,position);
//                            }
            });


        Glide.with(context).load(reposDataArrayList.get(position).getImageurl()).into(holder.iv_poster);





        //  Picasso.with(context).load("http://128.199.206.161"+reposData.getFeatured_icon()).into(holder.categories_icon);


    }
    @Override
    public int getItemCount() {
        if (reposDataArrayList.size()>0){
            return reposDataArrayList.size();
        }else
        {
            return 0;
        }

    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void updateList(ArrayList<Movie> list){
        reposDataArrayList =  list;
        notifyDataSetChanged();
    }


    public  void setonItemClickedCallback(onItemClicked onAddressItemClicked){
        this.onItemClicked=onAddressItemClicked;
    }

    public void FilterList(String name){
        name=name.toLowerCase(Locale.getDefault());
        reposDataArrayList.clear();
        if (name.length() == 0){
            reposDataArrayList.addAll(filterlist);
        }else
        {
            for (Movie nam : filterlist){
                if (nam.getName().toLowerCase(Locale.getDefault()).contains(name)){
                    reposDataArrayList.add(nam);
                }
            }
        }
        notifyDataSetChanged();
    }


}
