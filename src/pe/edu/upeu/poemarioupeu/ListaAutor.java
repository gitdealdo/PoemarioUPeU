package pe.edu.upeu.poemarioupeu;

import pe.edu.upeu.dao.AutorDAO;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAutor extends ActionBarActivity {

	AutorDAO dao;
	Cursor cur;
	String [] datos;
	
	ListView listaAutor;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autor_lista);		
		listaAutor=(ListView)findViewById(R.id.listAutorId);
		dao=new AutorDAO(this);
		cur=dao.listarAutorSimple();
		datos=new String[cur.getCount()];
		int i=0;
		
		while(cur.moveToNext()){
			datos[i]=cur.getString(1);
			i++;
		}
		
		ArrayAdapter<String> adapterA= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
		listaAutor.setAdapter(adapterA);
	}
	
	

}
