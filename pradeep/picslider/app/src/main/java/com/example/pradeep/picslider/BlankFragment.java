package com.example.pradeep.picslider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BlankFragment extends Fragment {
    private Button prev;
    private Button next;
    private ImageView image;
    int k=0;
    private OnFragmentInteractionListener mListener;

    int []a;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

            a =new int[10];
            a[0]=R.drawable.a;
            a[0]=R.drawable.a;
            a[1]=R.drawable.b;
            a[2]=R.drawable.c;
            a[3]=R.drawable.d;
            a[4]=R.drawable.e;
            a[5]=R.drawable.f;
            a[6]=R.drawable.g;
            a[7]=R.drawable.h;
            a[8]=R.drawable.i;
            a[9]=R.drawable.j;

            prev=(Button)view.findViewById(R.id.prev);
            next=(Button)view.findViewById(R.id.next);
            image=(ImageView)view.findViewById(R.id.image);

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {


                    if (k <=9) {
                        image.setImageResource(a[k]);
                        k++;
                    }
                    else {
                        Toast.makeText(getActivity(), "press prev", Toast.LENGTH_SHORT).show();
                        System.out.println(k);
                        k=9;
                    }
                }
                catch (Exception e) {

                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {


                    if (k >= 0) {
                        image.setImageResource(a[k]);
                        k--;
                    }
                    else {
                        Toast.makeText(getActivity(), "press next", Toast.LENGTH_SHORT).show();
                        System.out.println(k);
                        k=0;
                    }
                }
                catch (Exception e) {

                }
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement blankFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void blankFragmentInteraction(Uri uri);
    }
}
