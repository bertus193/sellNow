package com.sellnow.view;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sellnow.MainActivity;
import com.sellnow.R;
import com.sellnow.model.Auction;
import com.sellnow.model.SellNow;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProduct.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProduct#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProduct extends Fragment {

    private static final String ARG_PARAM1 = "name";
    private int idAuction;
    private View rootview;


    private OnFragmentInteractionListener mListener;

    public FragmentProduct() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentProduct.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProduct newInstance(int param1) {
        FragmentProduct fragment = new FragmentProduct();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idAuction = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_fragment_product, container, false);

        ImageView image = (ImageView) rootview.findViewById(R.id.auctionImage);
        TextView text = (TextView) rootview.findViewById(R.id.auctionText);

        Auction auction = ((MainActivity)getActivity()).sellNowContext.getAuctions().get(this.idAuction);

        image.setImageResource(auction.getImageDraw());
        text.setText(auction.getText());


        return rootview;
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
