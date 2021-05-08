package edu.quinnipiac.ser210.genealogyapp;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailFragment extends Fragment {

    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase db;

       public ItemDetailFragment() {
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
        return inflater.inflate(R.layout.fragment_item_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = new GenealogyDatabaseHelper(view.getContext());
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("ITEMS",new String[] {"IMAGE_RESOURCE_ID", "NAME", "STATS", "EFFECT", "LOCATION"},"NAME = ?", new String[] {getArguments().getString("name")},null,null,null);
        if(cursor.moveToFirst()) {
            int photoId = cursor.getInt(0);
            String nameText = cursor.getString(1);
            String statsText = cursor.getString(2);
            String effectText = cursor.getString(3);
            String locationText = cursor.getString(4);

            ImageView image = (ImageView) view.findViewById(R.id.item_image);
            image.setImageResource(photoId);
            image.setContentDescription(nameText);
            TextView name = (TextView) view.findViewById(R.id.name_text);
            name.setText(nameText);
            TextView stats = (TextView) view.findViewById(R.id.stats_text);
            stats.setText(statsText);
            TextView effect = (TextView) view.findViewById(R.id.name_text);
            effect.setText(effectText);
            TextView location = (TextView) view.findViewById(R.id.stats_text);
            location.setText(locationText);
        }
        cursor.close();
        db.close();
    }
}