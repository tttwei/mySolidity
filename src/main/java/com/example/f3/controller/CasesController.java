package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Cases;
import com.example.f3.entity.R;
import com.example.f3.service.CasesService;
import com.example.f3.service.Impl.CasesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CasesController{
    @Autowired
    private CasesService casesService;
    @PostMapping("/addCases")
    public R<String> add(@RequestBody Cases cases) throws Exception {
        String s = casesService.addCases(cases);
        return R.success(s);
    }
    @GetMapping
    public R<List<HospitalCases.Struct2>> query(String address) throws Exception {
        List<HospitalCases.Struct2> list = casesService.query(address);
        return R.success(list);
    }
}
