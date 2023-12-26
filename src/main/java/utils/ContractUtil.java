package utils;

import com.example.f3.entity.ClientAndKeyPair;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;

import java.lang.reflect.Method;

@Slf4j
public class ContractUtil {

    /**
     * 初始化Client客户端
     * @param bcosSDK
     * @return ClientAndKeyPair
     */
    private static ClientAndKeyPair clientInit(BcosSDK bcosSDK,String pemAccountFilePath) {
        Client client = bcosSDK.getClient(1);

        // 从pemAccountFilePath指定路径加载pem账户文件，并将其设置为交易发送账户
        // 通过client获取CryptoSuite对象
        CryptoSuite cryptoSuite = client.getCryptoSuite();

        cryptoSuite.loadAccount("pem", pemAccountFilePath, null);
        CryptoKeyPair cryptoKeyPair = cryptoSuite.getCryptoKeyPair();

        log.info("客户端初始化完成：{}，调用者地址信息：{}", client, cryptoKeyPair.getAddress());
        return new ClientAndKeyPair(client, cryptoKeyPair);
    }

    /**
     *
     * 合约加载，根据密钥对，确认不同身份
     * @param bcosSDK
     * @return HospitalCases
     * @throws Exception
     */
    public static <T> T contractLoad(BcosSDK bcosSDK, String address, String pemAccountFilePath ,Class<T> contractClass) throws Exception {
        ClientAndKeyPair clientAndKeyPair = clientInit(bcosSDK,pemAccountFilePath);
        T contract;
        if (address.length() == 0 || address == null) {
            // 使用反射调用指定类的 deploy() 静态方法
            Method deployMethod = contractClass.getMethod("deploy", Client.class, CryptoKeyPair.class);
            // invoke方法的第一个参数是一个对象（实例），表示实例调用，静态方法省略
            contract = (T) deployMethod.invoke(null, clientAndKeyPair.getClient(), clientAndKeyPair.getCryptoKeyPair());
        } else {
            Method deployMethod = contractClass.getMethod("load", String.class, Client.class, CryptoKeyPair.class);
            contract = (T) deployMethod.invoke(null, address, clientAndKeyPair.getClient(), clientAndKeyPair.getCryptoKeyPair());
        }
        String contractAddress = (String) contractClass.getMethod("getContractAddress").invoke(contract);
        log.info("合约地址值：{}", contractAddress);
        return contract;
    }
}

