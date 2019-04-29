package com.jingyu.mynews.save.detail;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jingyu.mynews.R;
import com.jingyu.mynews.WebViewActivity;
import com.jingyu.mynews.common.BaseViewModel;
import com.jingyu.mynews.common.MyFragmentManager;

import static com.jingyu.mynews.WebViewActivity.URL;

public class ReadmoreViewModel extends BaseViewModel<ReadmoreViewModel.ReadmoreViewModelHolder> {

    private final String uri;
    private final MyFragmentManager fragmentManager;

    public ReadmoreViewModel(String uri, MyFragmentManager fragmentManager) {
        super(R.layout.readmore_layout);
        this.uri = uri;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ReadmoreViewModelHolder createItemViewHolder(View view) {
        return new ReadmoreViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(ReadmoreViewModelHolder holder) {
        holder.readMore.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        holder.readMore.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(URL, uri);
            fragmentManager.startActivityWithBundle(WebViewActivity.class, false, bundle);
        });
    }

    static class ReadmoreViewModelHolder extends RecyclerView.ViewHolder {
        TextView readMore;
        ReadmoreViewModelHolder(View itemView) {
            super(itemView);
            readMore = itemView.findViewById(R.id.readmore);
        }
    }
}

