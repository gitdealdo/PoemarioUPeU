package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.AutorTO;

public class AutorDAO extends DBConn {

	SQLiteDatabase db;
	Cursor cur;
	String sql;	
	
	public AutorDAO(Context contex) {
		super(contex);
		// TODO Auto-generated constructor stub
	}

	public List<AutorTO> listarAutor(){
		ArrayList<AutorTO> lista=new ArrayList<AutorTO>();
		AutorTO to;
		db=getReadableDatabase();
		sql="select * from autor";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new AutorTO();
			to.setIdautor(cur.getInt(0));
			to.setNombre(cur.getString(1));
			to.setApellidos(cur.getString(2));
			to.setDescripcion(cur.getString(3));
			lista.add(to);
		}
		
		return lista;
	}
	
	public Cursor listarAutorSimple(){
		db=getReadableDatabase();
		sql="select * from autor";
		cur=db.rawQuery(sql, null);
		return cur;
	}	
	
}
