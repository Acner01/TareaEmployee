package edu.cesur.employee.model;


import edu.cesur.employee.services.validators.CustomValidation;
import edu.cesur.employee.services.validators.OnCreateEmpl;
import edu.cesur.employee.services.validators.OnUpdateEmpl;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
	@Positive
	private  int id;
	@NotNull 
	private String name;
	@NotBlank (groups = OnCreateEmpl.class)
	@Email
	private String email;
	@CustomValidation
	private String employeeCode;

	public Employee(int id, String name, String email, String employeeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeCode = employeeCode;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", employeeCode=" + employeeCode + "]";
	}

	
}
