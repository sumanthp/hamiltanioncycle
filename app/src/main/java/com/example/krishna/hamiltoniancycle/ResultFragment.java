package com.example.krishna.hamiltoniancycle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        String result = getArguments().getString("result");
        TextView rslt = (TextView)view.findViewById(R.id.result_text);
        rslt.setText("Cycle: "+result);
        simulate(result,view);
        return view;
    }


    public void simulate(String result,View view) {
        String text = "";
        String array[] = result.trim().split(" ");
       /* for (int i = 0; i < (1 << array.length); i++) {
            for (int j = 0; j < array.length; j++) {
                if ((i & (1 << j)) > 0) {
                    text += array[j] + " ";
                }
                //text += "\n";
            }
        }*/
       text+="\n";
       for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                text+=array[j]+"-->";
                if(i==j)
                    break;
            }
            text+="\n";
        }
        final String value = text;
        Log.d("Result: ",value);
        final LinearLayout l = (LinearLayout) view.findViewById(R.id.result_layout);
        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_right);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final TextView subset = new TextView(getActivity());
                subset.setLayoutParams(layoutParams);
                subset.setText(value);
                Log.d("TExt: ",subset.getText().toString());
                subset.setTextSize(getResources().getDimension(R.dimen.text_size));
                //subset.setTextColor(getResources().getColor(R.color.));
                subset.startAnimation(animation);
                l.addView(subset);
            }
        }, 1000);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle("Hamiltonian Cycle");
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
