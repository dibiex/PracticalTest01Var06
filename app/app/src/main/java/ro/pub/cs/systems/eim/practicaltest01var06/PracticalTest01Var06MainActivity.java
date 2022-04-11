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

    private int score= 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            EditText editText1 = (EditText)findViewById(R.id.edit_text_1);
            EditText editText2 = (EditText)findViewById(R.id.edit_text_2);
            EditText editText3 = (EditText)findViewById(R.id.edit_text_3);

            CheckBox checkBox1 = (CheckBox)findViewById(R.id.check_box_1);
            CheckBox checkBox2 = (CheckBox)findViewById(R.id.check_box_2);
            CheckBox checkBox3 = (CheckBox)findViewById(R.id.check_box_3);

            List<String> numbers = Arrays.asList("1", "2", "3", "*");

            switch(view.getId()) {
                case R.id.play_button:
                    Collections.shuffle(numbers);

                    Toast.makeText(PracticalTest01Var06MainActivity.this, "Prepared numbers are " + numbers.get(0) + " " + numbers.get(1) + " " + numbers.get(2), Toast.LENGTH_LONG).show();

                    if (!checkBox1.isChecked()) {
                        editText1.setText(numbers.get(0));
                    }
                    if (!checkBox2.isChecked()) {
                        editText2.setText(numbers.get(1));
                    }
                    if (!checkBox3.isChecked()) {
                        editText3.setText(numbers.get(2));
                    }
                    break;
                case R.id.goto_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);

                    int number1, number2, number3;

                    if(editText1.getText().toString().equals("*")){
                        number1 = 0;
                    }else{
                        number1 = Integer.parseInt(editText1.getText().toString());
                    }
                    if(editText2.getText().toString().equals("*")){
                        number2 = 0;
                    }else{
                        number2 = Integer.parseInt(editText2.getText().toString());
                    }
                    if(editText3.getText().toString().equals("*")){
                        number3 = 0;
                    }else{
                        number3 = Integer.parseInt(editText3.getText().toString());
                    }

                    intent.putExtra("numberBox1", number1);
                    intent.putExtra("numberBox2", number2);
                    intent.putExtra("numberBox3", number3);
                    int numberCheckboxes = 0;
                    if (checkBox1.isChecked()) {
                        numberCheckboxes++;
                    }
                    if (checkBox2.isChecked()) {
                        numberCheckboxes++;
                    }
                    if (checkBox3.isChecked()) {
                        numberCheckboxes++;
                    }
                    intent.putExtra("numberCheckboxes", numberCheckboxes);

                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        Button playButton = (Button)findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);
        Button secondButton = (Button)findViewById(R.id.goto_activity_button);
        secondButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            score = score + resultCode;
            Toast.makeText(this, "score is now" + score, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("score", score);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("score")) {
            score = savedInstanceState.getInt("score");
        }
    }

}