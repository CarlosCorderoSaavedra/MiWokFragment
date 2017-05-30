package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context , 0 , words);
        mColorResourceId = colorResourceId;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWords = getItem(position);

        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.image_resource);
        if(currentWords.hasImage()){
            imageResource.setImageResource(currentWords.getImageResourceID());
        }else{
            imageResource.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTrasnlation = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTrasnlation.setText(currentWords.getDefaultTranslation());


        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miwokTranslation.setText(currentWords.getMiwokTranslation());


        return listItemView;
    }
}
