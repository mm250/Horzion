package com.morcode.horzion.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.morcode.horzion.App;
import com.morcode.horzion.R;
import com.morcode.horzion.ui.events.OffCanvasEvent;
import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Provider;

public class OffCanvas extends ListView {

    @Inject
    Bus bus;

    @Inject
    Provider<OffCanvasEvent> offCanvasEvent;

    private DrawerLayout itemLayout;
    private ActionBarDrawerToggle drawerToggle;
    private String[] headings;
    private Activity activity;

    public OffCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initComponents (Activity p_activity){
        activity = p_activity;
        ((App) activity.getApplication()).inject(this);
        headings = activity.getResources().getStringArray(R.array.side_menu_items);
        itemLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        setAdapter(new ArrayAdapter<String>(activity, R.layout.drawer_list_item, headings));

        drawerToggle = new ActionBarDrawerToggle(
                activity,
                itemLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                activity.invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                activity.invalidateOptionsMenu();
            }
        };

        itemLayout.setDrawerListener(drawerToggle);
        attachEvents();
        selectItem(0);
    }

    private void attachEvents () {
        setOnItemClickListener (new ListView.OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView< ? > parent, View view, int position, long id){
            selectItem(position);
            final OffCanvasEvent event = offCanvasEvent.get();
            event.setSideMenuItemId(position);
            bus.post(event);
            }
        });
    }

    private void selectItem(int position) {
        setItemChecked(position, true);
        activity.setTitle(headings[position]);
        itemLayout.closeDrawer(this);
    }

    public ActionBarDrawerToggle getActionBarDrawerToggle(){
        return drawerToggle;
    }
}
