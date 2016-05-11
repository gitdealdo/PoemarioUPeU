package pe.edu.upeu.poemarioupeu;

import java.util.List;

import pe.edu.upeu.dao.AutorDAO;
import pe.edu.upeu.dao.PoemaDAO;
import pe.edu.upeu.to.AutorTO;
import pe.edu.upeu.to.PoemaTO;
import pe.edu.upeu.util.AutorAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class AutorPoema extends ListActivity implements OnItemClickListener{

	AutorDAO dao;
	PoemaDAO daop;
	List<AutorTO> lista;
	List<PoemaTO> plista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autor_lista);
		dao = new AutorDAO(this);
		getListView().setFastScrollEnabled(true);
		getListView().setTextFilterEnabled(true);
		setTitle("Autor Poema");
		lista = dao.listarAutor();
		setListAdapter(new AutorAdapter(this, lista));
		getListView().setOnItemClickListener(this);
	}
	
	public void selectAutorPoema(final AutorTO to) {
		daop = new PoemaDAO(this);
		plista = daop.listarAutorPoema(to.getIdautor());
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
	

}
