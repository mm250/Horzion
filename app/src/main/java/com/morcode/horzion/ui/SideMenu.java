package com.morcode.horzion.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.morcode.horzion.R;

import java.util.Locale;

/**
 * Created by mauricemorgan on 30/09/2014.
 */
public class SideMenu {

    private Activity activity;
    private DrawerLayout layout;
    private ListView listView;

    private ActionBarDrawerToggle drawerToggle;

    private String[] titles;
    private CharSequence drawerTitle;
    private CharSequence title;

    public SideMenu (Activity p_activity) {
        activity = p_activity;
        onPostCreate();
    }

    public void onPostCreate () {
        title = drawerTitle = activity.getTitle();
        titles = activity.getResources().getStringArray(R.array.side_menu_items);
        layout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        listView = (ListView) activity.findViewById(R.id.left_drawer);
        listView.setAdapter(new ArrayAdapter<String>(activity,
                R.layout.drawer_list_item, titles));

        listView.setOnItemClickListener(new ListView.OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
               // selectItem(position);
            }
        });

        activity.getActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(
                activity,
                layout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                activity.getActionBar().setTitle(title);
                activity.invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                activity.getActionBar().setTitle(drawerTitle);
                activity.invalidateOptionsMenu();
            }
        };

        layout.setDrawerListener(drawerToggle);

        selectItem(0);
    }

    public ActionBarDrawerToggle getActionBarDrawerToggle(){
        return drawerToggle;
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
//        Fragment fragment = new PlanetFragment();
//        Bundle args = new Bundle();
//        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//        fragment.setArguments(args);
//
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//
//        // update selected item and title, then close the drawer
        listView.setItemChecked(position, true);
        activity.setTitle(titles[position]);
        layout.closeDrawer(listView);
    }


    public static class SideMenuFragment extends Fragment {

        public static final String ARG_PLANET_NUMBER = "planet_number";

        public SideMenuFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_planet, container, false);
            int i = getArguments().getInt(ARG_PLANET_NUMBER);
            String planet = getResources().getStringArray(R.array.side_menu_items)[i];

            int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                    "drawable", getActivity().getPackageName());
            ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
            getActivity().setTitle(planet);
            return rootView;
        }
    }

}
