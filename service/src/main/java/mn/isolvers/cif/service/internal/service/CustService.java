package mn.isolvers.cif.service.internal.service;

import lombok.RequiredArgsConstructor;
import mn.isolvers.cif.api.v1.domain.Customer;
import mn.isolvers.cif.api.v1.events.EventConstants;
import mn.isolvers.cif.service.internal.mapper.CustMapper;
import mn.isolvers.cif.service.internal.repository.CustEntityRepository;
import mn.isolvers.cif.service.internal.repository.CustomerEntity;
import mn.isolvers.common.exception.ServiceException;
import mn.isolvers.common.model.MError;
import mn.isolvers.common.model.MResponse;
import mn.isolvers.common.util.MLogger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustService {

    private final CustEntityRepository custRepository;
    private final MLogger log;
    private final JdbcTemplate jdbcTemplate;

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

    public Optional<Customer> findByReg(String creg){
        log.api("In findByReg ...");
        return custRepository.findByCreg(creg).map(CustMapper::map);
    }

    @Transactional
    public int update(final Customer cust) {
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

    @Transactional
    public MResponse<Customer> saveCustomer(Customer cust){
        log.api("In saveCustomer ...");

        if ( custRepository.findByCreg(cust.getCreg()).isPresent() ){
            return new MResponse().stat(MError.of("404",EventConstants.REGISTER_CONFLICT));
        }

        final int ccode;
        if (cust.getCfocus().equals("02")) {
            Optional<Integer> orgCode = custRepository.getMaxOrig();
            ccode = orgCode.map(integer -> integer + 1).orElse(1000);
        }
        else {
            Optional<Integer> cifCode = custRepository.getMaxOrig();
            ccode = cifCode.map(integer -> integer + 1).orElse(10000);
        }
        cust.setCcode(ccode);

        SimpleJdbcCall call =new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_client");
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("dom","")
                .addValue("ccode",cust.getCcode())
                .addValue("lname",cust.getCfname())
                .addValue("fname",cust.getCname())
                .addValue("rgstr",cust.getCreg())
                .addValue("pnum",cust.getCpass())
                .addValue("c_type",cust.getCtype())
                .addValue("c_focus",cust.getCfocus())
                .addValue("addr",cust.getCaddress())
                .addValue("phone",cust.getCphone())
                .addValue("c_fax",cust.getCfax())
                .addValue("c_mail",cust.getCemail())
                .addValue("u_code",cust.getCucode())

                ;

        Map<String,Object> res = call.execute(param);

//        final ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
//
//        List<Clients> customer = mapper.convertValue(res.get("#result-set-1"), new TypeReference<>(){});

        log.debug("Return:{}",res.get("return"));

        return new MResponse()
                    .stat(MError.of("201",res.get("return").toString()))
                    .body(cust);

    }


}
