package com.example.roomwithjavarx.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomwithjavarx.R;
import com.example.roomwithjavarx.room.User;
import com.example.roomwithjavarx.recycle_adapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements mainContract.viewInterface {

    @BindView(R.id.username_id)
    EditText usernameId;
    @BindView(R.id.phone_id)
    EditText phoneId;
    @BindView(R.id.add_btn)
    Button addBtn;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    private mainContract.presnterInterface presnterInterface;
    private recycle_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presnterInterface = new mainPresenter(this, this);
        presnterInterface.getUsers();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameId.getText().toString();
                String phone = phoneId.getText().toString();

                User user = new User(username, phone);
                presnterInterface.saveUser(user);
            }
        });

    }

    @Override
    public void setUsers(List<User> users) {
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        if (users.size() == 0) {

        } else {
            adapter = new recycle_adapter(users);
            recycleView.setAdapter(adapter);
        }
    }

}