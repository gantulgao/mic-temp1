package mn.isolvers.cif.service.rest;

import lombok.RequiredArgsConstructor;
import mn.isolvers.cif.api.v1.domain.CustomerType;
import mn.isolvers.cif.api.v1.domain.OperationType;
import mn.isolvers.cif.service.internal.service.CustTypeService;
import mn.isolvers.cif.service.internal.service.OpTypeService;
import mn.isolvers.common.model.MError;
import mn.isolvers.common.model.MResponse;
import mn.isolvers.common.util.MLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1.0/optype")
@RequiredArgsConstructor
public class OpTypeController {

    private final OpTypeService opTypeService;
    private final MLogger log;

    @GetMapping
    public List<OperationType> getAllOpType(){
        return opTypeService.findAll();
    }

    @GetMapping("/{ftype}")
    public MResponse<CustomerType> getOpType(@PathVariable String ftype){
        log.api("In getOpType ...");

        final Optional<OperationType> opType = opTypeService.findById(ftype);
        if (opType.isPresent()) {
            return new MResponse().body(opType.get());
        }
        else {
            return new MResponse().stat(MError.of("404","CustTyp not found!"));
        }

    }

    @PostMapping
    public MResponse saveOpType(@RequestBody OperationType operationType){
        return new MResponse().body(opTypeService.updateType(operationType));
    }

    @DeleteMapping("/{ftype}")
    public MResponse deleteOpTyp(@PathVariable String ftype){
        log.api("In deleteOpTyp ...");
        opTypeService.deleteUser(ftype);
        return new MResponse();
    }



}
