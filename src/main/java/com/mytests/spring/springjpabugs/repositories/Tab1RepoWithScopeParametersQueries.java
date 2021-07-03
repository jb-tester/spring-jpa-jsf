package com.mytests.spring.springjpabugs.repositories;

import com.mytests.spring.springjpabugs.data.Tab1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface Tab1RepoWithScopeParametersQueries extends CrudRepository<Tab1, Integer> {
    
    
  //  List<Tab1> findByPriceWithin(Collection<Integer> price);   // within is not supported!
    
    List<Tab1> findByPriceBetween(Integer price, Integer price2);    // ok

    // query method parameters are not properly checked for having scalar/collection type: https://youtrack.jetbrains.com/issue/IDEA-273015
    
   // List<Tab1> findByPriceIn(Integer price);  // error should be shown
    List<Tab1> findByPriceIn(Collection<Integer> price);
    //List<Tab1> findByPrice(Collection<Integer> price);  // no errors are shown
    List<Tab1> findByPrice(int price);  
    
    // search keyword is not supported:
    List<Tab1> searchByAvailableFalse();   // https://youtrack.jetbrains.com/issue/IDEA-251068
}
