package mn.isolvers.cif.api.v1.client;

import mn.isolvers.common.model.MResponse;
import mn.isolvers.cif.api.v1.domain.Clients;
import mn.isolvers.cif.api.v1.domain.User;
import mn.isolvers.cif.api.v1.domain.dbInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@FeignClient(name = "template", path = "/template")
public interface Temp1Client {

    @GetMapping("/v1.0/users/info")
    List<dbInfo> getAllInfo();

    @GetMapping("/v1.0/users/{userId}")
    MResponse<User> getUserById(@PathVariable Integer userId);

    @PutMapping("/v1.0/users/{userId}")
    MResponse<User> updateUserById(@PathVariable Integer userId, @RequestBody User user);

    @DeleteMapping("/v1.0/users/{userId}")
    MResponse deleteUserById(@PathVariable Integer userId);

    @GetMapping("/v1.0/users/age/{age}")
    MResponse<User> getUsersByAge(@PathVariable int age);

    @GetMapping("/v1.0/users/collateral")
    MResponse<List<Clients>> fetColl();

}
