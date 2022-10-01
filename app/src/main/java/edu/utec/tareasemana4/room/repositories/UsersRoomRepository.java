package edu.utec.tareasemana4.room.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.utec.tareasemana4.domain.entities.UserDto;
import edu.utec.tareasemana4.room.dao.UsersDao;
import edu.utec.tareasemana4.room.database.AppDatabase;
import edu.utec.tareasemana4.room.entities.User;

public class UsersRoomRepository {
    private UsersDao usersDao;

    private LiveData<List<User>> users;

    public UsersRoomRepository(Application app) {
        AppDatabase db = AppDatabase.getInstance(app);
        usersDao = db.usersDao();
        users = usersDao.getAll();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void insert(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usersDao.insert(user);
        });
    }

    public void update(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usersDao.update(user);
        });
    }

    public void delete(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usersDao.delete(user);
        });
    }

    public void deleteAll() {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usersDao.deleteAll();
        });
    }
}
