package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.AutorTO;
import pe.edu.upeu.to.PersonaTO;
import pe.edu.upeu.to.PoemaTO;

public class PersonaDAO extends DBConn{

	SQLiteDatabase db;
	Cursor cur;
	String sql;
	
	public PersonaDAO(Context contex) {
		super(contex);
		// TODO Auto-generated constructor stub
	}

	
	public boolean loginPoemario(String usuario, String clave){
		db=getReadableDatabase();
		sql="select * from persona where usuario='"+usuario+"' and clave='"+clave+"' ";
		cur=db.rawQuery(sql, null);
		if(cur.moveToNext()){
			return true;
		}else{
			return false;
		}		
	}

	public List<PersonaTO> listarPersona(){
		ArrayList<PersonaTO> lista=new ArrayList<PersonaTO>();
		PersonaTO to;
		db=getReadableDatabase();
		sql="select * from autor";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new PersonaTO();
			to.setIdPersona(cur.getInt(0));
			to.setNombre(cur.getString(1));
			to.setApellidos(cur.getString(2));
			to.setUsuario(cur.getString(3));
			lista.add(to);
		}
		
		return lista;
	}
	
	public boolean insertarPersona(PersonaTO to) {
		db = getWritableDatabase();
		sql = "insert into persona(nombre, apellidos, usuario, clave) values('"+to.getNombre()+"'"
				+ ",'"+to.getApellidos()+"','"+to.getUsuario()+"','"+to.getClave()+"')";
		db.execSQL(sql);
		return db.inTransaction();
	}
	
	public boolean eliminarPersona(int id) {
		db = getWritableDatabase();
		sql = "delete from persona where _id='"+id+"' ";
		db.execSQL(sql);
		return db.inTransaction();
	}
}
