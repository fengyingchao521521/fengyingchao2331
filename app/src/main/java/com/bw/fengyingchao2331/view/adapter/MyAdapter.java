package com.bw.fengyingchao2331.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.fengyingchao2331.R;
import com.bw.fengyingchao2331.model.bean.Bean;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:9:14
 *@Description:${DESCRIPTION}
 *
 */public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHandler> {


    private List<Bean.RankingBean> list;

    public MyAdapter(List<Bean.RankingBean> ranking) {

        this.list = ranking;
    }

    @NonNull
    @Override
    public MyViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item, null);
        return new MyViewHandler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHandler holder, int position) {
        Bean.RankingBean rankingBean = list.get(position);

        Glide.with(holder.image).load(holder)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                .into(holder.image);
        holder.textView01.setText(rankingBean.getName());
        holder.textView02.setText(rankingBean.getRank() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClickListener.OnitemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHandler extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.textView01)
        TextView textView01;
        @BindView(R.id.textView02)
        TextView textView02;

        public MyViewHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    OnitemClickListener onitemClickListener;

    public interface OnitemClickListener {
        void OnitemClick(int postion);
    }

}
