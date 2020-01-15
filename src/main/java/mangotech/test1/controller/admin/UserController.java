package mangotech.test1.controller.admin;

import mangotech.test1.entity.User;
import mangotech.test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Hung Hoang
 * @version 1.0
 * @to
 */
@RestController
@RequestMapping(path = "/api/v1/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> listUser(){
        return userService.findAll();
    }

    @GetMapping("/user")
    public User getUserById(@PathVariable(name = "id") Integer id){
        return userService.findById(id).get();
    }

    @DeleteMapping("/users")
    public ResponseEntity delete(@PathVariable(name = "id") Integer id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    public ResponseEntity add(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }
}
