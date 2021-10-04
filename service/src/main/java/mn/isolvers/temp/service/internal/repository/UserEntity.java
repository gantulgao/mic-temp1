package mn.isolvers.temp.service.internal.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private Integer id;
    private String name;
    private int age;
    private double salary;

    public UserEntity(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

}
