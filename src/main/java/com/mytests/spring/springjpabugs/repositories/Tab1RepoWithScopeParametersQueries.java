package com.mytests.spring.springjpabugs.repositories;

import com.mytests.spring.springjpabugs.data.Tab1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface Tab1RepoWithScopeParametersQueries extends CrudRepository<Tab1, Integer> {
    
    
  //  List<Tab1> findByPriceWithin(Collection<Integer> price);
    List<Tab1> findByPriceBetween(Integer price, Integer price2);
    List<Tab1> findByPriceIn(Collection<Integer> price);
    
}
