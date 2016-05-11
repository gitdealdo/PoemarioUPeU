package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.AutorTO;
import pe.edu.upeu.to.PoemaTO;

public class PoemaDAO extends DBConn {

	SQLiteDatabase db;
	Cursor cur;
	String sql;
	
	public PoemaDAO(Context contex) {
		super(contex);
		// TODO Auto-generated constructor stub
	}
	
	public List<PoemaTO> listarAutorPoema(int id){
		ArrayList<PoemaTO> lista=new ArrayList<PoemaTO>();
		PoemaTO to;
		db=getReadableDatabase();
		sql="select * from poema where idPoema ='"+id+"' ";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new PoemaTO();
			to.setIdPoema(cur.getInt(0));
			to.setIdAutor(cur.getInt(1));
			to.setPoema(cur.getString(2));
			lista.add(to);
		}
		
		return lista;
	}
	

}
