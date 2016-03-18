package br.com.thiengo.bottomsheetexample.util;

import java.util.ArrayList;
import br.com.thiengo.bottomsheetexample.R;
import br.com.thiengo.bottomsheetexample.domain.Action;
import br.com.thiengo.bottomsheetexample.domain.Item;

public final class FakeCollection {
    static private ArrayList<Action> actions;
    static private ArrayList<Item> items;

    private FakeCollection(){}

    static public ArrayList<Action> getActions(){
        if( actions == null ){
            actions = new ArrayList<>();
            actions.add( new Action(R.drawable.ic_copy, "Copy") );
            actions.add( new Action(R.drawable.ic_share, "Share") );
            actions.add( new Action(R.drawable.ic_cut, "Cut") );
            actions.add( new Action(R.drawable.ic_remove, "Remove") );
        }
        return( actions );
    }

    static public ArrayList<Item> getItems(){
        if( items == null ){
            items = new ArrayList<>();
            items.add( new Item(R.drawable.ic_sign_up, "Cadastrar") );
            items.add( new Item(R.drawable.ic_login, "Login") );
            items.add( new Item(R.drawable.ic_contact, "Contato") );
            items.add( new Item(R.drawable.ic_inspector, "Inspetor Device") );
            items.add( new Item(R.drawable.ic_department, "Departamentos") );
            items.add( new Item(R.drawable.ic_deep_link, "Deep link") );
            items.add( new Item(R.drawable.ic_event, "Criar Evento") );
            items.add( new Item(R.drawable.ic_news, "Criar Notícia") );
            items.add( new Item(R.drawable.ic_wall, "Mural") );
        }
        return( items );
    }
}
