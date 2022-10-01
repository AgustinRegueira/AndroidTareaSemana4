package edu.utec.tareasemana4.room.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.utec.tareasemana4.room.entities.User;
import edu.utec.tareasemana4.room.repositories.UsersRoomRepository;

public class UsersRoomViewModel extends AndroidViewModel {

    private UsersRoomRepository usersRepository;
    private final LiveData<List<User>> users;

    public UsersRoomViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRoomRepository(application);
        users = usersRepository.getUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void insert(User user) {
        usersRepository.insert(user);
    }

    public void update(User user) {
        usersRepository.update(user);
    }

    public void delete(User user) {
        usersRepository.delete(user);
    }

    public void deleteAll() {
        usersRepository.deleteAll();
    }
}
