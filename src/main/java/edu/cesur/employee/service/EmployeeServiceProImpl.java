package edu.cesur.employee.service;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.cesur.employee.model.Employee;

import edu.cesur.fullstack.services.PersonaService;
@Lazy
@Service("pro")
public class EmployeeServiceProImpl implements EmployeeService{
	ArrayList<Employee> listaEmployeePro = new ArrayList<>(
			Arrays.asList(new Employee(1, "Miriam", "Miriam@gmail.com", "EMP-dep-1234"),
					new Employee(2, "Mireia", "mireia@gmail.com","EMP-inf-1289"),
					new Employee(3, "Javier", "javier@gmail.com", "EMP-dep-1234"),
					new Employee(4, "Marcos", "marcor@gmail.com", "EMP-dep-1234")));

	
	public ArrayList<Employee> getAllEmployee() {
		return listaEmployeePro;
	}
}
