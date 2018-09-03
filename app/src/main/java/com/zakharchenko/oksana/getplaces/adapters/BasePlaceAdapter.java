package com.zakharchenko.oksana.getplaces.adapters;

import android.support.v7.widget.RecyclerView;
import com.zakharchenko.oksana.getplaces.db.model.BasePlace;
import com.zakharchenko.oksana.getplaces.fragments.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePlaceAdapter<T extends BasePlace, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private OnItemClickListener<T> onItemClickListener;

    protected List<T> list = new ArrayList<>();

    public void setData(List<T> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return list;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        bindItem(holder, getItem(position));
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(v -> {
            int position1 = (int) v.getTag();
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(v, position1, list.get(position1));
        });
    }

    private T getItem(int position) {
        return list.get(position);
    }

    public abstract void bindItem(VH holder, T item);

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
