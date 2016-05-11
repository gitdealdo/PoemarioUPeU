package pe.edu.upeu.poemarioupeu;

import java.util.Iterator;
import java.util.List;

import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.to.PersonaTO;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ReportePersona extends ActionBarActivity{

	TableLayout tabla;
	PersonaDAO dao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.persona_lista);	
		tabla = (TableLayout) findViewById(R.id.tablaPersona);
		dao = new PersonaDAO(this);
		tabla.removeAllViews();
		TableRow tablaDato;
		TextView num, nombre, usuario;
		TextView opcEliminar, opcActualizar;
		int i=0;		
		ImageButton imgEliminar, imgActualizar;
		PersonaTO to;
		
		List<PersonaTO> lista = dao.listarPersona();
		Iterator<PersonaTO> per = lista.iterator();
		
		OnClickListener optEliminar = new OnClickListener() {
			@Override
			public void onClick(View v) {
				ImageButton im = (ImageButton) v;
				dao=new PersonaDAO(v.getContext());
				String objdel = v.getTag().toString();
				dao.eliminarPersona(Integer.parseInt(objdel));				
			}			
		};

		while (per.hasNext()) {
			if (i==0) {
				tablaDato = new TableRow(this);
				num = new TextView(this);
//				num.setText("#");
				tablaDato.addView(num);
				
				nombre = new TextView(this);
				nombre.setText("Nombre");
				tablaDato.addView(nombre);
				
//				usuario = new TextView(this);
//				usuario.setText("Usuario");
//				tablaDato.addView(usuario);
				
				opcActualizar = new TextView(this);
				opcActualizar.setText("Actualizar");
				tablaDato.addView(opcActualizar);
				
				opcEliminar = new TextView(this);
				opcEliminar.setText("Eliminar");
				tablaDato.addView(opcEliminar);
				
				tabla.addView(tablaDato);
			}
			to = new PersonaTO();
			to = per.next();
			i++;
			
			tablaDato = new TableRow(this);
			num = new TextView(this);
			num.setText(String.valueOf(i));
//			num.setBackgroundColor(Color.parseColor("#505050"));
			tablaDato.addView(num);
			
			nombre = new TextView(this);
			nombre.setText(to.getNombre());
//			nombre.setBackgroundColor(Color.parseColor("#00ff55"));
			nombre.setWidth(250);
			tablaDato.addView(nombre);
			
//			usuario = new TextView(this);
//			usuario.setText(to.getUsuario());
//			usuario.setWidth(30);
//			tablaDato.addView(usuario);
			
			imgActualizar = new ImageButton(this);
			imgActualizar.setImageResource(R.drawable.edit);			
			tablaDato.addView(imgActualizar);
			
			imgEliminar = new ImageButton(this);
			imgEliminar.setImageResource(R.drawable.delete);
			imgEliminar.setTag(to.getIdPersona());// enviando id
			imgEliminar.setOnClickListener(optEliminar);
			tablaDato.addView(imgEliminar);
			
			tabla.addView(tablaDato);
		}	
	}
	
	public ReportePersona(){
		
	}
}
