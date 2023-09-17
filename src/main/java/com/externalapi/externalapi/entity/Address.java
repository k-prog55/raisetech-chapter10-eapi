package com.externalapi.externalapi.entity;

import java.util.ArrayList;
import java.util.List;

//外部APIから取得した住所情報を格納するAddressクラスを定義（データが来たらここに格納される）
public class Address {

    //フィールドを作成。このフィールド（とゲッター）を修正すれば、レスポンスされる内容を変更できる。
    private int status;
    private String message;
    private List<AddressData> results = new ArrayList<>(); //空のリストで初期化されている

    //ゲッターを作成
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<AddressData> getResults() {
        return results;
    }
}
