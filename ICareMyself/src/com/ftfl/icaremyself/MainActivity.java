package com.ftfl.icaremyself;

import java.util.ArrayList;
import java.util.List;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.adapter.CustomDrawerAdapter;
import com.ftfl.icaremyself.fragment.AddNoteFragment;
import com.ftfl.icaremyself.fragment.CareCenterListFragment;
import com.ftfl.icaremyself.fragment.DietTabb;
import com.ftfl.icaremyself.fragment.DoctorListFragment;
import com.ftfl.icaremyself.fragment.HomeFragment;
import com.ftfl.icaremyself.fragment.MedicalHistoryListFragment;
import com.ftfl.icaremyself.fragment.VaccinationListFragment;
import com.ftfl.icaremyself.fragment.ViewProfileFragment;
import com.ftfl.icaremyself.model.DrawerItem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem(true)); // adding a spinner to the list

		dataList.add(new DrawerItem("Home")); // adding a header to the list
		dataList.add(new DrawerItem("Home", R.drawable.homecare));

		dataList.add(new DrawerItem("Main Options"));// adding a header to the
														// list
		dataList.add(new DrawerItem("Profile", R.drawable.userprofile));
		dataList.add(new DrawerItem("Diet Chart", R.drawable.dieticon));
		dataList.add(new DrawerItem("Medical History", R.drawable.his));
		dataList.add(new DrawerItem("Doctors", R.drawable.doc));
		dataList.add(new DrawerItem("Vaccine", R.drawable.vaccine));

		dataList.add(new DrawerItem("Other Option")); // adding a header to the
														// list
		dataList.add(new DrawerItem("Health Center", R.drawable.homecare));
		dataList.add(new DrawerItem("Notes", R.drawable.note));
		// dataList.add(new DrawerItem("Exit", R.drawable.ic_action_help));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.navigation_drawer_open,
				R.string.navigation_drawer_close) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {

			if (dataList.get(0).isSpinner()
					& dataList.get(1).getTitle() != null) {
				SelectItem(2);
			} else if (dataList.get(0).getTitle() != null) {
				SelectItem(1);
			} else {
				SelectItem(0);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void SelectItem(int possition) {

		switch (possition) {

		case 2:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, HomeFragment.newInstance(),
							HomeFragment.TAG).commit();
			
			break;
		case 4:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, ViewProfileFragment.newInstance(),
							ViewProfileFragment.TAG).commit();
			break;
		case 5:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, DietTabb.newInstance(),
							DietTabb.TAG).commit();
			break;
		case 6:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, MedicalHistoryListFragment.newInstance(),
							MedicalHistoryListFragment.TAG).commit();
			break;
		case 7:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, DoctorListFragment.newInstance(),
							DoctorListFragment.TAG).commit();
			break;
		case 8:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, VaccinationListFragment.newInstance(),
							VaccinationListFragment.TAG).commit();
			break;
		case 10:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, CareCenterListFragment.newInstance(),
							CareCenterListFragment.TAG).commit();
			break;
		case 11:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, AddNoteFragment.newInstance(),
							AddNoteFragment.TAG).commit();
			break;

		default:
			break;
		}

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		switch (item.getItemId()) {
		case R.id.add_pro:

			Intent intent = new Intent(this, CreateProfileActivity.class);
			startActivity(intent);

			return true;
		case R.id.add_diet:

			Intent intentDt = new Intent(this, CreateDietActivity.class);
			startActivity(intentDt);

			return true;
		case R.id.add_doc:

			Intent intentDr = new Intent(this, CreateDoctorProfileActivity.class);
			startActivity(intentDr);

			return true;
		case R.id.add_mh:

			Intent intentMh = new Intent(this, MedicalHistoryCreateActivity.class);
			startActivity(intentMh);

			return true;
		case R.id.add_vac:

			Intent intentVc = new Intent(this, VaccinationActivity.class);
			startActivity(intentVc);

			return true;
		case R.id.add_note:

			Intent intentNt = new Intent(this, AddNoteActivity.class);
			startActivity(intentNt);

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (dataList.get(position).getTitle() == null) {
				SelectItem(position);
			}

		}
	}
}
