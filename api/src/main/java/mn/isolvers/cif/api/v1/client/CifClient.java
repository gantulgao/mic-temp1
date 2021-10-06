package mn.isolvers.cif.api.v1.client;

import mn.isolvers.cif.api.v1.domain.Customer;
import mn.isolvers.cif.api.v1.domain.CustomerType;
import mn.isolvers.cif.api.v1.domain.OperationType;
import mn.isolvers.common.model.MResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@FeignClient(name = "customer", path = "/customemr/v1.0")
public interface CifClient {

    @GetMapping("/cif")
    List<Customer> getAllCust();

    @GetMapping("/cif/{ccode}")
    MResponse<CustomerType> getCust(@PathVariable int ccode);

    @GetMapping("/cif/byreg")
    MResponse<CustomerType> getCustByReg(@RequestParam String creg);

    @PostMapping("/cif")
    MResponse updateCustomer(@RequestBody Customer customer);

    @DeleteMapping("/cif/{ccode}")
    MResponse deleteCust(@PathVariable int ccode);

    @GetMapping("/ciftype")
    List<CustomerType> getAllCustType();

    @GetMapping("/ciftype/{ctype}")
    MResponse<CustomerType> getCustType(@PathVariable String ctype);

    @PostMapping("/ciftype")
    MResponse saveCType(@RequestBody CustomerType customerType);

    @DeleteMapping("/ciftype/{ctype}")
    MResponse deleteCustTyp(@PathVariable String ctype);

    @GetMapping("/optype")
    List<OperationType> getAllOpType();

    @GetMapping("/optype/{ftype}")
    MResponse<CustomerType> getOpType(@PathVariable String ftype);

    @PostMapping("/optype")
    MResponse saveOpType(@RequestBody OperationType operationType);

    @DeleteMapping("/optype/{ftype}")
    MResponse deleteOpTyp(@PathVariable String ftype);


}
