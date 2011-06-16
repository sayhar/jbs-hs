/**
 * 
 * Pattered off of the EventsData (v3) class in Hello Android.
 */

package org.jbs.happysad;

import static android.provider.BaseColumns._ID;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static org.jbs.happysad.Constants.TABLE_NAME;
import static org.jbs.happysad.Constants.TIME;
import static org.jbs.happysad.Constants.LAT;
import static org.jbs.happysad.Constants.LONG;
import static org.jbs.happysad.Constants.EMO;
import static org.jbs.happysad.Constants.MSG;
import android.database.sqlite.SQLiteOpenHelper;

public class HappyData extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "happy.db";
	private static final int DATABASE_VERSION = 1;
	
	/**
	 * Constructor for the HappyData object
	 */
	public HappyData(Context ctx){
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	/**
	 * The first time this is created, create the table you'll use forevermore. (I hope)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+ TABLE_NAME + 
				" (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				LAT + " REAL, " + LONG + " REAL, " + 
				EMO + " REAL, " + MSG + " TEXT, " + TIME + " INTEGER);");
	}

	@Override
	/**
	 * When you realize that you need a new table configuration,
	 * destroy the old table and create a new one.
	 * 
	 * This behavior is not intelligent and should be changed by the final version.
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//DO NOT allow the code to stay this way in the final version. 
		// You should more intelligently handle upgrades.
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	    onCreate(db);
	}

	

	
}
