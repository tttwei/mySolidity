// SPDX-License-Identifier: MIT
pragma solidity ^0.6.0;
pragma experimental ABIEncoderV2;

import "./Base.sol";
contract Patient is Base {
     modifier onlyPatient{
         require(patientMap[msg.sender].person.theType==personType.patient,"only patient");
        _;
    }

    struct PatientInfo{
        PersonInfo person;
        string dataBirth;
    }

    mapping (address => PatientInfo) public patientMap;
    
    

    // 注册
    function addPatient(PatientInfo memory p) public {
         string memory str = patientMap[msg.sender].person.name;
        require(keccak256(abi.encodePacked(str)) == keccak256(""),"user has exist");
        patientMap[msg.sender]=p;
        // patientMap[msg.sender].person.own=msg.sender;
    }

    // 修改
    function updatePatient(PatientInfo memory p) public {
        string memory str = patientMap[msg.sender].person.name;
        require(keccak256(abi.encodePacked(str)) != keccak256(""),"user has exist");
        patientMap[msg.sender]=p;
    }

    // 查询
    function queryPatient(address addr) public view returns (PatientInfo memory){
        return patientMap[addr];
    }

    // function hhh()public pure   returns(uint ){
    //     return 19;
    // }   


}