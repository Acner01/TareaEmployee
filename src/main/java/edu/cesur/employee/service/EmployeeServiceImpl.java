package edu.cesur.employee.service;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.cesur.employee.model.Employee;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("generales")
@Primary
public class EmployeeServiceImpl implements EmployeeService{
	
	ArrayList<Employee> listaEmployee = new ArrayList<>(
			Arrays.asList(new Employee(1, "Juan", "Juan1@gmail.com", "EMP-dep-1234"), new Employee(2, "María", "Maria1@gmail.com", "EMP-inf-1234"),
			new Employee(3, "Pedro", "Pedro5@gmail.com", "EMP-rhh-1234"), new Employee(4, "Anna", "anna01@gmail.com", "EMP-dep-7895")));

	
	public EmployeeServiceImpl() {
	//	log.info("Creado bean PersonaServiceImpl");
	}
	
	
	public ArrayList<Employee> getAllEmployee() {
		return listaEmployee;
	}
}
