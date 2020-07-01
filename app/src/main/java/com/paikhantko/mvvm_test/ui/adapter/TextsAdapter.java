package com.paikhantko.mvvm_test.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.models.entities.Text;

import java.util.List;

public class TextsAdapter extends RecyclerView.Adapter<TextsAdapter.TextViewHolder> {

    private Context mContext;
    private List<Text> mTexts;

    public TextsAdapter(Context context,List<Text> texts) {
        this.mContext=context;
        this.mTexts=texts;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_text,parent,false);
        return new TextViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
//        holder.bindData(mTexts.get(position));
        holder.tvSentence.setText(mTexts.get(position).getSentence());
    }

    @Override
    public int getItemCount() {
        return mTexts.size();
    }

    public void setTexts(List<Text> textList){
        this.mTexts=textList;
        Log.d("listsize: ",getItemCount()+"");
        notifyDataSetChanged();
    }

    class TextViewHolder extends RecyclerView.ViewHolder{
        TextView tvSentence;
        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            initiateViewIds();
        }

        private void initiateViewIds(){
            tvSentence=itemView.findViewById(R.id.tv_sentence);
        }

//        public void bindData(Text text){
//
//            Log.e(".....", "bindData: "+text.getSentence());
//        }
    }
}
