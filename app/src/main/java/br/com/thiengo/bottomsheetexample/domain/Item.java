package br.com.thiengo.bottomsheetexample.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    public static final String ITEMS_KEY = "br.com.thiengo.bottomsheetexample.domain.Items";

    private int iconId;
    private String label;

    public Item(int iconId, String label ){
        this.iconId = iconId;
        this.label = label;
    }

    public int getIconId(){
        return( this.iconId );
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.iconId);
        dest.writeString(this.label);
    }

    protected Item(Parcel in) {
        this.iconId = in.readInt();
        this.label = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
