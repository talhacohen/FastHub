package com.fastaccess.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.fastaccess.data.dao.ReviewCommentModel;
import com.fastaccess.ui.adapter.callback.OnToggleView;
import com.fastaccess.ui.adapter.callback.ReactionsCallback;
import com.fastaccess.ui.adapter.viewholder.ReviewCommentsViewHolder;
import com.fastaccess.ui.widgets.recyclerview.BaseRecyclerAdapter;
import com.fastaccess.ui.widgets.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by Kosh on 11 Nov 2016, 2:07 PM
 */

public class ReviewCommentsAdapter extends BaseRecyclerAdapter<ReviewCommentModel, ReviewCommentsViewHolder, BaseViewHolder
        .OnItemClickListener<ReviewCommentModel>> {

    private OnToggleView onToggleView;
    private ReactionsCallback reactionsCallback;

    public ReviewCommentsAdapter(@NonNull List<ReviewCommentModel> data,
                                 @Nullable BaseViewHolder.OnItemClickListener<ReviewCommentModel> listener,
                                 OnToggleView onToggleView, ReactionsCallback reactionsCallback) {
        super(data, listener);
        this.onToggleView = onToggleView;
        this.reactionsCallback = reactionsCallback;
    }


    @Override protected ReviewCommentsViewHolder viewHolder(ViewGroup parent, int viewType) {
        return ReviewCommentsViewHolder.newInstance(parent, this, onToggleView, reactionsCallback);
    }

    @Override protected void onBindView(ReviewCommentsViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
