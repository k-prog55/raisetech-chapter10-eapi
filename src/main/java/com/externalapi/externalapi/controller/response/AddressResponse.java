package com.externalapi.externalapi.controller.response;

import com.externalapi.externalapi.entity.Address;
import com.externalapi.externalapi.entity.AddressData;

import java.util.List;

//外部のクライアントに提供されるデータ表現として、AddressResponseクラスを作成する！
public class AddressResponse {
    private int status;
    private String message;
    private List<AddressData> results;

    public AddressResponse(Address address) {
        this.status = address.getStatus();
        this.message = address.getMessage();
        this.results = address.getResults();
    }

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
