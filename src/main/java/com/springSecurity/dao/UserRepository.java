package com.springSecurity.dao;

import com.springSecurity.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    HashMap<Integer, Employee> userRepository=new HashMap<>();

    public void save(Employee employee)
    {
        userRepository.put(employee.getId(),employee);
    }

    public List<Employee> findAll()
    {
        List<Employee> employees=new ArrayList<Employee>();
        for (Map.Entry mapElement : userRepository.entrySet()) {
            employees.add(((Employee)mapElement.getValue()));
        }
        return employees;
    }

    public Employee getOne(int id)
    {
        if(userRepository.containsKey(id))
        {
            return userRepository.get(id);
        }
        else
            return null;
    }
}


