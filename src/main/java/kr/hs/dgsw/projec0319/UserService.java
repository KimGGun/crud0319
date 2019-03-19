package kr.hs.dgsw.projec0319;

import java.util.List;

public interface UserService {
    List<User> showAll();
    User view(int id);
    boolean post(String name, String email);
    boolean delete(int id);
    User put(User user);
}
