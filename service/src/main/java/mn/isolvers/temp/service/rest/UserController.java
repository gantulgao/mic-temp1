package mn.isolvers.temp.service.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import mn.isolvers.temp.api.v1.domain.*;
import mn.isolvers.temp.service.internal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("info")
    public List<dbInfo> getAllInfo(){
        return userService.getAllInfo();
    }

    @GetMapping("/{userId}")
    public MResponse<User> getUserById(@PathVariable Integer userId){
        return new MResponse().body(userService.findById(userId));
    }

    @PutMapping("/{userId}")
    public MResponse<User> updateUserById(@PathVariable Integer userId, @RequestBody User user){

       return new MResponse().body(userService.updateUser(userId,user));

    }

    @DeleteMapping("/{userId}")
    public MResponse deleteUserById(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new MResponse().stat(MError.of("201","Deleted!"));
    }

    @GetMapping("/age/{age}")
    public MResponse<User> getUsersByAge(@PathVariable int age) {
        return new MResponse().body(userService.findUsersByAge(age));
    }

    @GetMapping("/collateral")
    public MResponse<List<Clients>> fetColl() throws JsonProcessingException {
        log.info("fetColl");
        return new MResponse().body(userService.callProc());
    }

}
