package com.externalapi.externalapi.entity;

public class AddressData {

    //resultsとしてリスト化され、レスポンスされる値はこちらのフィールドとゲッターを修正すれば変更される
    private String address1;
    private String address2;
    private String address3;

    //フィールドであるものは全てゲッターを作成する
    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

}
