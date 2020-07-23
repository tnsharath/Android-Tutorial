package com.runshaw.tutorial.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.runshaw.tutorial.NotesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath on 2020/07/22
 **/
public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = "DbHelper";
    // Database Name
    private static final String DB_NAME = "db_todo";

    // Database version
    private static final int DB_VERSION = 1;

    //Column names
    private static final String KEY_NOTE_ID = "note_id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESC = "description";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";

    //Table Name
    private static final String TABLE_NOTE = "table_note";

    // table Create statement
    // create table table_note (note_id integer primary key AUTOINCREMENT NOT NULL,
    //                          title text,
    //                          desc text,
    //                          date text,
    //                          time text)

    private static final String CREATE_TABLE_NOTE = "CREATE TABLE " + TABLE_NOTE + "("
            + KEY_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + KEY_TITLE + " TEXT, "
            + KEY_DESC + " TEXT, "
            + KEY_DATE + " TEXT, "
            + KEY_TIME + " TEXT )";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

    public void insertNotesValue(NotesModel notesModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, notesModel.getTitle());
        values.put(KEY_DESC, notesModel.getDesc());
        values.put(KEY_DATE, notesModel.getDate());
        values.put(KEY_TIME, notesModel.getTime());

        db.insert(TABLE_NOTE, null, values);
        Log.i(TAG, "insertNotesValue: insert successful");

    }

    public List<NotesModel> getAllNotes() {

        List<NotesModel> notes = new ArrayList<>();

        String selectQuery = "SELECT * "
                + " FROM " + TABLE_NOTE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                NotesModel notesModel = new NotesModel(c.getString(c.getColumnIndex(KEY_TITLE)),
                        c.getString(c.getColumnIndex(KEY_DESC)),
                        c.getString(c.getColumnIndex(KEY_DATE)),
                        c.getString(c.getColumnIndex(KEY_TIME)));
                notes.add(notesModel);
            } while (c.moveToNext());
        }
        return notes;
    }
}
