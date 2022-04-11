package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    private int scor;
    private PracticalTest01Var06SecondaryActivity.ButtonClickListener buttonClickListener = new PracticalTest01Var06SecondaryActivity.ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            setResult(scor, null);
            finish();
        }
    }

            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        Button ok_button = (Button)findViewById(R.id.second_ok_button);
        ok_button.setOnClickListener(buttonClickListener);

        TextView secondText = (TextView)findViewById(R.id.second_text_view);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("numberBox1") && intent.getExtras().containsKey("numberBox2") && intent.getExtras().containsKey("numberBox3") && intent.getExtras().containsKey("numberCheckboxes")) {
            int numberBox1 = intent.getIntExtra("numberBox1", 0);
            int numberBox2 = intent.getIntExtra("numberBox2", 0);
            int numberBox3 = intent.getIntExtra("numberBox3", 0);

            Boolean gained = false;
            if(numberBox1 == numberBox2 && numberBox1 == numberBox3){
                gained = true;
            }
            if(numberBox1 == numberBox2 && numberBox3 == 0){
                gained = true;
            }
            if(numberBox3 == numberBox2 && numberBox1 == 0){
                gained = true;
            }
            if(numberBox1 == numberBox3 && numberBox2 == 0){
                gained = true;
            }
            if(numberBox2 == 0 && numberBox3 == 0){
                gained = true;
            }
            if(numberBox1 == 0 && numberBox3 == 0){
                gained = true;
            }
            if(numberBox1 == 0 && numberBox2 == 0){
                gained = true;
            }

            int numberCheckboxes = intent.getIntExtra("numberCheckboxes", 0);

            scor = 0;
            if(numberCheckboxes == 0){
                scor = 100;
            }
            if(numberCheckboxes == 1){
                scor = 50;
            }
            if(numberCheckboxes == 3){
                scor = 10;
            }


            if(gained) {
                secondText.setText("Gained" + String.valueOf(scor));
            }
            else{
                secondText.setText(String.valueOf(scor));
            }
        }
    }
}