package edu.quinnipiac.ser210.genealogyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.json.JSONArray;

public class GenealogyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "genealogy finder";
    private static final int DB_VERSION = 1;

    public GenealogyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    private void insertItem(SQLiteDatabase db, String category, int image_resource_id, String name, String stats, String effect, String location) {
        ContentValues itemValues = new ContentValues();
        itemValues.put("CATEGORY", category);
        itemValues.put("IMAGE_RESOURCE_ID", image_resource_id);
        itemValues.put("NAME", name);
        itemValues.put("STATS", stats);
        itemValues.put("EFFECT", effect);
        itemValues.put("LOCATION", location);
        db.insert("ITEMS", null, itemValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE ITEMS (_id INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORY TEXT, IMAGE_RESOURCE_ID INTEGER, NAME TEXT, STATS TEXT, EFFECT TEXT, LOCATION TEXT);");
            insertItem(db,"sword",R.drawable.sword_iron, "Iron Sword", "Might: 6, Weight: 3, Hit: 80, Rank: C", "-", "common item");
            insertItem(db,"sword",R.drawable.sword_steel, "Steel Sword", "Might: 10, Weight: 3, Hit: 80, Rank: B", "-", "common item");
            insertItem(db,"sword",R.drawable.sword_silver, "Silver Sword", "Might: 14, Weight: 3, Hit: 80, Rank: A", "-", "Get from Arvis by talking with Sigurd in Prologue");
            insertItem(db,"sword",R.drawable.sword_defender, "Defender Sword", "Might: 12, Weight: 5, Hit: 90, Rank: C", "+7 Defense", "Get from second-most northern village in Chapter 4 by visiting with Sylvia");
            insertItem(db,"sword",R.drawable.sword_tyrfing, "Tyrfing", "Might: 30, Weight: 7, Hit: 80, Rank: S", "+10 Skill, +10 Speed, +20 Resistance, Grants Miracle skill", "Get from Byron by talking with Sigurd in Chapter 5");

            insertItem(db,"lance",R.drawable.lance_iron, "Iron Lance", "Might: 12, Weight: 12, Hit: 80, Rank: C", "-", "common item");
            insertItem(db,"lance",R.drawable.lance_steel, "Steel Lance", "Might: 12, Weight: 12, Hit: 80, Rank: C", "-", "common item");
            insertItem(db,"lance",R.drawable.lance_silver, "Silver Lance", "Might: 20, Weight: 12, Hit: 80, Rank: A", "-", "common item");
            insertItem(db,"lance",R.drawable.lance_brave, "Brave Lance", "Might: 15, Weight: 5, Hit: 90, Rank: B", "Grants 2 consecutive strikes per attack", "Get from Quan by talking with Finn in Chapter 2");
            insertItem(db,"lance",R.drawable.lance_gae_bolg, "Gae Bolg", "Might: 30, Weight: 12, Hit: 70, Rank: S", "+10 Strength, +10 Skill, +10 Defense", "Get from Ethlyn by talking with Quan in Chapter 3");


            insertItem(db,"bow",R.drawable.bow_iron, "Iron Bow", "Might: 10, Weight: 8, Hit: 70, Rank: C", "-", "common item");
            insertItem(db,"bow",R.drawable.bow_steel, "Steel Bow", "Might: 14, Weight: 8, Hit: 70, Rank: B", "-", "common item");
            insertItem(db,"bow",R.drawable.bow_silver, "Silver Bow", "Might: 18, Weight: 8, Hit: 70, Rank: A", "-", "common item");
            insertItem(db,"bow",R.drawable.bow_killer, "Killer Bow", "Might: 14, Weight: 3, Hit: 100, Rank: C", "Grants Critical skill", "Comes with Jamke upon recruitment");
            insertItem(db,"bow",R.drawable.bow_yewfelle, "Yewfelle", "Might: 30, Weight: 13, Hit: 70, Rank: S", "+10 Strength, +10 Speed, Grants Renewal skill", "Get from Edain by talking with her to Brigid in Chapter 3");

        }
        if (oldVersion < 2) {

        }
    }
}
