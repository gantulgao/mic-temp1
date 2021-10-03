package mn.isolvers.temp.service.internal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.isolvers.temp.service.internal.model.Clients;
import mn.isolvers.temp.service.internal.model.Department;
import mn.isolvers.temp.service.internal.model.User;
import mn.isolvers.temp.service.internal.model.dbInfo;
import mn.isolvers.temp.service.internal.repository.DepartmentRepository;
import mn.isolvers.temp.service.internal.repository.InfoRepository;
import mn.isolvers.temp.service.internal.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final InfoRepository infoRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Iterable<dbInfo> getAllInfo(){
        return infoRepository.findAll();
    }

    public User findById(Integer userId){
        return //userRepository.findById(userId)
                userRepository.getUser(userId)
                ;
    }

    public User updateUser(Integer userId, User user){
        log.info("In updateUser ...");

        return userRepository.findById(userId)
               .orElse(new User());

    }

    public void deleteUser(Integer userId){
        userRepository.findById(userId)
                .ifPresent(user->userRepository.delete(user))

                ;
    }

    public User findUsersByAge(int age){
        Optional<User> user = userRepository.findByAge(age);
        if (user.isPresent()) return user.get();
        return new User();
    }

    private Department getDepartmentByUserId(Integer userId){
        return departmentRepository.findByUserId(userId);
    }

    private final JdbcTemplate jdbcTemplate;

    public List<Clients> callProc() throws JsonProcessingException {
        log.info("Executing ...");
        int ret = 0;

        SimpleJdbcCall call =new SimpleJdbcCall(jdbcTemplate)
                                .withProcedureName("_sp_view_capital");

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("filter","")
                .addValue("return",0);

        Map<String,Object> res = call.execute(param);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);

        List<Clients> clients = mapper.convertValue(res.get("#result-set-1"), new TypeReference<>(){});

        log.info("Return:{}",res.get("return"));

        return clients;

//        List<Clients> res = clientRepository.getCol("",ret);
//
//        log.info("Ret:{}",ret);
//
//        return res;

//        return databaseClient.sql("exec _sp_view_capital @filter, @ret output")
//                .bind("filter","")
//                .bind("ret",)
//               .fetch().all()
//
//               .doOnError(e->log.error("Cannot!",e));

//        SimpleJdbcCall call = new SimpleJdbcCall()
//                                .withProcedureName("_sp_view_capital");

//        SqlParameterSource params = new MapSqlParameterSource()
//                .addValue("GID","aaa")
//                .addValue("Account","aaaa")
//                ;

//        return call.execute();

    }

}
