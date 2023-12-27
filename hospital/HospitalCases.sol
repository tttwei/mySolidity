// SPDX-License-Identifier: MIT
pragma solidity ^0.4.25;
pragma experimental ABIEncoderV2;

import "./Patient.sol";
import "./Doctor.sol";

contract HospitalCases {
   constructor (address doctor,address patient) public {
        d = Doctor(doctor);
        p = Patient(patient);
    }

    Patient p;
    Doctor d;

        struct Cases{
            //病历id
            uint id;
            // 医生
            Doctor.DoctorInfo doctor;
            // 患者
            Patient.PatientInfo patient;
            // 问诊类型
            string appointmentType;
            // 问诊时间
            string appointmentTime;
            // 病情描述
            string description;
            // 处方
            string prescription;
            // 需支付费用
            string money;

        }
    mapping (address => Cases[]) public cases;
    uint indexId=0;

    // 添加病历
    function addCases(
        address _patient,
        string memory _appointmentType,
        string memory _appointmentTime,
        string memory _description,
        string memory _prescription,
        string memory _money) public {
        indexId++;

        Cases memory c = Cases(indexId,d.queryDoctor(),p.queryPatient(),_appointmentType,_appointmentTime,_description,_prescription,_money);
        cases[_patient].push(c);       
    }

    // 查询病例
    function queryCases(address addr) public view  returns (Cases[] memory) {  
        return cases[addr];
    }   
}