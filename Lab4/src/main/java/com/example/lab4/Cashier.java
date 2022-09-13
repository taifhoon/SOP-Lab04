package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "getChange/{num}", method = RequestMethod.GET)
    public Change getChange(@PathVariable int num){
        Change coin = new Change();
        if (num >= 1000){
            coin.setB1000(num/1000);
            num -= ((num/1000)*1000);
        }
        if (num >= 500){
            coin.setB500(num/500);
            num -= ((num/500)*500);
        }
        if (num >= 100){
            coin.setB100(num/100);
            num -= ((num/100)*100);
        }
        if (num >= 20){
            coin.setB20(num/20);
            num -= ((num/20)*20);
        }
        if (num >= 10){
            coin.setB10(num/10);
            num -= ((num/10)*10);
        }
        if (num >= 5){
            coin.setB5(num/5);
            num -= ((num/5)*5);
        }
        if (num >= 1){
            coin.setB1(num);
        }
        return coin;
    }
}
