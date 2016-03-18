package br.com.thiengo.bottomsheetexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.thiengo.bottomsheetexample.domain.Action;
import br.com.thiengo.bottomsheetexample.domain.ActionAdapter;
import br.com.thiengo.bottomsheetexample.domain.CustomBottomSheetDialog;
import br.com.thiengo.bottomsheetexample.domain.CustomBottomSheetDialogFragment;
import br.com.thiengo.bottomsheetexample.domain.Item;
import br.com.thiengo.bottomsheetexample.util.FakeCollection;

public class MainActivity extends AppCompatActivity {

    private float offsetY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    protected void onResume() {
        super.onResume();
        this.init();
    }

    private void init(){
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        offsetY = 0;
        View bottomSheet = findViewById(R.id.rv_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from( bottomSheet );
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {}

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                if( offsetY < slideOffset ){
                    fab.hide();
                }
                else if( offsetY > slideOffset ){
                    fab.show();
                }
                offsetY = slideOffset;
            }
        });

        ArrayList<Action> actions = FakeCollection.getActions();

        ActionAdapter adapter = new ActionAdapter( this, actions );

        ListView lv = (ListView) findViewById(R.id.lv_actions);
        lv.setAdapter( adapter );
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( MainActivity.this, "Pos: "+position, Toast.LENGTH_SHORT ).show();
            }
        });

    }


    public void callBottomSheetDialog( @NonNull View view ){
        CustomBottomSheetDialog dialog = new CustomBottomSheetDialog( this );
        dialog.show();
    }


    public void callBottomSheetDialogFragment( @NonNull View view ){

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Item.ITEMS_KEY, FakeCollection.getItems() );

        CustomBottomSheetDialogFragment fragment = new CustomBottomSheetDialogFragment();
        fragment.setArguments( bundle );
        fragment.show( getSupportFragmentManager(), CustomBottomSheetDialogFragment.FRAGMENT_KEY );
    }
}
