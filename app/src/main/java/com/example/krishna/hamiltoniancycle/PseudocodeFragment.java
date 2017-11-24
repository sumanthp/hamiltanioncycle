package com.example.krishna.hamiltoniancycle;

/**
 * Created by Admin on 17-Nov-17.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PseudocodeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PseudocodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PseudocodeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PseudocodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PseudocodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PseudocodeFragment newInstance(String param1, String param2) {
        PseudocodeFragment fragment = new PseudocodeFragment();
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
        View view = inflater.inflate(R.layout.fragment_pseudocode, container, false);
        TextView pseudocode = (TextView)view.findViewById(R.id.pseudo);
        pseudocode.setText("Dynamic programming solution for the 0/1 knapsack problem also runs in pseudo-polynomial time. Assume w1,w2,...,wn,W are strictly positive integers. " +
                "\n\nDefine m[i,w] to be the maximum value that can be attained with weight less than or equal to w using items up to i (first i items).\n" +
                "\n" +
                "We can define  m[i,w] m[i,w] recursively as follows:\n" +
                "\n" +
                "m[0,w]=0} m[0,w]=0\n" +
                "m[i,w]=m[i-1,w] if wi > w " +
                "\n(the new item is more than the current weight limit)\n" +
                "m[i,w]=max(m[i-1,w],m[i-1,w-wi]+vi) if wi <= w.\n" +
                "\nThe solution can then be found by calculating m[n,W]. To do this efficiently we can use a table to store previous computations.\n" +
                "\n" +
                "\nThe following is pseudo code for the dynamic program:\n" +
                "\n" +
                " 1 // Input:\n" +
                " 2 // Values (stored in array v)\n" +
                " 3 // Weights (stored in array w)\n" +
                " 4 // Number of distinct items (n)\n" +
                " 5 // Knapsack capacity (W)\n" +
                " 6 \n" +
                " 7 for j from 0 to W do:\n" +
                " 8     m[0, j] := 0\n" +
                " 9 \n" +
                "10 for i from 1 to n do:\n" +
                "11     for j from 0 to W do:\n" +
                "12         if w[i] > j then:\n" +
                "13             m[i, j] := m[i-1, j]\n" +
                "14         else:\n" +
                "15             m[i, j] := max(m[i-1, j], m[i-1, j-w[i]] + v[i])\n" +
                "This solution will therefore run in O(nW) time and O(nW) space.\n" +
                "\n");
        return view;
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
        ((MainActivity)getActivity()).setActionBarTitle("Pseudocode");
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
