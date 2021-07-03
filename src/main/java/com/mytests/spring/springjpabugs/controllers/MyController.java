package com.mytests.spring.springjpabugs.controllers;

import com.mytests.spring.springjpabugs.data.Tab1;
import com.mytests.spring.springjpabugs.repositories.Tab1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {


    @Autowired
    private Tab1Repo tab1Repo;

    @GetMapping("/cheap/{price}")
    public String findCheap(@PathVariable String price) {
        int value = 50;
        try {
            value = Integer.parseInt(price);
        }catch (Exception e){ value = 50;}
        String rez= "got: \n";
        for (Tab1 tab1 : tab1Repo.findByPriceLessThan(value)) {
           rez = rez + tab1.toString()+ "\n"; 
        }
        return rez;
    }

    @GetMapping("/multi/{amount}")
    public String multi(@PathVariable("amount") String amount) {
        int value = 50;
        try {
            value = Integer.parseInt(amount);
        }catch (Exception e){ value = 50;}
        String rez= "got: \n";
        for (Tab1Repo.TitleProjection title : tab1Repo.findTitleByAmountGreaterThan(value)) {
            rez = rez + title.getName() + "\n";
        }
        return rez;
    }

    
    public Tab1Repo getTab1Repo() {
        return tab1Repo;
    }
}
