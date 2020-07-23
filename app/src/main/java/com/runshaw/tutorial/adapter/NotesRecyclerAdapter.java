package com.runshaw.tutorial.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.runshaw.tutorial.NotesModel;
import com.runshaw.tutorial.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath on 2020/07/23
 **/
public class NotesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<NotesModel> notesModelList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((NotesViewHolder) holder).bind(notesModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return notesModelList.size();
    }

    public void setNotes(List<NotesModel> notes){
        notesModelList = notes;
        notifyDataSetChanged();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvDesc;
        TextView tvDate;
        TextView tvTime;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTime = itemView.findViewById(R.id.tvTime);
        }

        public void bind(NotesModel notesModel){
            tvTitle.setText(notesModel.getTitle());
            tvDesc.setText(notesModel.getDesc());
            tvDate.setText(notesModel.getDate());
            tvTime.setText(notesModel.getTime());
        }
    }
}
