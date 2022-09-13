package com.example.lab4;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable double n1, @PathVariable double n2){
        return (n1+n2)+"";
    }
    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable double n1, @PathVariable double n2){
        return (n1-n2)+"";
    }
    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable double n1, @PathVariable double n2){
        return (n1/n2)+"";
    }
    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable double n1, @PathVariable double n2){
        return (n1*n2)+"";
    }
    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public String myMod(@PathVariable double n1, @PathVariable double n2){
        return (n1%n2)+"";
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestParam MultiValueMap<String, String> n){
        Map<String, String> d = n.toSingleValueMap();
        double n1 = Double.parseDouble(d.get("n1"));
        double n2 = Double.parseDouble(d.get("n2"));
        if (n1 > n2){
            return n1+"";
        }
        else {
            return n2+"";
        }
    }
}
