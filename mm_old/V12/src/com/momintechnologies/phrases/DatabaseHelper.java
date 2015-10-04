// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.momintechnologies.phrases:
//            Phrase

public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final String CREATE_TABLE_PHRASES = "CREATE TABLE phrases(phrase_id INTEGER PRIMARY KEY,phrase_text TEXT,created_at DATETIME)";
    private static final String DATABASE_NAME = "Phrases";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_PHRASE_ID = "phrase_id";
    private static final String KEY_PHRASE_TEXT = "phrase_text";
    private static final String TABLE_PHRASES = "phrases";
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context)
    {
        super(context, "Phrases", null, 1);
    }

    public void addPhrase(Phrase phrase)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("phrase_id", Integer.valueOf(phrase.getPhraseId()));
        contentvalues.put("phrase_text", phrase.getPhraseText());
        sqlitedatabase.insert("phrases", null, contentvalues);
        sqlitedatabase.close();
    }

    public void deletePhrase(Phrase phrase)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("phrases", "phrase_id = ?", new String[] {
            String.valueOf(phrase.getPhraseId())
        });
        sqlitedatabase.close();
    }

    public List getAllPhrases()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT  * FROM phrases", null);
        if (cursor.moveToFirst())
        {
            do
            {
                Phrase phrase = new Phrase();
                phrase.setPhraseId(Integer.parseInt(cursor.getString(0)));
                phrase.setPhraseText(cursor.getString(1));
                Log.d("DatabaseHelper", (new StringBuilder()).append(phrase.getPhraseId()).append(phrase.getPhraseText()).toString());
                arraylist.add(phrase);
            } while (cursor.moveToNext());
        }
        return arraylist;
    }

    public Phrase getPhrase(int i)
    {
        Object obj = getReadableDatabase();
        Phrase phrase = new Phrase();
        obj = ((SQLiteDatabase) (obj)).query("phrases", new String[] {
            "phrase_id", "phrase_text"
        }, "phrase_id=?", new String[] {
            String.valueOf(i)
        }, null, null, null, null);
        if (obj != null)
        {
            ((Cursor) (obj)).moveToFirst();
            phrase = new Phrase(Integer.parseInt(((Cursor) (obj)).getString(0)), ((Cursor) (obj)).getString(1));
        }
        return phrase;
    }

    public int getPhraseCount()
    {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM phrases", null);
        int i = cursor.getCount();
        cursor.close();
        return i;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE phrases(phrase_id INTEGER PRIMARY KEY,phrase_text TEXT,created_at DATETIME)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS phrases");
        onCreate(sqlitedatabase);
    }

    public int updatePhrase(Phrase phrase)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("phrase_id", Integer.valueOf(phrase.getPhraseId()));
        contentvalues.put("phrase_text", phrase.getPhraseText());
        return sqlitedatabase.update("phrases", contentvalues, "phrase_id = ?", new String[] {
            String.valueOf(phrase.getPhraseId())
        });
    }
}
