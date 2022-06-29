package sp.edu.np.mad.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Tag = "Main Activity";
    User user = new User("MAD","Description for MAD blah blah",1, false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView name = findViewById(R.id.Linear);
        TextView desc = findViewById(R.id.textView2);
        name.setText(user.getName());;
        desc.setText(user.getDescription());
        Button follow = findViewById(R.id.button);
        Button message = findViewById(R.id.button2);
        message.setText("Message");
        follow.setText("follow");
        Intent receivingEnd = getIntent();
        String value = receivingEnd.getStringExtra("randomInt");
        name.setText("MAD" + value);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.isFollowed() == false){
                    Toast.makeText(MainActivity.this, "followed", Toast.LENGTH_SHORT).show();
                    follow.setText("Unfollow");
                    user.setFollowed(true);

                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Unfollowed", Toast.LENGTH_SHORT).show();
                    follow.setText("Follow");
                    user.setFollowed(false);

                }
            }
        });
    }
}