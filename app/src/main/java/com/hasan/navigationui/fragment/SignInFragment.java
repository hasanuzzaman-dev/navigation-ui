package com.hasan.navigationui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hasan.navigationui.R;

import static com.hasan.navigationui.utils.Extra.MyPREFERENCES;
import static com.hasan.navigationui.utils.Extra.SF_EMAIL;
import static com.hasan.navigationui.utils.Extra.SF_IS_LOGIN;
import static com.hasan.navigationui.utils.Extra.SF_MY_TOKEN;
import static com.hasan.navigationui.utils.Extra.SF_PASSWORD;


public class SignInFragment extends Fragment {


    private Button button;
    private NavController navController;
    private SharedPreferences sharedPreferences;
    private Context context;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.homeBtn);
        navController = Navigation.findNavController(view);
        sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean(SF_IS_LOGIN, true);

                editor.apply();
                navController.navigate(R.id.action_signInFragment_to_homeFragment3);
            }
        });
    }
}