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
import android.widget.Toast;

import com.hasan.navigationui.R;

import static com.hasan.navigationui.utils.Extra.MyPREFERENCES;
import static com.hasan.navigationui.utils.Extra.SF_IS_LOGIN;


public class HomeFragment extends Fragment {

    private SharedPreferences sharedpreferences;
    private NavController navController;
    private Context context;

    public HomeFragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(SF_IS_LOGIN)) {
            //startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(getContext(), "Welcome", Toast.LENGTH_SHORT).show();
        }else {
            navController.navigate(R.id.action_homeFragment_to_signInFragment);
        }
    }
}