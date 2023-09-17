package com.externalapi.externalapi.service;

import com.externalapi.externalapi.entity.Address;

//特定の郵便番号に対応する住所情報を提供するAddressServiceインターフェース
public interface AddressService {
    Address findAddressByZipCode(String zipCode);
}
