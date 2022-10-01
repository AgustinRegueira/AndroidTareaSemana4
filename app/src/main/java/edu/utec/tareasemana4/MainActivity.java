package edu.utec.tareasemana4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.stream.Collectors;

import edu.utec.tareasemana4.domain.entities.UserDto;
import edu.utec.tareasemana4.room.entities.User;
import edu.utec.tareasemana4.room.model.UsersRoomViewModel;

public class MainActivity extends AppCompatActivity {

    private UsersRoomViewModel usersViewModel;
    public static final int NEW_USER_REQ_CODE = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewUsuarios);
        final UserListAdapter adapter = new UserListAdapter(new UserListAdapter.UserDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        usersViewModel = new UsersRoomViewModel(getApplication());
        usersViewModel.getUsers().observe(this, users -> {
            if(users == null) {
                users = new ArrayList<>();
            }
            adapter.submitList(users.stream().map(User::buildUserDto).collect(Collectors.toList()));
        });

        adapter.setListener(new UserListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(UserDto user) {
                Intent intent = new Intent(MainActivity.this, ShowUserActivity.class);
                intent.putExtra("NOMBRE", user.getNombre());
                intent.putExtra("APELLIDO", user.getApellido());
                intent.putExtra("ROL", user.getTipoUsuario());
                intent.putExtra("FECHA", user.getFechaRegistro());
                startActivity(intent);
            }
        });

        FloatingActionButton btnAdd = findViewById(R.id.btnAgregar);
        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivityForResult(intent, NEW_USER_REQ_CODE);
        });

        FloatingActionButton btnDelete = findViewById(R.id.btnEliminarTodo);
        btnDelete.setOnClickListener(view -> {
            usersViewModel.deleteAll();
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_USER_REQ_CODE && resultCode == RESULT_OK) {
            UserDto user = new UserDto();
            user.setNombre(data.getStringExtra("NOMBRE"));
            user.setApellido(data.getStringExtra("APELLIDO"));
            user.setTipoUsuario(data.getStringExtra("ROL"));
            user.setFechaRegistro(data.getStringExtra("FECHA"));

            usersViewModel.insert(user.buildUser());
        } else if (resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(), "Error en la creación del nuevo usuario", Toast.LENGTH_LONG).show();
        }
    }
}