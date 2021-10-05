package mn.isolvers.cif.service.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.isolvers.cif.api.v1.domain.*;
import mn.isolvers.cif.service.internal.service.CustTypeService;
import mn.isolvers.common.model.MError;
import mn.isolvers.common.model.MResponse;
import mn.isolvers.common.util.MLogger;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciftype")
@RequiredArgsConstructor
public class CustomerTypeController {

    private final CustTypeService custTypeService;
    private final MLogger log;

    @GetMapping
    public List<CustomerType> getAllCustType(){
        return custTypeService.findAll();
    }

    @GetMapping("/{ctype}")
    public MResponse<CustomerType> getCustType(@PathVariable String ctype){
        log.api("In getCustType ...");

        final Optional<CustomerType> custType = custTypeService.findById(ctype);
        if (custType.isPresent()) {
            return new MResponse().body(custType.get());
        }
        else {
            return new MResponse().stat(MError.of("404","CustTyp not found!"));
        }

    }

    @PostMapping
    public MResponse saveCType(@RequestBody CustomerType customerType){
        return new MResponse().body(custTypeService.updateType(customerType));
    }

    @DeleteMapping("/{ctype}")
    public MResponse deleteCustTyp(@PathVariable String ctype){
        log.api("In deleteCustTyp ...");
        custTypeService.deleteUser(ctype);
        return new MResponse();
    }



}
