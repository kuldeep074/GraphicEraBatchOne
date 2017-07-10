/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.jsonparsingdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.relsellglobal.jsonparsingdemo.dummy.DummyContent;
import in.relsellglobal.jsonparsingdemo.dummy.DummyContent.DummyItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class jasonfragFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ProgressBar pb;
    private OnListFragmentInteractionListener mListener;
    List<WebPojo> webPojoList;
    MyjasonfragRecyclerViewAdapter js;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public jasonfragFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jasonfrag_list, container, false);

        RecyclerView rc=(RecyclerView) view.findViewById(R.id.list);
        pb=(ProgressBar)view.findViewById(R.id.pb);
        // Set the adapter
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));

            webPojoList =new ArrayList<>();

            new JSONParsingTask().execute();
            js=new MyjasonfragRecyclerViewAdapter(webPojoList, mListener);
          rc.setAdapter(js);

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

    public class JSONParsingTask extends AsyncTask<Void,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {

            String url = "http://relsellglobal.in/DeliveryS/CRKInsightsServer/mobilecheck.php?controlVar=32";
            StringBuffer stringBuffer = new StringBuffer();

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

                int code = connection.getResponseCode();

                if(code == HttpURLConnection.HTTP_OK) {

                    InputStream inputStream = connection.getInputStream();

                    String line = "";


                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    while((line = bufferedReader.readLine()) != null) {
                        stringBuffer.append(line);
                    }

                    return stringBuffer.toString();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.GONE);

            if(s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONObject jsonObjectList = jsonObject.getJSONObject("list");
                    JSONArray jsonArray = jsonObjectList.getJSONArray("data");

                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject obj = (JSONObject) jsonArray.get(i);
                        WebPojo webPojo = new WebPojo();
                        webPojo.setId(obj.getString("ID"));
                        webPojo.setUsername(obj.getString("USERNAME"));
                        webPojo.setFcmId(obj.getString("FCMID"));
                        webPojoList.add(webPojo);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println(webPojoList);

                // for refreshing recycler view ui.
                js.notifyDataSetChanged();


            }


        }
    }
}
