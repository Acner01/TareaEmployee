package edu.cesur.employee.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.employee.model.Employee;
import edu.cesur.employee.service.EmployeeService;
import edu.cesur.employee.services.validators.OnCreateEmpl;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/employee")
public class EmployeeRestControllers {

    ArrayList<Employee> listaEmployee = new ArrayList<>(
        Arrays.asList(new Employee(1, "Juan", "Juan1@gmail.com", "EMP-dep-1234"),
                      new Employee(2, "María", "Maria1@gmail.com", "EMP-inf-1234"),
                      new Employee(3, "Pedro", "Pedro5@gmail.com", "EMP-rhh-1234"),
                      new Employee(4, "Anna", "anna01@gmail.com", "EMP-dep-7895")));

    EmployeeService employeeService;

    @Autowired
    public EmployeeRestControllers(@Qualifier("generales") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getEmployee() {
        ArrayList<Employee> listaEmployee = employeeService.getAllEmployee();
        return ResponseEntity.ok(listaEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        if (id < 0) {
            return ResponseEntity.badRequest().build();
        }

        for (Employee e : listaEmployee) {
            if (e.getId() == id) {
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee empleado) {
        listaEmployee.add(empleado);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empleado.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        if (id < 0) {
            return ResponseEntity.badRequest().build();
        }

        for (Employee p : new ArrayList<>(listaEmployee)) {
            if (p.getId() == id) {
                listaEmployee.remove(p);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee empleado) {
        for (Employee p : listaEmployee) {
            if (p.getId() == empleado.getId()) {
                p.setName(empleado.getName());
                p.setEmail(empleado.getEmail());
                p.setEmployeeCode(empleado.getEmployeeCode());
                return ResponseEntity.ok(p);
            }
        }

        return ResponseEntity.notFound().build();
    }
}