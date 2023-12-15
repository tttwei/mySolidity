// SPDX-License-Identifier: MIT
pragma solidity ^0.6.0;
pragma experimental ABIEncoderV2;

import "./Patient.sol";
import "./Doctor.sol";



contract hospital is Patient,Doctor{
   

        struct Cases{
            //病历id
            uint id;
            // 医生
            DoctorInfo doctor;
            // 患者
            PatientInfo patient;
            // 问诊类型
            string appointmentType;
            // 问诊时间
            string appointmentTime;
            // 病情描述
            string description;
            // 处方
            string prescription;
            // 需支付费用
            uint money;

        }
    mapping (uint => Cases) public cases;
    uint indexId=0;

    

    // event MyEvent(string,uint ,uint , string);
    // event info(string);
    
    // 添加病历
    function addCases(
        address _patient,
        string memory _appointmentType,
        string memory _appointmentTime,
        string memory _description,
        string memory _prescription,
        uint _money
    ) public onlyDoctor {
        indexId++;
        cases[indexId].id=indexId;
        cases[indexId].doctor=doctorMap[msg.sender];
        cases[indexId].patient=patientMap[_patient];
        cases[indexId].appointmentType=_appointmentType;
        cases[indexId].appointmentTime=_appointmentTime;
        cases[indexId].description=_description;
        cases[indexId].prescription=_prescription;
        cases[indexId].money=_money;
    }

    // 查询病例
    function queryCases(uint _id) public view onlyDoctor returns (Cases memory) {  
        return cases[_id];
    }

    
}