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
 * {@link TheoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TheoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TheoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TheoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TheoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TheoryFragment newInstance(String param1, String param2) {
        TheoryFragment fragment = new TheoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_theory, container, false);
        TextView theory = (TextView)view.findViewById(R.id.theory);
        theory.setText("1. Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.\n" +
                "\n2. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.\n" +
                "\n3. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.\n" +
                "\n4. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).\n" +
                "\n5. Since suproblems are evaluated again, this problem has Overlapping Subprolems property.\n" +
                "\n6. So the 0-1 Knapsack problem has both properties (see this and this) of a dynamic programming problem.\n" +
                "\n7. Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array K[][] in bottom up manner.\n");
        TextView complexity = (TextView)view.findViewById(R.id.complexity);
        complexity.setText("\n1. The decision problem form of the knapsack problem (Can a value of at least V be achieved without exceeding the weight W?) is NP-complete, thus there is no known algorithm both correct and fast (polynomial-time) on all cases.\n" +
                "\n2. While the decision problem is NP-complete, the optimization problem is NP-hard, its resolution is at least as difficult as the decision problem, and there is no known polynomial algorithm which can tell, given a solution, whether it is optimal (which would mean that there is no solution with a larger V, thus solving the NP-complete decision problem).\n" +
                "\n3. There is a pseudo-polynomial time algorithm using dynamic programming.\n" +
                "\n4. There is a fully polynomial-time approximation scheme, which uses the pseudo-polynomial time algorithm as a subroutine, described below.\n" +
                "\n5. Many cases that arise in practice, and \"random instances\" from some distributions, can nonetheless be solved exactly.");
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
        ((MainActivity)getActivity()).setActionBarTitle("Theory");
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
