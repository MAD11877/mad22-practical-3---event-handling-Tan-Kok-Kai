package sp.edu.np.mad.exercise2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<User> userList = new ArrayList<>();
        setContentView(R.layout.activity_list);
        RecyclerView imageClick = findViewById(R.id.imageClick);
        for (int i = 0; i < 20; i++){
            User forUser = new User("Name" + randomOTP(), "Description " +
                    randomOTP(), i, false);
            userList.add(forUser);
        }
        myAdaptor mAdaptor = new myAdaptor(userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        imageClick.setLayoutManager(mLayoutManager);
        imageClick.setAdapter(mAdaptor);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999);
        return value;
    }
}