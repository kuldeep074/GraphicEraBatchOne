package com.example.pradeep.chatscreendemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pradeep.chatscreendemo.dummy.DummyContent;
import com.example.pradeep.chatscreendemo.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;
    RecyclerView mList;
    MyItemRecyclerViewAdapter adapter;

    Button send;
    EditText data;
    public static final List<DummyContent.DummyItem> ITEMS = new ArrayList<DummyItem>();


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        mList = (RecyclerView) view.findViewById(R.id.listv);

        send=(Button)view.findViewById(R.id.button);
        data=(EditText)view.findViewById(R.id.editext);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DummyContent.DummyItem item=new DummyContent.DummyItem("",data.getText().toString(),"");
                ITEMS.add(item);
                adapter.notifyDataSetChanged();

            }
        });
        // Set the adapter

        Context context = view.getContext();

        if (mColumnCount <= 1) {
            mList.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mList.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        adapter=new MyItemRecyclerViewAdapter(ITEMS, mListener);
        mList.setAdapter(adapter);


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
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
        void onListFragmentInteraction(DummyItem item);
    }
}
