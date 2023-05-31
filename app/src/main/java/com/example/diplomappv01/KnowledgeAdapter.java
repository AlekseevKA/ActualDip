package com.example.diplomappv01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.KnowledgeViewHolder> {
    private List<KnowledgeItem> knowledgeList;

    public KnowledgeAdapter(List<KnowledgeItem> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    @NonNull
    @Override
    public KnowledgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_knowledge, parent, false);
        return new KnowledgeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KnowledgeViewHolder holder, int position) {
        KnowledgeItem knowledgeItem = knowledgeList.get(position);
        holder.bind(knowledgeItem);
    }

    @Override
    public int getItemCount() {
        return knowledgeList.size();
    }

    static class KnowledgeViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView descriptionTextView;

        public KnowledgeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }

        public void bind(KnowledgeItem knowledgeItem) {
            nameTextView.setText(knowledgeItem.getName());
            descriptionTextView.setText(knowledgeItem.getDescriptionshort());
        }
    }
}

