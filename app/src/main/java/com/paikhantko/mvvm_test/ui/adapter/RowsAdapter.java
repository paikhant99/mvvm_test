package com.paikhantko.mvvm_test.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.paikhantko.mvvm_test.BR;
import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.models.entities.Row;

import java.util.List;

public class RowsAdapter extends RecyclerView.Adapter<RowsAdapter.RowViewHolder> {

    private List<Row> mRows;


    public RowsAdapter(List<Row> rows) {
        this.mRows = rows;
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ViewDataBinding dataBinding=DataBindingUtil.inflate(inflater,R.layout.item_text,parent,false);
        return new RowViewHolder(dataBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        holder.binding.setVariable(BR.row,mRows.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mRows.size();
    }

    public void setRows(List<Row> rowList) {
        this.mRows = rowList;
        notifyDataSetChanged();
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String flag) {
        Glide.with(view.getContext())
                .load(flag)
                .into(view);
    }

    static class RowViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        public RowViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
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
