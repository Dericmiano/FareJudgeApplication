package com.example.farejudgeapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farejudgeapplication.R;
import com.example.farejudgeapplication.models.Host;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    public final List<Host> hostList;
    private final OnTodoClickListener todoClickListener;


    public RecyclerViewAdapter(List<Host> hostList, OnTodoClickListener onTodoClickListener) {
        this.hostList = hostList;
        this.todoClickListener = onTodoClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_view_visit,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Host host = hostList.get(position);
        int rating = host.getHostNumberOfStars();

        holder.host.setText(host.getHostName());
        holder.location.setText(host.getHostLocation());
        holder.comment.setText(host.getHostComment());
//         priorityRadioGroup.setVisibility(
//                    priorityRadioGroup.getVisibility()== View.GONE?
//                    View.VISIBLE : View.GONE
//            );
        if (rating <= 1){
            holder.star1.setVisibility(View.VISIBLE);
        }else  if (rating <= 2){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
        }else if(rating <=3 ){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.VISIBLE);
        }else if (rating <=4 ){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.VISIBLE);
            holder.star4.setVisibility(View.VISIBLE);

        }else {
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.VISIBLE);
            holder.star4.setVisibility(View.VISIBLE);
            holder.star5.setVisibility(View.VISIBLE);


        }


    }

    @Override
    public int getItemCount() {
        return hostList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatTextView host;
        public AppCompatTextView location;
        public AppCompatTextView comment;

        public ImageView editButton;
        public ImageView deleteButton;
        public ImageView star1;
        public ImageView star2;
        public ImageView star3;
        public ImageView star4;
        public ImageView star5;


        OnTodoClickListener onTodoClickListener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            host = itemView.findViewById(R.id.row_name);
            location  = itemView.findViewById(R.id.row_location);
            comment = itemView.findViewById(R.id.row_comment);

            star1 = itemView.findViewById(R.id.row_star1);
            star2 = itemView.findViewById(R.id.row_star2);
            star3 = itemView.findViewById(R.id.row_star3);
            star4 = itemView.findViewById(R.id.row_star4);
            star5 = itemView.findViewById(R.id.row_star5);




            editButton = itemView.findViewById(R.id.row_editBtn);
            deleteButton = itemView.findViewById(R.id.row_deleteBtn);

            this.onTodoClickListener = todoClickListener;

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Host currHost = hostList.get(getAdapterPosition());
//                    if (todoClickListener != null){
//                        todoClickListener.onTodoClick(currHost);
//
//                    }
//                }
//            });
            itemView.setOnClickListener(this);
            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            Host currHost;
            int id = v.getId();
            if (id == R.id.row_layout){
                currHost = hostList.get(getAdapterPosition());
                onTodoClickListener.onTodoClick(currHost);
            }else if (id == R.id.row_deleteBtn){
                currHost = hostList.get(getAdapterPosition());
                onTodoClickListener.onTodoDeleteButtonClick(currHost);
            }else if (id == R.id.row_editBtn){
                currHost = hostList.get(getAdapterPosition());
                onTodoClickListener.onTodoUpdateButtonClick(currHost);
            }


        }



}
    }




