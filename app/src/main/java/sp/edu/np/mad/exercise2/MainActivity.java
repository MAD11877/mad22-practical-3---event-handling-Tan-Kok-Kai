package sp.edu.np.mad.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String Tag = "Main Activity";
    User user = new User("MAD","Description for MAD blah blah",1, false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivingEnd = getIntent();
        String value = receivingEnd.getStringExtra("randomInt");
        setContentView(R.layout.activity_main);
        TextView name = findViewById(R.id.textView);
        TextView desc = findViewById(R.id.textView2);
        name.setText(user.getName() + " " + value);
        desc.setText(user.getDescription());
        Button follow = findViewById(R.id.button);
        Button message = findViewById(R.id.button2);
        message.setText("Message");
        follow.setText("follow");
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.isFollowed() == false){
                    follow.setText("Unfollow");
                    user.setFollowed(true);
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                else{
                    follow.setText("Follow");
                    user.setFollowed(false);
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();

                }
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageIntent);
            }
        });
    }
}