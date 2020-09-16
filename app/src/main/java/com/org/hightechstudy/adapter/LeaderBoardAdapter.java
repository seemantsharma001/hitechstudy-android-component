package com.org.hightechstudy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.hightechstudy.R;
import com.org.hightechstudy.databinding.AdapterLeaderBoardBinding;

public class LeaderBoardAdapter  extends RecyclerView.Adapter {

    private Context context;
    private AdapterLeaderBoardBinding binding;


    public LeaderBoardAdapter(Context context) {
        this.context = context;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRank;
        public ImageView ivMedal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvRank = itemView.findViewById(binding.tvRank.getId());
            this.ivMedal = itemView.findViewById(binding.ivMedal.getId());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = AdapterLeaderBoardBinding.inflate(LayoutInflater.from(context));
        ViewHolder holder =new ViewHolder(binding.getRoot());
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        binding.getRoot().setLayoutParams(lp);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).tvRank.setText(""+(position+1));
        if(position==0){
            ((ViewHolder)holder).ivMedal.setImageDrawable(context.getResources().getDrawable(R.drawable.gold_medal));
        }else if(position==1){
            ((ViewHolder)holder).ivMedal.setImageDrawable(context.getResources().getDrawable(R.drawable.silver_medal));
        }else if(position==2){
            ((ViewHolder)holder).ivMedal.setImageDrawable(context.getResources().getDrawable(R.drawable.bronz_medal));
        }else {
            ((ViewHolder)holder).ivMedal.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
