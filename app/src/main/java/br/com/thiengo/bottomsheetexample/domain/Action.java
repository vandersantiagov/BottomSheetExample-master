package br.com.thiengo.bottomsheetexample.domain;

import android.os.Parcel;

public class Action extends Item {

    public Action(int iconId, String label) {
        super(iconId, label);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    protected Action(Parcel in) {
        super(in);
    }

    public static final Creator<Action> CREATOR = new Creator<Action>() {


        public Action createFromParcel(Parcel source) {
            return new Action(source);
        }

        public Action[] newArray(int size) {
            return new Action[size];
        }
    };
}
