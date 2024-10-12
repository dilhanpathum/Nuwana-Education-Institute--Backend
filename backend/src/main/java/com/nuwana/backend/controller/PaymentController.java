package com.nuwana.backend.controller;

import com.nuwana.backend.dto.PaymentDto;
import com.nuwana.backend.dto.UsersDto;
import com.nuwana.backend.service.PaymentService;
import com.nuwana.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    private String merchantSecret = "MTM5MTQ0ODA0MzE4MDUzMTM1MDIzMDUyNzIzOTEzODIwNTM0NTQ=";

    @GetMapping("/payment")
    public ResponseEntity<Map<String, String>> payment() {
        String merahantID     = "1227846";
        String orderID = Long.toString(System.currentTimeMillis());
        String amounts         = "1000.00";
        String currency       = "LKR";
//        DecimalFormat df       = new DecimalFormat("0.00");
//        String amountFormatted = df.format(amounts);
        String hash    = getMd5(merahantID + orderID + amounts + currency + getMd5(merchantSecret));
        Map<String, String> response = new HashMap<>();
        response.put("merahantID", merahantID);
        response.put("orderID", orderID);
        response.put("amounts", amounts);
        response.put("currency", currency);
        response.put("hash", hash);

        return  ResponseEntity.ok(response);
    }
    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
