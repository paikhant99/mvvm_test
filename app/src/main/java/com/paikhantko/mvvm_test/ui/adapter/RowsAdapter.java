package com.paikhantko.mvvm_test.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.models.entities.Row;

import java.util.List;

public class RowsAdapter extends RecyclerView.Adapter<RowsAdapter.RowViewHolder> {

    private final Context mContext;
    private List<Row> mRows;


    public RowsAdapter(Context context, List<Row> rows) {
        this.mContext = context;
        this.mRows = rows;
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_text, parent, false);
        return new RowViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {

        holder.tvCountry.setText(mRows.get(position).getCountry());
        holder.tvTotalRecovered.setText(mContext.getResources().getString(R.string.total_recovered_label_item_name,mRows.get(position).getTotalRecovered()));
        holder.tvTotalDeath.setText(mContext.getResources().getString(R.string.total_death_label_item_name,mRows.get(position).getNewDeaths()));
    }

    @Override
    public int getItemCount() {
        return mRows.size();
    }

    public void setRows(List<Row> rowList) {
        this.mRows = rowList;
        notifyDataSetChanged();
    }

    static class RowViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountry, tvTotalRecovered, tvTotalDeath;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);
            initiateViewIds();
        }

        private void initiateViewIds() {
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvTotalDeath = itemView.findViewById(R.id.tv_total_death);
            tvTotalRecovered = itemView.findViewById(R.id.tv_total_recovered);
        }

    }

    //    private boolean longClickFirst = true;
//    private boolean multiSelected=true;
//    private List<Integer> selectedItemIds = new ArrayList<>();
//    private ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {
//        @Override
//        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            multiSelected=true;
//            menu.add("Delete");
//            return true;
//        }
//
//        @Override
//        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            return false;
//        }
//
//        @Override
//        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            mDelegate.onTextDeletePressed(selectedItemIds);
//            mode.finish();
//            return true;
//        }
//
//        @Override
//        public void onDestroyActionMode(ActionMode mode) {
//            longClickFirst = true;
//            multiSelected = false;
//            selectedItemIds.clear();
//        }
//    };


//    private void openMenuOptionDialog() {
//        final CharSequence[] items = {"Update", "Delete"};
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//
//        builder.setTitle("Select The Action");
//        builder.setItems(items, (dialog, item) -> {
//            if (item == 0) {
//                mDelegate.onTextUpdatePressed();
//            } else {
////                ((AppCompatActivity) mContext).startSupportActionMode(actionModeCallbacks);
//            }
//            dialog.cancel();
//
//        });
//        builder.setOnCancelListener(dialogInterface -> longClickFirst = true);
//        builder.show();
//    }

//    private void selectItem(Integer id,Integer pos){
//        if (multiSelected) {
//            if (selectedItemIds.contains(id)) {
//                selectedItemIds.remove(id);
//                frameLayout.setBackgroundColor(Color.WHITE);
//            } else {
//                selectedItemIds.add(id);
//                frameLayout.setBackgroundColor(Color.LTGRAY);
//            }
//        }
//    }
}
