package br.com.thiengo.bottomsheetexample.domain;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.thiengo.bottomsheetexample.R;
import br.com.thiengo.bottomsheetexample.util.FakeCollection;

/**
 * Created by viniciusthiengo on 2/29/16.
 */
public class CustomBottomSheetDialog extends BottomSheetDialog {

    private Context context;

    public CustomBottomSheetDialog(Context context){
        super(context);

        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View layout = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
        setContentView( layout );

        ArrayList<Item> items = FakeCollection.getItems();

        ItemAdapter adapter = new ItemAdapter( this.context, items );

        GridView gv = (GridView) layout.findViewById(R.id.gv_items);
        gv.setAdapter(adapter);
        gv.setNumColumns(3);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( context, "Pos: "+position, Toast.LENGTH_SHORT ).show();
            }
        });

    }
}
