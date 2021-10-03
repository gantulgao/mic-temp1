package mn.isolvers.temp.service.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import mn.isolvers.temp.api.v1.domain.MResponse;
import mn.isolvers.temp.api.v1.domain.UserDepartmentDTO;
import mn.isolvers.temp.service.internal.model.Clients;
import mn.isolvers.temp.service.internal.model.User;
import mn.isolvers.temp.service.internal.model.dbInfo;
import mn.isolvers.temp.service.internal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("info")
    public Iterable<dbInfo> getAllInfo(){
        return userService.getAllInfo();
    }

    @GetMapping("/{userId}")
    public MResponse<User> getUserById(@PathVariable Integer userId){
        User user = userService.findById(userId);
        final MResponse<User> res = MResponse.of();
         res.body(user);
        return res;
    }

    @PutMapping("/{userId}")
    public MResponse<User> updateUserById(@PathVariable Integer userId, @RequestBody User user){
        User res = userService.updateUser(userId,user);

        MResponse<User> response = MResponse.of();

        response.setBody(res);

        return response;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUserById(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/age/{age}")
    public User getUsersByAge(@PathVariable int age) {
        return userService.findUsersByAge(age);
    }

    @GetMapping("/collateral")
    public List<Clients> fetColl() throws JsonProcessingException {
        log.info("fetColl");
        return userService.callProc();
    }

}
