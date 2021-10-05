package mn.isolvers.cif.service.internal.service;

import lombok.RequiredArgsConstructor;
import mn.isolvers.cif.api.v1.domain.Customer;
import mn.isolvers.cif.api.v1.events.EventConstants;
import mn.isolvers.cif.service.internal.mapper.CustMapper;
import mn.isolvers.cif.service.internal.repository.CustEntityRepository;
import mn.isolvers.cif.service.internal.repository.CustomerEntity;
import mn.isolvers.common.exception.ServiceException;
import mn.isolvers.common.util.MLogger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustService {

    private final CustEntityRepository custRepository;
    private final MLogger log;

    public List<Customer> findAll() {
        log.api("In findAll ...");
        return custRepository.findAll()
                .stream()
                .map(CustMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<Customer> findById(int id) {
        log.api("In findById ...");
        return custRepository.findById(id)
                .map(CustMapper::map);
    }



    @Transactional
    public int update(Customer cust) {
        log.api("In update ...");
        custRepository.save(CustMapper.map(cust));
        return cust.getCcode();

    }

    @Transactional
    public void deleteUser(int ccode) {
        log.api("In deleteUser ...");
        final CustomerEntity user = custRepository.findById(ccode)
                .orElseThrow(() -> ServiceException.notFound(EventConstants.NOT_FOUND_CIF));
        custRepository.deleteById(ccode);
    }



}
