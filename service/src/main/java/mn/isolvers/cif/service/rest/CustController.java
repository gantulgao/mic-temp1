package mn.isolvers.cif.service.rest;

import lombok.RequiredArgsConstructor;
import mn.isolvers.cif.api.v1.domain.Customer;
import mn.isolvers.cif.api.v1.domain.CustomerType;
import mn.isolvers.cif.api.v1.events.EventConstants;
import mn.isolvers.cif.service.internal.service.CustService;
import mn.isolvers.common.model.MError;
import mn.isolvers.common.model.MResponse;
import mn.isolvers.common.util.MLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cif")
@RequiredArgsConstructor
public class CustController {

    private final CustService custService;
    private final MLogger log;

    @GetMapping
    public List<Customer> getAllCust(){
        return custService.findAll();
    }

    @GetMapping("/{ccode}")
    public MResponse<CustomerType> getCust(@PathVariable int ccode){
        log.api("In getCust ...");

        final Optional<Customer> cust = custService.findById(ccode);
        if (cust.isPresent()) {
            return new MResponse().body(cust.get());
        }
        else {
            return new MResponse().stat(MError.of("404", EventConstants.NOT_FOUND_CIF));
        }

    }

    @GetMapping("/byreg")
    public MResponse<CustomerType> getCustByReg(@RequestParam String creg){
        log.api("In getCustByReg ...");

        final Optional<Customer> cust = custService.findByReg(creg);
        if (cust.isPresent()) {
            return new MResponse().body(cust.get());
        }
        else {
            return new MResponse().stat(MError.of("404", EventConstants.NOT_FOUND_CIF));
        }

    }

    @PostMapping
    public MResponse updateCustomer(@RequestBody Customer customer){
        if (customer.getCcode() != null)
          return new MResponse().body(custService.update(customer));
        else
          return custService.saveCustomer(customer);
    }

    @DeleteMapping("/{ccode}")
    public MResponse deleteCust(@PathVariable int ccode){
        log.api("In deleteCust ...");
        custService.deleteUser(ccode);
        return new MResponse();
    }




}
