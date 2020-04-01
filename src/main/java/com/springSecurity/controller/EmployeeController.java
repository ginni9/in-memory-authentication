package com.springSecurity.controller;

import com.springSecurity.model.Employee;
import com.springSecurity.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class EmployeeController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value="/addEmp",method = RequestMethod.POST)
    public String addEmployee(@RequestBody Employee emp)
    {
        userRepository.save(emp);
        return "Success";
    }

    @ResponseBody
    @RequestMapping(value="/findEmp")
    public List<Employee> FindAllEmployee()
    {
       return userRepository.findAll();

    }

    @ResponseBody
    @RequestMapping(value="/findByID/{id}")
    public Employee getUserById(@PathVariable int id) {
        return userRepository.getOne(id);
    }

}


