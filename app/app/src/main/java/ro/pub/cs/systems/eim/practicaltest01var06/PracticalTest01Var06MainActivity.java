package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
//            int leftNumberOfClicks = Integer.valueOf(leftEditText.getText().toString());
//            int rightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());

            EditText editText1 = (EditText)findViewById(R.id.edit_text_1);
            EditText editText2 = (EditText)findViewById(R.id.edit_text_2);
            EditText editText3 = (EditText)findViewById(R.id.edit_text_3);

            CheckBox checkBox1 = (CheckBox)findViewById(R.id.check_box_1);
            CheckBox checkBox2 = (CheckBox)findViewById(R.id.check_box_2);
            CheckBox checkBox3 = (CheckBox)findViewById(R.id.check_box_3);

            List<String> numbers = Arrays.asList("1", "2", "3", "*");
            Collections.shuffle(numbers);

            Toast.makeText(PracticalTest01Var06MainActivity.this,"Prepared numbers are " + numbers.get(0) + " " + numbers.get(1) + " " + numbers.get(2), Toast.LENGTH_LONG).show();

            if(!checkBox1.isChecked()){
                editText1.setText(numbers.get(0));
            }
            if(!checkBox2.isChecked()){
                editText2.setText(numbers.get(1));
            }
            if(!checkBox3.isChecked()){
                editText3.setText(numbers.get(2));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        Button playButton = (Button)findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);
    }
}