package com.nagarro.hr.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.hr.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	private String url = "http://localhost:8081/employees";

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		String result = restTemplate.getForObject(url, String.class);
		List<Employee> employees = null;
		try {
			employees = (List<Employee>) mapper.readValue(result,
					mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employees;

	}

	@Override
	public Employee getEmployee(int empCode) {

		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(url + "/{id}", Employee.class, empCode);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee, int id) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url + "/{id}", employee, id);

	}

}
