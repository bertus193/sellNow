package com.sellnow.view;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sellnow.MainActivity;
import com.sellnow.controller.AuctionsAdapter;
import com.sellnow.R;
import com.sellnow.controller.UserSessionManager;
import com.sellnow.model.Auction;
import com.sellnow.model.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    UserSessionManager session;
    View rootView;

    private OnFragmentInteractionListener mListener;

    public FragmentProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Session class instance
        session = new UserSessionManager(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment_profile, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Perfil");

        LinearLayout profileLayout = (LinearLayout) rootView.findViewById(R.id.profileInfo);
        TextView userNameView = (TextView) rootView.findViewById(R.id.userName);
        TextView userEmailView = (TextView) rootView.findViewById(R.id.userEmail);

        if(session.isUserLoggedIn()){
            String username = session.getUserDetails().get("username");
            userEmailView.setText(session.getUserDetails().get("email"));

            User user = ((MainActivity)getActivity()).sellNowContext.getUserByName(username);
            if(user != null) {
                userNameView.setText(username);

                List<Auction> auctions = ((MainActivity)getActivity()).sellNowContext.getAuctionsByuser(user);

                if(!auctions.isEmpty()) {
                    RecyclerView auctionRecyclerView = (RecyclerView) rootView.findViewById(R.id.productList);
                    auctionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    AuctionsAdapter adapter = new AuctionsAdapter();
                    auctionRecyclerView.setAdapter(adapter);

                    adapter.setAuctions(auctions);
                }
                else{
                    TextView htext =new TextView(getActivity());
                    htext.setText("No has creado ninguna subasta aún");
                    htext.setGravity(Gravity.CENTER);
                    htext.setPadding(0,20,0,0);
                    htext.setTextSize(26);
                    htext.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                    profileLayout.addView(htext);
                }
            }
            else{
                // user null
            }
        }
        else {
            //Is not logged
        }








        //LinearLayout profileAuctionsLayout = (LinearLayout) rootView.findViewById(R.id.profileAuctions);


        Button buttonLogout = (Button) rootView.findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                session.logoutUser();

                ((MainActivity)getActivity()).createNavigationMenu();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, new FragmentLogin());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
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
