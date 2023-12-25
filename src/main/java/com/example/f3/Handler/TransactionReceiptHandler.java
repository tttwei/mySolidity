package com.example.f3.Handler;

import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

public class TransactionReceiptHandler {
    public static void getError(TransactionReceipt tr) throws ContractException {
        String status = tr.getStatus();
        String message = tr.getMessage();
        throw new ContractException("错误状态:"+status+"错误信息:"+message);
    }
}
