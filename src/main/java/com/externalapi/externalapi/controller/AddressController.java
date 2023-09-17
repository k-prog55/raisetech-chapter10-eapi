package com.externalapi.externalapi.controller;

import com.externalapi.externalapi.controller.response.AddressResponse;
import com.externalapi.externalapi.entity.Address;
import com.externalapi.externalapi.service.AddressService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController  //ウェブコントローラであることを示すアノテーション
@Validated  //入力検証を有効にするためのアノテーション
public class AddressController {

    // AddressServiceを使うための依存性注入（DI）
    private final AddressService addressService;

    //コンストラクタでAddressServiceを注入
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // HTTP GETリクエストを処理するメソッドです。/addressエンドポイントにマップされている
    @GetMapping("/address")
    // リクエストパラメータ（zipcode）の検証を行います。指定された正規表現に一致しない場合はエラーが返る。
    public AddressResponse findAddress(@RequestParam("zipcode") @NotBlank @Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}") String zipCode) {
        Address address = addressService.findAddressByZipCode(zipCode); // AddressServiceを使って、郵便番号をもとに住所情報を取得
        return new AddressResponse(address); // 取得した住所情報をAddressResponse形式に変換して返す
    }


    @ExceptionHandler(ConstraintViolationException.class) // 入力検証エラーが発生した場合にこのアノテーションが作動し、以下のメソッドが呼び出される
    public ResponseEntity<Map<String, String>> badRequestException(ConstraintViolationException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", "ZipCode entered is incorrect",
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
}
