package sp.edu.np.mad.exercise2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle bundle = new Bundle();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ImageView imageView = findViewById(R.id.listImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Madness").setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int value = new Random().nextInt(99999999);
                        String sValue = String.valueOf(value);
                        bundle.putString("randomInt", sValue);
                        Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                        myIntent.putExtras(bundle);
                        startActivity(myIntent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("Profile");
                alert.show();
            }
        });
    }
}