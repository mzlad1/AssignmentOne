package com.example.assignmentone;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CaptionedMathAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Math> mathList;
    public CaptionedMathAdapter(Context context, ArrayList<Math> mathList) {
    this.mathList = mathList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mathList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view, parent, false);
        }

        TextView txt = convertView.findViewById(R.id.EQtext);
        txt.setText(mathList.get(position).getX() + " " + mathList.get(position).getOperation() + " " + mathList.get(position).getY() + " = ?");

        RadioGroup radioGroup = convertView.findViewById(R.id.group);
        radioGroup.clearCheck();

        TextView r1 = convertView.findViewById(R.id.R1);
        r1.setText("" + mathList.get(position).getOptionOne());
        TextView r2 = convertView.findViewById(R.id.R2);
        r2.setText("" + mathList.get(position).getOptionetwo());
        TextView r3 = convertView.findViewById(R.id.R3);
        r3.setText("" + mathList.get(position).getOptionThree());
        TextView r4 = convertView.findViewById(R.id.R4);
        r4.setText("" + mathList.get(position).getOptionFour());

        Button btn = convertView.findViewById(R.id.check);
        btn.setTag(position);
        View finalConvertView = convertView;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = finalConvertView.findViewById(selectedId);

                if(radioButton == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(finalConvertView.getContext());
                    builder.setTitle("No Answer");
                    builder.setMessage("Please select an answer!");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    });
                    builder.show();
                    return;
                }

                if (radioButton.getText().toString().equals("" + mathList.get(position).getAnswer())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(finalConvertView.getContext());
                    builder.setTitle("Correct");
                    builder.setMessage("You got it right!");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    });
                    builder.show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(finalConvertView.getContext());
                    builder.setTitle("Incorrect");
                    builder.setMessage("You got it wrong!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    });
                    builder.show();
                }
            }
        });

        return convertView;
    }
}

