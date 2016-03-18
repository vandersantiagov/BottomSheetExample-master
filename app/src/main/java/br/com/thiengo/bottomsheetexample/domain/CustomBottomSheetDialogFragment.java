package br.com.thiengo.bottomsheetexample.domain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.thiengo.bottomsheetexample.R;
import br.com.thiengo.bottomsheetexample.util.FakeCollection;

/**
 * Created by viniciusthiengo on 2/29/16.
 */
public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {

    public static final String FRAGMENT_KEY = "br.com.thiengo.bottomsheetexample.domain.CustomBottomSheetDialogFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.bottom_sheet_dialog, container);

        ArrayList<Item> items = getArguments().getParcelableArrayList( Item.ITEMS_KEY );

        ItemAdapter adapter = new ItemAdapter( getActivity(), items );

        GridView gv = (GridView) view.findViewById(R.id.gv_items);
        gv.setAdapter(adapter);
        gv.setNumColumns(3);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( getActivity(), "Pos: "+position, Toast.LENGTH_SHORT ).show();
            }
        });

        return(view);
    }
}
