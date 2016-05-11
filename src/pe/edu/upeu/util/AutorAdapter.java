package pe.edu.upeu.util;

import java.util.List;

import pe.edu.upeu.poemarioupeu.AutorPoema;
import pe.edu.upeu.poemarioupeu.R;
import pe.edu.upeu.to.AutorTO;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class AutorAdapter extends ArrayAdapter<AutorTO> {
    private static LayoutInflater inflater = null;
    private AutorPoema context;
	public AutorAdapter(AutorPoema context, List<AutorTO> objects) {
		super(context, R.layout.autorpoema_lista,  objects);
		
		this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

    public static class ViewHolder{
        public TextView tituloNombre;
        public ImageView testimonioSelectButton;
    }
    
   
    public View getView(final int position, View convertView, ViewGroup parent) {
	View row = convertView;
        ViewHolder holder;

	if (row == null) {
	    row = inflater.inflate(R.layout.autorpoema_lista,null);
            holder = new ViewHolder();
            holder.tituloNombre = (TextView)row.findViewById(R.id.book_name);
            holder.testimonioSelectButton = (ImageView)row.findViewById(R.id.book_chapter_selection);
            row.setTag(holder);
	}
        else
            holder = (ViewHolder)row.getTag();
	
	final AutorTO entry = (AutorTO)super.getItem(position);
	
	holder.tituloNombre.setText(entry.getNombre());
	
	holder.testimonioSelectButton.setOnClickListener(new View.OnClickListener() {
	    
	    public void onClick(View v) {
		context.selectAutorPoema(entry);
	    }
	});
	
	return row;
    }	
	
}
