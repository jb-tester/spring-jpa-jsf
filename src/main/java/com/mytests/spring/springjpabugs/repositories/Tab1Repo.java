package com.mytests.spring.springjpabugs.repositories;

import com.mytests.spring.springjpabugs.data.Tab1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface Tab1Repo extends CrudRepository<Tab1, Integer> {
    
    List<Tab1> findByPriceLessThan(Integer price);
    Set<TitleProjection> findTitleByAmountGreaterThan(Integer amount);
    @Query("select t from Tab1 t where t.amount<100")
    List<Tab1> getTitleByAmount();
    @Query("select t from Tab1 t where t.price>50")
    List<TitleProjection> getTitleByPrice();

    interface TitleProjection {
        @Value("target.title")
        String getName();
    }
}
