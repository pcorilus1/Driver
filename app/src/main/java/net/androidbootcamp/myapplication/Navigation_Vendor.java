package net.androidbootcamp.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class Navigation_Vendor extends AppCompatActivity {

    private final FragmentManager fragMan = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_vendor);

        ListOrdersFragment listOrders = new ListOrdersFragment();
        fragMan.beginTransaction()
                .replace(R.id.fl_container, listOrders, "LISTORDERS")
                .addToBackStack("LISTORDERS")
                .commit();
    }
}
