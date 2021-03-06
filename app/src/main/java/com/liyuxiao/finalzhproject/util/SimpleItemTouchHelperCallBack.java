package com.liyuxiao.finalzhproject.util;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouchHelperCallBack extends ItemTouchHelper.Callback {
    private TouchCallBack touchCallBack;

    public SimpleItemTouchHelperCallBack(TouchCallBack touchCallBack) {
        this.touchCallBack = touchCallBack;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int move = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipe = ItemTouchHelper.LEFT;
        return makeMovementFlags(move,swipe);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        touchCallBack.oniteMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        touchCallBack.onitemDelete(viewHolder.getAdapterPosition());
    }
}
