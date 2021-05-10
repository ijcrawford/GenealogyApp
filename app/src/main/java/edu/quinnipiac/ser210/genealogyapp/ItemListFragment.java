package edu.quinnipiac.ser210.genealogyapp;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ItemListFragment extends Fragment {

    NavController navController = null;
    RecyclerView itemList;
    ListAdapter adapter;
    ArrayList<String> items;
    GenealogyDatabaseHelper dbHelper;
    Cursor cursor;
    SQLiteDatabase db;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = null;
        dbHelper = new GenealogyDatabaseHelper(view.getContext());
        db = dbHelper.getReadableDatabase();
        itemList = view.findViewById(R.id.item_list);
        itemList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        switch(getArguments().getString("category")) {
            case "sword": {
                //cursor = db.query("ITEMS", new String[] {"NAME"}, "CATEGORY = ?",new String[] {"sword"}, null, null, null);
                //if (cursor != null && cursor.moveToFirst()) {
                    items = new ArrayList<String>();
                    //do {
                        //items.add(cursor.getString(0));
                        items.add("Iron Sword");
                        items.add("Steel Sword");
                        items.add("Silver Sword");
                        items.add("Defender Sword");
                        items.add("Tyrfing");
                    //} while (cursor.moveToNext());
                    adapter = new ListAdapter(view.getContext(),items);
                    itemList.setAdapter(adapter);
                    break;
               // }
            }
            case "lance": {
                //cursor = db.query("ITEMS", new String[] {"NAME"}, "CATEGORY = ?",new String[] {"lance"}, null, null, null);
                //if (cursor != null && cursor.moveToFirst()) {
                    items = new ArrayList<String>();
                items.add("Iron Lance");
                items.add("Steel Lance");
                items.add("Silver Lance");
                items.add("Brave Lance");
                items.add("Gae Bolg");
                    //do {
                       // items.add(cursor.getString(0));
                    //} while (cursor.moveToNext());
                    adapter = new ListAdapter(view.getContext(),items);
                    itemList.setAdapter(adapter);
                    break;
               // }
            }
            case "bow": {
               // cursor = db.query("ITEMS", new String[] {"NAME"}, "CATEGORY = ?",new String[] {"bow"}, null, null, null);
                //if (cursor != null && cursor.moveToFirst()) {
                    items = new ArrayList<String>();
                items.add("Iron Bow");
                items.add("Steel Bow");
                items.add("Silver Bow");
                items.add("Killer Bow");
                items.add("Yewfelle");
                   // do {
                        //items.add(cursor.getString(0));
                    //} while (cursor.moveToNext());
                    adapter = new ListAdapter(view.getContext(),items);
                    itemList.setAdapter(adapter);
                    break;
               // }
            }
        }
    }
}