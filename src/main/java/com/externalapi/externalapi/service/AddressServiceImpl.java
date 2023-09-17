package com.externalapi.externalapi.service;

import com.externalapi.externalapi.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//AddressServiceImplクラスを実装
@Service
public class AddressServiceImpl implements AddressService {

    //住所情報を取得するためのWebサービスのアドレス（URL）を指定する
    private final String URL = "https://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";
    private final RestTemplate restTemplate;

    //ウェブデータを取得するためのツール(RestTemplate)を設定するためのコード
    @Autowired
    public AddressServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Address findAddressByZipCode(String zipCode) {
        //引数はURL(HTTPリクエストを送信する先のWebサービス)->レスポンスのデータ型(今回はAddressクラス)->パラメータ
        // (Webサービスに送信する任意のパラメータ)の順で記載する
        ResponseEntity<Address> response = restTemplate.getForEntity(URL, Address.class, zipCode);
        return response.getBody(); // ウェブサービスからの応答データ（住所情報）を取り出して、それを返す
    }
}
