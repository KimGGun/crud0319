package kr.hs.dgsw.projec0319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<>();
    private int idc = 0;


    public UserServiceImpl() {
        users.add(new User(idc++,"김건","rlrjs1234"));
        users.add(new User(idc++,"김건모","rlarjsah1234"));
        users.add(new User(idc++,"왕건","dhkdrjs1234"));
    }

    @Override
    public List<User> showAll() {
        return users;
    }

    @Override
    public User view(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean post(String name, String email) {
        User user = new User(idc++,name,email);
        User found = users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findAny()
                .orElse(null);

        if(found == null){
            users.add(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        User found = view(id);
        if(found != null) {
            users.remove(found);
            return true;
        }
        return false;
    }

    @Override
    public User put(User user) {
        User found = view(user.getId());
        if(found != null){
            found.setName(user.getName());
            found.setEmail(user.getEmail());
            return found;
        }
        return null;
    }
}
