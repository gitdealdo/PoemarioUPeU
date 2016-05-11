package pe.edu.upeu.poemarioupeu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

public class MainPoemario extends ActionBarActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	TextView smsId;
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main_poemario);
	smsId=(TextView)findViewById(R.id.smsId);
	
	Bundle bunX=getIntent().getExtras();
	smsId.setText(bunX.getString("Vusuario"));
	
}

public void onListarAutor(View v){
	startActivity(new Intent(this, ListaAutor.class));
}

public void onFormulario(View v){
	startActivity(new Intent(this, FormPersona.class));
}

public void reportePersona(View v) {
	startActivity(new Intent(this, ReportePersona.class));
}

}
