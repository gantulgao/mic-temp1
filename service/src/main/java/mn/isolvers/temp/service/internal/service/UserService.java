package mn.isolvers.temp.service.internal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.isolvers.common.exception.ServiceException;
import mn.isolvers.temp.api.v1.domain.Clients;
import mn.isolvers.temp.api.v1.domain.Department;
import mn.isolvers.temp.api.v1.domain.User;
import mn.isolvers.temp.api.v1.domain.dbInfo;
import mn.isolvers.temp.service.internal.mapper.UserMapper;
import mn.isolvers.temp.service.internal.mapper.dbInfoMapper;
import mn.isolvers.temp.service.internal.repository.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final InfoRepository infoRepository;

    public User createUser(User user){
        return UserMapper.map(userRepository.save(UserMapper.map(user)))

                ;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    public List<dbInfo> getAllInfo(){
        return infoRepository.findAll()
                .stream().map(dbInfoMapper::map).collect(Collectors.toList());
    }

    public User findById(Integer userId){
        return
                userRepository.getUser(userId)
                ;
    }

    public Optional<User> updateUser(Integer userId, User user){
        log.info("In updateUser ...");
        return userRepository.findById(userId)
                .map(UserMapper::map);

    }

    public void deleteUser(Integer userId){

       final UserEntity user = userRepository.findById(userId)
                .orElseThrow(()-> ServiceException.notFound("User not found!"));

        userRepository.delete(user);

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

    }

}
