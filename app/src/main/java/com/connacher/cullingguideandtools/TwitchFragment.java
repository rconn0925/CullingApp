package com.connacher.cullingguideandtools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.connacher.cullingguideandtools.adapters.StreamerAdapter;
import com.connacher.cullingguideandtools.models.Streamer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.connacher.cullguideandtools.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TwitchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TwitchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwitchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "TwitchFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @InjectView(R.id.twitchRecyclerView)
    public RecyclerView mView;

    private OnFragmentInteractionListener mListener;
    private TwitchEngine mEngine;

    private ArrayList<Streamer> streamers;
    private GridLayoutManager mLayoutManager;
    private StreamerAdapter mStreamerAdapter;
    private Context mContext;


    public TwitchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TwitchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TwitchFragment newInstance(String param1, String param2) {
        TwitchFragment fragment = new TwitchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mEngine = new TwitchEngine();
        streamers = new ArrayList<>();
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_twitch, container, false);
       // WebView myWebView = (WebView) view.findViewById(R.id.twitchWebView);
        //myWebView.loadUrl("https://www.twitch.tv/directory/game/The%20Culling");
        ButterKnife.inject(this,view);

        Call<String> result = mEngine.getAllStreams("live","The Culling");
        result.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG,"message: "+response.message());
                try {
                    JSONObject json = new JSONObject(response.body());
                    Log.d(TAG,"body: "+ json.toString(4));

                    int numStreamers = json.getInt("_total");
                    Log.d(TAG,"numStreamers: "+ numStreamers);

                    JSONArray streams = json.getJSONArray("streams");

                    for(int i =0;i<streams.length();i++){

                        JSONObject streamData = streams.getJSONObject(i);
                        int currentStreamID = streamData.getInt("_id");
                        String game = streamData.getString("game");
                        int viewers = streamData.getInt("viewers");
                        JSONObject preview = streamData.getJSONObject("preview");
                        String previewUrl = preview.getString("medium").substring(8).replaceAll("\\/","/");
                        JSONObject channel = streamData.getJSONObject("channel");
                        String title = channel.getString("status");
                        String name = channel.getString("display_name");
                        int channelID = channel.getInt("_id");
                        String channelUrl = channel.getString("url").substring(8).replaceAll("\\/","/");

                        Streamer mStreamer = new Streamer(name,channelID,game,title,viewers,previewUrl,channelUrl);
                        Log.d(TAG,"prewview image: "+ previewUrl);
                        streamers.add(mStreamer);
                    }
                    mLayoutManager = new GridLayoutManager(getActivity(), 1);
                    mView.setLayoutManager(mLayoutManager);
                    mView.addItemDecoration(new SimpleDividerItemDecoration(mContext));
                    mStreamerAdapter = new StreamerAdapter(getActivity(), streamers);
                    mView.setAdapter(mStreamerAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
        void onFragmentInteraction(Uri uri);
    }
}
