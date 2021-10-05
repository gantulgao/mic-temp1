package mn.isolvers.cif.service.internal.service;

import lombok.RequiredArgsConstructor;
import mn.isolvers.cif.api.v1.domain.*;
import mn.isolvers.cif.service.internal.mapper.CustTypeMapper;
import mn.isolvers.cif.service.internal.repository.*;
import mn.isolvers.common.exception.ServiceException;
import mn.isolvers.common.util.MLogger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustTypeService {

    private final CustTypeRepository custTypeRepository;
    private final MLogger log;

    public List<CustomerType> findAll() {
        log.api("In findAll ...");
        return custTypeRepository.findAll()
                .stream()
                .map(CustTypeMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<CustomerType> findById(String id) {
        log.api("In findById ...");
        return custTypeRepository.findById(id)
                .map(CustTypeMapper::map);
    }

    @Transactional
    public String updateType(CustomerType custType) {
        log.api("In updateType ...");
        custTypeRepository.save(CustTypeMapper.map(custType));
        return custType.getCtype();

    }

    @Transactional
    public void deleteUser(String cType) {
        log.api("In deleteUser ...");
        final CustomerTypeEntity user = custTypeRepository.findById(cType)
                .orElseThrow(() -> ServiceException.notFound("CustomerType not found!"));
        custTypeRepository.deleteById(cType);
    }


}
