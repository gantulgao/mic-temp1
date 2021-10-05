package mn.isolvers.cif.service.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.isolvers.cif.api.v1.domain.Clients;
import mn.isolvers.cif.api.v1.domain.Customer;
import mn.isolvers.cif.api.v1.domain.User;
import mn.isolvers.cif.api.v1.domain.dbInfo;
import mn.isolvers.cif.service.internal.service.UserService;
import mn.isolvers.common.model.MError;
import mn.isolvers.common.model.MResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1.0/cif")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final UserService userService;
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.findAll();
    }

    @GetMapping
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
