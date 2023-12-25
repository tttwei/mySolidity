// SPDX-License-Identifier: MIT
pragma solidity ^0.4.25;
pragma experimental ABIEncoderV2;

import "./Base.sol";

contract Doctor is Base{
    

    struct DoctorInfo {
        // 姓名
        string name;
        // 性别
        uint8 sex;
        // 年龄
        uint8 age;
        //类型 1是医生 2是病人
        int8 theType; 
        //工龄
        uint8 workYear;
        
    }

    mapping (address => DoctorInfo) public doctorMap;
    
    // 注册
    function addDoctor(string memory name,uint8 sex,uint8 age,uint8 workYear) public{
        string memory str = doctorMap[msg.sender].name;
        require(keccak256(abi.encodePacked(str)) == keccak256(""),"user has exist");
        DoctorInfo memory d=DoctorInfo(name,sex,age,1,workYear);
        doctorMap[msg.sender]=d;
        // doctorList.push(msg.sender);
    }

    function addDoctor(address addr,string memory name,uint8 sex,uint8 age,uint8 workYear) public onlyAdmin{
        string memory str = doctorMap[addr].name;
        require(keccak256(abi.encodePacked(str)) == keccak256(""),"user has exist");
        DoctorInfo memory d=DoctorInfo(name,sex,age,1,workYear);
        doctorMap[addr]=d;
        // doctorList.push(addr);
    }

    // 修改
    function updateDoctor(string memory name,uint8 sex,uint8 age,uint8 workYear) public {
        string memory str = doctorMap[msg.sender].name;
        require(keccak256(abi.encodePacked(str)) != keccak256(""),"user not exist");
        DoctorInfo memory d=DoctorInfo(name,sex,age,1,workYear);
        doctorMap[msg.sender]=d;       
    }

    function updateDoctor(address addr,string memory name,uint8 sex,uint8 age,uint8 workYear) public onlyAdmin{
        string memory str = doctorMap[addr].name;
        require(keccak256(abi.encodePacked(str)) != keccak256(""),"user not exist");
        DoctorInfo memory d=DoctorInfo(name,sex,age,1,workYear);
        doctorMap[addr]=d;        
    }

    // 查询
    function queryDoctor(address addr) public view onlyAdmin returns (DoctorInfo memory){
        DoctorInfo memory d = doctorMap[addr];
        return d;
    }

    function queryMySelf() public view returns (DoctorInfo memory){
        DoctorInfo memory d = doctorMap[msg.sender];
        return d;
    }


    //删除
    function delDoctor(address addr) public onlyAdmin {
        doctorMap[addr].theType=-1;
    }

  

}