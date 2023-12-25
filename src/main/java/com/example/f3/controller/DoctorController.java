package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.DoctorInfo;
import com.example.f3.entity.R;
import com.example.f3.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

//    @PostMapping("/add/{address}")
    @PostMapping({"/add/{address}", "/add"})
    public R add(@PathVariable(required = false) String address,@RequestBody DoctorInfo doctorInfo) throws Exception {
        log.info("{}",doctorInfo);
        doctorService.addDoctor(address, doctorInfo);
        return R.success();
    }
    @PutMapping({"/update/{address}", "/update"})
    public R update(@PathVariable(required = false) String address,@RequestBody DoctorInfo doctorInfo) throws Exception {
        doctorService.updateDoctor(address,doctorInfo);
        return R.success();
    }
    @GetMapping
    public R<HospitalCases.Struct0> query(String address) throws Exception {
        HospitalCases.Struct0 doctorInfo = doctorService.query(address);
        return R.success(doctorInfo);
    }
    @DeleteMapping("/{addr}")
    public R del(@PathVariable String addr) throws Exception {
        doctorService.del(addr);
        return R.success();
    }

//    @GetMapping("/{address}")
//    public R<DoctorInfo> query(@PathVariable String address) throws ContractException {
//        DoctorInfo doctorInfo = doctorService.query(address);
//        return R.success(doctorInfo);
//    }

}
