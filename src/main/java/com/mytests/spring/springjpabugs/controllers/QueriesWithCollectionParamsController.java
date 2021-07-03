package com.mytests.spring.springjpabugs.controllers;

import com.mytests.spring.springjpabugs.data.Tab1;
import com.mytests.spring.springjpabugs.repositories.Tab1RepoWithScopeParametersQueries;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 03.07.2021.</p>
 * <p>Project: spring-jpa-bugs</p>
 * *
 */
@RestController
public class QueriesWithCollectionParamsController {

    private final Tab1RepoWithScopeParametersQueries tab1Repo;

    public QueriesWithCollectionParamsController(Tab1RepoWithScopeParametersQueries tab1Repo) {
        this.tab1Repo = tab1Repo;
    }

    @GetMapping("/scope/in")
    public String testIn(){
        StringBuilder rez= new StringBuilder();
        List<Integer> scope = new ArrayList<>();
        scope.add(10);
        scope.add(50);
        scope.add(100);
        List<Tab1> tabs = tab1Repo.findByPriceIn(scope);
        for (Tab1 tab : tabs) {
            rez.append(", ").append(tab.getTitle());
        }
        return rez.toString();
    }
    /*@GetMapping ("/scope/within")
    public String testWithin(){
        StringBuilder rez= new StringBuilder();
        List<Integer> scope = new ArrayList<>();
        scope.add(10);
        scope.add(50);
        scope.add(100);
        List<Tab1> tabs = tab1Repo.findByPriceWithin(scope);
        for (Tab1 tab : tabs) {
            rez.append(", ").append(tab.getTitle());
        }
        return rez.toString();
    }*/
    @GetMapping("/scope/between")
    public String testBetween(){
        StringBuilder rez= new StringBuilder();
        Integer i1 = 50;
        Integer i2 = 100;
        List<Tab1> tabs = tab1Repo.findByPriceBetween(i1,i2);
        for (Tab1 tab : tabs) {
            rez.append(", ").append(tab.getTitle());
        }
        return rez.toString();
    }
}
