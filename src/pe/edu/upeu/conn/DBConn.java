package pe.edu.upeu.conn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import pe.upeu.util.SQLiteAssetHelper;

public class DBConn extends SQLiteAssetHelper {
	Context contexx;
	SQLiteDatabase db;
	
	private static final String DATA_BASENAME="poemario";
	private static final int DATABASE_VERSION=3;

	public DBConn(Context contex) {
		super(contex, DATA_BASENAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

}
