package pe.edu.upeu.poemarioupeu;

import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.to.PersonaTO;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class FormPersona extends ActionBarActivity{

	EditText nombres, apellidos, usuario, password; 
	PersonaDAO dao = null;
	PersonaTO to = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_persona);
		nombres = (EditText) findViewById(R.id.txtNombres);
		apellidos = (EditText) findViewById(R.id.txtApellidos);
		usuario = (EditText) findViewById(R.id.txtUsuariop);
		password = (EditText) findViewById(R.id.txtPassword);
	
	}
	
	public void onRegistrar(View v) {
		dao = new PersonaDAO(this);
		to= new PersonaTO();
		to.setNombre(nombres.getText().toString());
		to.setApellidos(apellidos.getText().toString());
		to.setUsuario(usuario.getText().toString());
		to.setClave(password.getText().toString());
		dao.insertarPersona(to);
		
		Intent intent = new Intent();
		intent.putExtra("Vusuario", "Datos");
		intent.setClass(this, MainPoemario.class);
		startActivity(intent);
		
//		startActivity(new Intent(this, MainPoemario.class));
	}
}
