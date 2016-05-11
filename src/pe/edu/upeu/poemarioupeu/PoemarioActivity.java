package pe.edu.upeu.poemarioupeu;

import pe.edu.upeu.dao.PersonaDAO;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class PoemarioActivity extends ActionBarActivity {

	EditText txtUsuario;
	EditText txtClave;
	TextView txtSms;
	
	PersonaDAO dao;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_poemario);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtClave=(EditText)findViewById(R.id.txtClave);
        txtSms=(TextView)findViewById(R.id.sms);
        dao=new PersonaDAO(this);
        //dao.loginPoemario("davidmp", "123456");
        
    }

    public void onIngresar(View view){
    	dao=new PersonaDAO(this);
    	String usuario="", clave="";
    	NotificationCompat.Builder ms=new Builder(this);
    	
    	usuario=txtUsuario.getText().toString();
    	clave=txtClave.getText().toString();
    	try { 
			//if(usuario.equals("davidmp") && clave.equals("123456")){
			if(dao.loginPoemario(usuario, clave)){
			Log.v("ERROR : ","Si Ingreso" );	
			
			//ms.setContentTitle("Mensaje");
			//ms.setContentText("Bienvenido...Ingresaste");
			Toast.makeText(this, "Ingreso...!", Toast.LENGTH_SHORT).show();
			txtSms.setText("");	
            Intent inten=new Intent();
            inten.putExtra("Vusuario", txtUsuario.getText().toString());
            inten.setClass(this, MainPoemario.class);
            txtUsuario.setText("");
            txtClave.setText("");            
            startActivity(inten);
			}else{
				txtSms.setText("Error: Intente Nuevamente");
				ms.setContentTitle("Mensaje");
				ms.setContentText("Bienvenido...Ingresaste");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

        
        
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.poemario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
