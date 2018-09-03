package com.zakharchenko.oksana.getplaces.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.api.APIRequest;
import com.zakharchenko.oksana.getplaces.ui.fragments.BillFragment;
import com.zakharchenko.oksana.getplaces.ui.fragments.GroupFragment;
import com.zakharchenko.oksana.getplaces.ui.fragments.SchemaFragment;
import com.zakharchenko.oksana.getplaces.ui.fragments.UnionListFragment;
import com.zakharchenko.oksana.getplaces.ui.fragments.PlaceFragment;
import com.zakharchenko.oksana.getplaces.utils.Constants;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        APIRequest.getInstance().getPlaces();
        if (savedInstanceState == null) {
            UnionListFragment fragment = new UnionListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_union:
                showListFragment(Constants.Type.UNION, "");
                break;
            case R.id.menu_groups:
                showListFragment(Constants.Type.GROUP, "");
                break;

            case R.id.menu_schemas:
                showListFragment(Constants.Type.SCHEMA, "");
                break;

            case R.id.menu_places:
                showListFragment(Constants.Type.PLACE, "");
                break;
            case R.id.menu_bills:
                showListFragment(Constants.Type.BILL, "");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showListFragment(Constants.Type type, String query) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.QUERY, query);
        switch (type) {
            case GROUP:
                GroupFragment groupFragment = new GroupFragment();
                replaceFragmentWithArgs(groupFragment, bundle);
                break;
            case UNION:
                UnionListFragment unionListFragment = new UnionListFragment();
                replaceFragmentWithArgs(unionListFragment, bundle);
                break;
            case SCHEMA:
                Log.d(TAG, "showListFragment: Schema");
                SchemaFragment schemaFragment=new SchemaFragment();
                replaceFragmentWithArgs(schemaFragment, bundle);
                break;
            case PLACE:
                PlaceFragment placeFragment = new PlaceFragment();
                replaceFragmentWithArgs(placeFragment, bundle);
                break;
            case BILL:
                BillFragment billFragment = new BillFragment();
                replaceFragmentWithArgs(billFragment, bundle);
                break;
        }
    }


    private void replaceFragmentWithArgs(Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}
