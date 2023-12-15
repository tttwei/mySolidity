// SPDX-License-Identifier: MIT
pragma solidity ^0.6.0;
pragma experimental ABIEncoderV2;
contract Base {
    
    struct PersonInfo{
        
        // 姓名
        string name;
        // 性别
        uint sex;
        // 年龄
        uint age;
        // 身份
        personType theType;
    }
    enum personType {
        doctor,
        patient 
        }
   
}