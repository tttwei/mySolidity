package com.example.f3.controller;

import com.example.f3.entity.Cases;
import com.example.f3.entity.R;
import com.example.f3.service.Impl.CasesServiceImpl;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cases")
public class CasesController {
    @Autowired
    private CasesServiceImpl casesService;
    @PostMapping
    public R add(@RequestBody Cases cases) throws Exception {
        casesService.addCases(cases);
        return R.success(cases);
    }
    @GetMapping
    public R query(String address) throws ContractException {
        return null;
    }
}
