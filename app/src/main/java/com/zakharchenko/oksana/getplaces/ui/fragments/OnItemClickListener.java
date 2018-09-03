package com.zakharchenko.oksana.getplaces.ui.fragments;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClick(View view, int position, T item);
}
