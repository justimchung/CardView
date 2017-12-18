package com.example.justim.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justim.myapplication.ComicItemFragment.OnListFragmentInteractionListener;
import com.example.justim.myapplication.comicitem.ComicContent.ComicItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ComicItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyComicItemRecyclerViewAdapter extends RecyclerView.Adapter<MyComicItemRecyclerViewAdapter.ViewHolder> {

    private final List<ComicItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyComicItemRecyclerViewAdapter(List<ComicItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_comicitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        holder.tvTitle.setText(mValues.get(position).title);
        holder.ivCover.setImageResource(mValues.get(position).imgID);
        holder.tvLikes.setText(String.valueOf(mValues.get(position).numlikes) + " likes");

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton btnLike = (ImageButton)(view);
                int fav = Integer.valueOf((String)btnLike.getTag());
                if(fav == 0) {
                    int pos = holder.getAdapterPosition();
                    ComicItem ci = mValues.get(pos);
                    ci.numlikes++;
                    btnLike.setTag("1");
                    btnLike.setImageResource(R.drawable.fav_red_24dp);
                    notifyItemChanged(pos);
                }
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mIdView;
        public final TextView tvTitle;
        public final TextView tvLikes;
        public final ImageView ivCover;
        public final ImageButton btnLike;

        public ComicItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = view.findViewById(R.id.id);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvLikes = view.findViewById(R.id.tvLikeNum);
            ivCover = view.findViewById(R.id.ivCover);
            btnLike = view.findViewById(R.id.btnLike);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitle.getText() + "'";
        }
    }
}
