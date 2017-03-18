package com.sellnow.view;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sellnow.MainActivity;
import com.sellnow.R;
import com.sellnow.model.Auction;
import com.sellnow.model.Category;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentAddAuction.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentAddAuction#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAddAuction extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View rootView;

    private OnFragmentInteractionListener mListener;

    private String categorySelected = null;

    public FragmentAddAuction() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAddAuction.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAddAuction newInstance(String param1, String param2) {
        FragmentAddAuction fragment = new FragmentAddAuction();
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
        rootView = inflater.inflate(R.layout.fragment_fragment_add_auction, container, false);


        final Spinner categories_spinner = (Spinner) rootView.findViewById(R.id.categories_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories_spinner.setAdapter(adapter);
        categories_spinner.setOnItemSelectedListener(this);



        final TextView text = (TextView) rootView.findViewById(R.id.txtText);
        final TextView txtBid = (TextView) rootView.findViewById(R.id.txtBid);
        Button upload = (Button) rootView.findViewById(R.id.btnAddAuction);

        upload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Category category = ((MainActivity)getActivity()).sellNowContext.getCategoryByName(categorySelected);

                if(text.toString().trim().length() > 0 && category != null && txtBid.toString().trim().length() > 0) {

                    Double initialbid = Double.parseDouble(txtBid.getText().toString());
                    Auction auction = new Auction(text.getText().toString(), R.drawable.imgpreview, category, initialbid);
                    ((MainActivity) getActivity()).sellNowContext.addAuction(auction);

                    Toast.makeText(getActivity(), "Subasta añadida",
                            Toast.LENGTH_LONG).show();

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.mainFrame, new FragmentMain());
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();

                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Los campos no deben estar vacíos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.categorySelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
