// SPDX-License-Identifier: MIT
pragma solidity ^0.6.0;
pragma experimental ABIEncoderV2;

import "./Base.sol";

contract Doctor is Base{
     modifier onlyDoctor{
         require(doctorMap[msg.sender].person.theType==personType.doctor,"only Doctor");
        _;
    }

    struct DoctorInfo {
        PersonInfo person;
        // uint workTime;  
    }

    mapping (address => DoctorInfo) public doctorMap;
    
    // 注册
    function addDoctor(DoctorInfo memory d) public {
        string memory str = doctorMap[msg.sender].person.name;
        require(keccak256(abi.encodePacked(str)) == keccak256(""),"user has exist");
        doctorMap[msg.sender]=d;
    }

    // 修改
    function updateDoctor(DoctorInfo memory d) public {
        string memory str = doctorMap[msg.sender].person.name;
        require(keccak256(abi.encodePacked(str)) != keccak256(""),"user not exist");
       doctorMap[msg.sender]=d;
        
    }

    // 查询
    function queryDoctor(address addr) public view returns (DoctorInfo memory){
        return doctorMap[addr];
    }

}