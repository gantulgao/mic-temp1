package mn.isolvers.cif.service.internal.service;

import lombok.RequiredArgsConstructor;
import mn.isolvers.cif.api.v1.domain.OperationType;
import mn.isolvers.cif.service.internal.mapper.CustTypeMapper;
import mn.isolvers.cif.service.internal.mapper.OpTypeMapper;
import mn.isolvers.cif.service.internal.repository.OpTypeEntity;
import mn.isolvers.cif.service.internal.repository.OpTypeRepository;
import mn.isolvers.common.exception.ServiceException;
import mn.isolvers.common.util.MLogger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpTypeService {

    private final OpTypeRepository opTypeRepository;
    private final MLogger log;

    public List<OperationType> findAll() {
        log.api("In findAll ...");
        return opTypeRepository.findAll()
                .stream()
                .map(OpTypeMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<OperationType> findById(String id) {
        log.api("In findById ...");
        return opTypeRepository.findById(id)
                .map(OpTypeMapper::map);
    }

    @Transactional
    public String updateType(OperationType optype) {
        log.api("In updateType ...");
        opTypeRepository.save(OpTypeMapper.map(optype));
        return optype.getFtype();

    }

    @Transactional
    public void deleteUser(String ftype) {
        log.api("In deleteUser ...");
        final OpTypeEntity opType = opTypeRepository.findById(ftype)
                .orElseThrow(() -> ServiceException.notFound("OperationType not found!"));
        opTypeRepository.delete(opType);
    }



}
