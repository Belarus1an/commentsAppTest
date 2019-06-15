package pl.akademiakodu.TestakademiaKoduORM;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    default List<User> fainUserByName(Iterable<User> allUsers, String name){

        List<User> newUserList = new ArrayList<>();

        for (User user: allUsers){
            if (user.getName().equals(name)){
                newUserList.add(user);
            }
        }
        return newUserList;
    }
}
