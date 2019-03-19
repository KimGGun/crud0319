package kr.hs.dgsw.projec0319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    UserService us;

    @GetMapping
    public List<User> showAll() {
        return us.showAll();
    }

    @GetMapping("/{userid}")
    public User view(@PathVariable("userid") int id) {
        return us.view(id);
    }

    @PostMapping
    public boolean post(@RequestBody User request) {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.log(Level.INFO, request.getName());

        return us.post(request.getName(), request.getEmail());
    }

    @PutMapping
    public User put(@RequestBody User user) {
        return us.put(user);
    }

    @DeleteMapping("/{userid}")
    public boolean delete(@PathVariable("userid") int id) {
        return us.delete(id);
    }

}
