package mangotech.test1.api.admin;

import mangotech.test1.config.Const;
import mangotech.test1.dto.UserDto;
import mangotech.test1.payload.ApiResponse;
import mangotech.test1.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hung Hoang
 * @version 1.0
 */
@RestController
@RequestMapping(path = "/api/v1/admin")
public class UserApi {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ApiResponse listUser(){
        return new ApiResponse(HttpStatus.OK.value(), Const.SUCCESS_MESSAGE, userService.findAll());
    }

    @GetMapping("/user/{id}")
    public ApiResponse getUserById(@PathVariable(name = "id") Integer id){
        return new ApiResponse(HttpStatus.OK.value(), Const.SUCCESS_MESSAGE, userService.findById(id));
    }

    @DeleteMapping("/user/{id}")
    public ApiResponse delete(@PathVariable(name = "id") Integer id){
        userService.deleteById(id);
        return new ApiResponse(HttpStatus.OK.value(), Const.SUCCESS_MESSAGE, Const.SUCCESS_MESSAGE);
    }

    @PostMapping("/users")
    public ApiResponse add(@RequestBody UserDto user){
        return new ApiResponse(HttpStatus.OK.value(), Const.SUCCESS_MESSAGE, userService.save(user));
    }
}
