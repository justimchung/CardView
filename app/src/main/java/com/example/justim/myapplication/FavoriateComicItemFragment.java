package com.example.justim.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.justim.myapplication.comicitem.ComicContent;
import com.example.justim.myapplication.dummy.DummyContent;
import com.example.justim.myapplication.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class FavoriateComicItemFragment extends ComicItemFragment {
    private List<ComicContent.ComicItem> fav_items;
    private MyComicItemRecyclerViewAdapter adapter;

    // TODO: Customize parameters
    //private int mColumnCount = 1;

    //private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FavoriateComicItemFragment() {
        adapter = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fav_items = new ArrayList<>();
        List<ComicContent.ComicItem> aItems = ComicContent.ITEMS;
        filterFavoriateItems();
        adapter = new MyComicItemRecyclerViewAdapter(fav_items, super.mListener);
    }

    private void filterFavoriateItems() {
        fav_items.clear();
        for (ComicContent.ComicItem ci: ComicContent.ITEMS) {
            if(ci.isFavoriate == true)
                fav_items.add(ci);
        }
    }

    @Override
    protected void setAdapter(RecyclerView recyclerView) {
        //super.setAdapter(recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.setFavBtnClickListener(favBtnClickListener);
    }

    public void reflash() {
        filterFavoriateItems();
    }

    View.OnClickListener favBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder vh = rcComicItems.findContainingViewHolder(view);
            int pos = vh.getAdapterPosition();
            ComicContent.ComicItem ci = fav_items.get(pos);
            if(ci.isFavoriate == false) {
                ci.isFavoriate = true;
                ci.numlikes++;

            } else {
                ci.isFavoriate = false;
                ci.numlikes--;
            }
            fav_items.remove(pos);
            adapter.notifyItemRemoved(pos);
        }
    };

    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_favoriatecomicitem_list, container, false);
//
//        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MyComicItemRecyclerViewAdapter(fav_items, mListener));
//        }
//        return view;
//    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
////        if (context instanceof OnListFragmentInteractionListener) {
////            mListener = (OnListFragmentInteractionListener) context;
////        } else {
////            throw new RuntimeException(context.toString()
////                    + " must implement OnListFragmentInteractionListener");
////        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onListFragmentInteraction(DummyItem item);
//    }
}
