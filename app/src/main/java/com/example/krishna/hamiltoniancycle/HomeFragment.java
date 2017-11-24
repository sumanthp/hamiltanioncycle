package com.example.krishna.hamiltoniancycle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    Button submit;
    int values_count,values_array[];

    int V ;
    int path[];
    int graph[][];

    public HomeFragment() {}
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
       final View v = inflater.inflate(R.layout.fragment_home, container, false);
        submit = (Button) v.findViewById(R.id.submit);
        final Bundle bundle = new Bundle();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values_count= Integer.parseInt(((EditText)v.findViewById(R.id.values_count)).getText().toString().trim());

                String array[] = ((EditText)v.findViewById(R.id.values_array)).getText().toString().trim().split(" ");
                values_array = new int[values_count * values_count];
                convertStringToIntArray(array,values_array);
//                String result = knapsack(max_weight,weights_array,values_array,weights_count);
                String result = hamCycle(values_array,values_count);
                Log.v("Home",result);
                ResultFragment rf = new ResultFragment();
                Bundle bundle = new Bundle();
                bundle.putString("result",result);
                rf.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.home_frame, rf).addToBackStack(null).commit();
                //Intent intent = new Intent(getActivity(),ResultActivity.class);
                //startActivity(intent);
                //intent.putExtra("result",result);
            }
        });

        return v;
    }


    public void convertStringToIntArray(String array[],int storeArray[])
    {
        for(int i=0;i<array.length;i++)
        {
            storeArray[i]=Integer.parseInt(array[i]);
        }

    }

    boolean isSafe(int v, int graph[][], int path[], int pos)
    {

        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos)
    {
        if (pos == V)
        {
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < V; v++)
        {
            if (isSafe(v, graph, path, pos))
            {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1) == true)
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    String hamCycle(int v[],int n)
    {
        String str="";
        V=n;
        int k=0;
        graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = v[k];
                k++;
            }
        }
        path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;

        path[0] = 0;
        if (!hamCycleUtil(graph, path, 1))
        {
            str = "Solution does not exist";
            Log.v("Home: ","Solution does not exist");
            return str;
        }

        else{
            for (int i = 0; i < V; i++) {
                str +=path[i] + " ";
                Log.v("Home", str);
            }
            str +=path[0] + " ";
            Log.v("Home", str);
            return str;
        }

    }
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
    public void onResume(){
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle("Hamiltonian Cycle");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
