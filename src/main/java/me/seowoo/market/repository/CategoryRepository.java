package me.seowoo.market.repository;


import me.seowoo.market.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select distinct c from Category c left join fetch c.children subc where c.parent is null")
    List<Category> findAllWithFetchJoin();
}
