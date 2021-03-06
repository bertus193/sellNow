package com.sellnow.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.IntegerRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
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

    SeekBar seekbar;
    TextView cantidad, text;
    Button pujar;
    String txt1, txt2;
    Integer aux, puja;
    int progreso = 0;
    double tCan, tText, total;

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

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Ver subasta");

        ImageView image = (ImageView) rootview.findViewById(R.id.auctionImage);
        text = (TextView) rootview.findViewById(R.id.auctionText);
        final TextView auctionBid = (TextView) rootview.findViewById(R.id.auctionBid);
        TextView auctionCategory = (TextView) rootview.findViewById(R.id.auctionCategory);
        TextView auctionOwner = (TextView) rootview.findViewById(R.id.auctionOwner);


        seekbar = (SeekBar) rootview.findViewById(R.id.seekBar);
        seekbar.setMax(100);
        seekbar.setProgress(progreso);

        cantidad = (TextView)rootview.findViewById(R.id.newCuantity);
        cantidad.setText("" + progreso);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progreso = progress;
                cantidad.setText(""+progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        pujar = (Button)rootview.findViewById(R.id.buttonPujar);
        pujar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                AlertDialog alerta = new AlertDialog.Builder(getActivity()).create();

                tCan = Double.valueOf(String.valueOf(cantidad.getText().toString()));
                tText = Double.valueOf(String.valueOf(auctionBid.getText().toString()));
                total = tText + tCan;
                auctionBid.setText(String.valueOf((int)total));

                alerta.setMessage("¡Pujar de "+cantidad.getText()+"€ realizada!");
                alerta.setButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progreso = 0;
                        seekbar.setProgress(progreso);
                    }
                });
                alerta.show();
            }
        });



        Auction auction = ((MainActivity)getActivity()).sellNowContext.getAuctionById(this.idAuction);

        if(auction != null) {
            image.setImageResource(auction.getImageDraw());
            text.setText(auction.getText());
            auctionBid.setText(String.valueOf(auction.getActualBid()));
            auctionCategory.setText(auction.getCategory().getName());
            auctionOwner.setText(auction.getOwner().getName());
        }


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
