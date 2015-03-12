package com.ftfl.icaremyself.fragment;

import java.util.ArrayList;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.adapter.NoteAdapter;
import com.ftfl.icaremyself.database.NoteDataSource;
import com.ftfl.icaremyself.util.NoteProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AddNoteFragment extends Fragment {
	
public static final String TAG = ViewProfileFragment.class.getSimpleName();
	
	ListView mListView = null;
	NoteDataSource mSqlSource = null;

	public static AddNoteFragment newInstance() {
		return new AddNoteFragment();
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_note_list,
				container, false);
		
		mSqlSource = new NoteDataSource(getActivity());
		
		ArrayList<NoteProfile> noteProfiles = mSqlSource.getAllData();

		NoteAdapter adapter = new NoteAdapter(getActivity(), noteProfiles);

		// adding adapter to the list view.
		mListView = (ListView) rootView.findViewById(R.id.listNote);
		mListView.setAdapter(adapter);
		
		return rootView;
	}

}


