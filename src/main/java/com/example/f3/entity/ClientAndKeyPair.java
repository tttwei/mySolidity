package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class ClientAndKeyPair {
    private Client client;
    private CryptoKeyPair cryptoKeyPair;
}
