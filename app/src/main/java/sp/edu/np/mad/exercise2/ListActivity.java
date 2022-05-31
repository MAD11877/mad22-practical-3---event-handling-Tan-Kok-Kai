package sp.edu.np.mad.exercise2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView imageClick = findViewById(R.id.imageClick);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        imageClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("MADness").setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String value = String.valueOf(randomOTP());
                        Bundle extras = new Bundle();
                        extras.putString("randomInt", value);
                        Intent intentList = new Intent(ListActivity.this, MainActivity.class);
                        intentList.putExtras(extras);
                        startActivity(intentList);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.show();
            }
        });
    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999);
        return value;
    }
}