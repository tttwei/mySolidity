package utils;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.ClientAndKeyPair;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

@Slf4j
public class ContractUtil {

    /**
     * 初始化Client客户端
     * @param bcosSDK
     * @return ClientAndKeyPair
     */
    private static ClientAndKeyPair clientInit(BcosSDK bcosSDK) {
        Client client = bcosSDK.getClient(1);

        // 从pemAccountFilePath指定路径加载pem账户文件，并将其设置为交易发送账户
        // 通过client获取CryptoSuite对象
        CryptoSuite cryptoSuite = client.getCryptoSuite();
        // 加载pem账户文件
        String pemAccountFilePath = "src\\main\\resources\\pem\\0xf0c0b42c2b297d90ac89b3cecddda103f94efa81.pem";

        cryptoSuite.loadAccount("pem", pemAccountFilePath, null);
        CryptoKeyPair cryptoKeyPair = cryptoSuite.getCryptoKeyPair();

        log.info("客户端初始化完成：{}，调用者地址信息：{}", client, cryptoKeyPair.getAddress());
        return new ClientAndKeyPair(client,cryptoKeyPair);
    }

    /**
     *
     * @param bcosSDK
     * @return HospitalCases
     * @throws ContractException
     */
    public static HospitalCases contractLoad(BcosSDK bcosSDK,String address) throws ContractException {
        ClientAndKeyPair clientAndKeyPair = clientInit(bcosSDK);
        HospitalCases hospitalCases;
        if (address.length()==0||address==null) {
            hospitalCases = HospitalCases.deploy(clientAndKeyPair.getClient(), clientAndKeyPair.getCryptoKeyPair());
        }else {
            hospitalCases = HospitalCases.load(address,clientAndKeyPair.getClient(), clientAndKeyPair.getCryptoKeyPair());
        }
        String contractAddress = hospitalCases.getContractAddress();
        log.info("合约地址值：{}",contractAddress);
        return hospitalCases;
    }
}
