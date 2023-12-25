pragma solidity ^0.4.25;
pragma experimental ABIEncoderV2;
contract Base {
    constructor () public {
        admin=msg.sender;
    }

    address private admin;

    modifier onlyAdmin(){
        require(admin==msg.sender,"only admin");
        _;
    }

   
   
}