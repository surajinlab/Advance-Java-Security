package com.secure.advance.controller;

import com.secure.advance.model.Emp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class Employee {
    private List<Emp> emps = new ArrayList<>(List.of(
            new Emp(1, "Gojo", 30000),
            new Emp(2, "Geto", 24000)
    ));

    @GetMapping("/home")
    public String greeting(HttpServletRequest request) {
        return "Welcome to My Project : " + request.getSession().getId() ;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/emps")
    public List<Emp> getEmps() {
        return emps;
    }

    @PostMapping("/emp")
    public Emp addEmp(@RequestBody Emp emp) {
        emps.add(emp);
        return emp;
    }
}
