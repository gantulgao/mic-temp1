package mn.isolvers.temp.service.internal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int age;
    private double salary;

    public User(String name,int age,double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
