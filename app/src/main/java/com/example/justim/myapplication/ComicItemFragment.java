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
import com.example.justim.myapplication.comicitem.ComicContent.ComicItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ComicItemFragment extends Fragment {

    protected MyComicItemRecyclerViewAdapter adapter;
    // TODO: Customize parameters
    private int mColumnCount = 1;

    protected OnListFragmentInteractionListener mListener;
    protected RecyclerView rcComicItems;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ComicItemFragment() {
        adapter = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rcComicItems = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comicitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            createAdapter();
            RecyclerView recyclerView = (RecyclerView) view;
            setLayoutManager(context, recyclerView);
            setAdapter(recyclerView);
            rcComicItems = recyclerView;
        }
        return view;
    }

    public MyComicItemRecyclerViewAdapter getAdapter() {
        return adapter;
    }

    protected void createAdapter() {
        adapter = new MyComicItemRecyclerViewAdapter(ComicContent.ITEMS, mListener);
    }


    protected void setAdapter(RecyclerView recyclerView) {
        recyclerView.setAdapter(adapter);
    }

    protected void setLayoutManager(Context context, RecyclerView recyclerView) {
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ComicItem item);
    }
}
