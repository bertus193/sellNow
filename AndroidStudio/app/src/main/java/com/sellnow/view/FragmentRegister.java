package com.sellnow.view;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sellnow.MainActivity;
import com.sellnow.R;
import com.sellnow.controller.UserSessionManager;
import com.sellnow.controller.AdminSQLiteOpenHelper;
import com.sellnow.model.User;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRegister.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRegister#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegister extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    UserSessionManager session;
    View rootView;

    EditText txtEmail, txtName, txtPassword1, txtPassword2, txtUsername;
    Button btnRegister;

    public FragmentRegister() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRegister.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegister newInstance(String param1, String param2) {
        FragmentRegister fragment = new FragmentRegister();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/

        setHasOptionsMenu (true);

        // Session class instance
        session = new UserSessionManager(getActivity().getApplicationContext());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment_register, container, false);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Registro");

        //final AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.getActivity(),"administracion", null, 1);

        txtUsername = (EditText) rootView.findViewById(R.id.txtUsername);
        txtEmail = (EditText) rootView.findViewById(R.id.txtEmail);
        txtName = (EditText) rootView.findViewById(R.id.txtName);
        txtPassword1 = (EditText) rootView.findViewById(R.id.txtPassword1);
        txtPassword2 = (EditText) rootView.findViewById(R.id.txtPassword2);

        btnRegister  = (Button) rootView.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String username = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String name = txtName.getText().toString();
                String password1 = txtPassword1.getText().toString();
                String password2 = txtPassword2.getText().toString();

                if(username.trim().length() > 0 && email.trim().length() > 0 && name.trim().length() > 0
                        && password1.trim().length() > 0 && password2.trim().length() > 0){

                    if(password1.equals(password2)){
                        User user = new User(username, password1, email, name);
                        ((MainActivity)getActivity()).sellNowContext.addUser(user);

                        /*SQLiteDatabase bd = admin.getWritableDatabase();
                        String[] args = new String[] {email};
                        Cursor c = bd.rawQuery(" SELECT email,password FROM User WHERE email=? ", args);
                        ContentValues registro = new ContentValues();
                        registro.put("email", email);
                        registro.put("password", password1);
                        bd.insert("User", null, registro);
                        bd.close();*/

                        session.createUserLoginSession(user);

                        Toast.makeText(getActivity().getApplicationContext(),
                                "Usuario registrado correctamente",
                                Toast.LENGTH_LONG).show();

                        ((MainActivity) getActivity()).createNavigationMenu();

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.mainFrame, new FragmentProfile());
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                    }
                    else{
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Las contraseñas no coinciden",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Los campos no deben estar vacíos",
                            Toast.LENGTH_LONG).show();
                }

                //Cursor fila = bd.rawQuery("select email, password from user where email=" + email, null);


                /*if (fila.moveToFirst()) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Usuario ya registrado",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    if(email.equals("") || password1.equals("") || password1.equals("")) {

                        Toast.makeText(getActivity().getApplicationContext(),
                                "Algún campo vacío",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Bien",
                                Toast.LENGTH_LONG).show();
                        ContentValues registro = new ContentValues();

                        registro.put("email", email);
                        registro.put("password", password1);
                        bd.insert("user", null, registro);

                        bd.close();
                    }
                }*/
            }
        });
        return rootView;
        //return inflater.inflate(R.layout.fragment_fragment_register, container, false);
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
