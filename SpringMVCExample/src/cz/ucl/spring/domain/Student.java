package cz.ucl.spring.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Student {
	@NotNull
	@Min(18)
	private Integer age;
	
	@NotEmpty
    private String name;
	
	@NotNull
    private Integer id;

    public void setAge(Integer age) {
       this.age = age;
    }
    public Integer getAge() {
       return age;
    }
    public void setName(String name) {
       this.name = name;
    }
    public String getName() {
       return name;
    }
    public void setId(Integer id) {
       this.id = id;
    }
    public Integer getId() {
       return id;
    }
}