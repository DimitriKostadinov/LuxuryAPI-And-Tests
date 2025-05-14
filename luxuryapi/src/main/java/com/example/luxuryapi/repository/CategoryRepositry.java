package com.example.luxuryapi.repository;

import com.example.luxuryapi.еntities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepositry extends JpaRepository<Category, Long> {

    // Create new category
    @Modifying
    @Transactional
    @Query(
            value = """
        INSERT INTO Category 
          (Category_ID, Category_Name)
        VALUES
          (:categoryId, :category_name)
      """,
            nativeQuery = true
    )

    int insertCategoory(
            @Param("Category_ID")     Long categoryId,
            @Param("Category_Name")   String category_name
    );

    // Delete category
    @Query(value = """
    DELETE FROM Category WHERE Category_ID = :categoryId
    """, nativeQuery = true)

    int deleteCategoryNative(
            @Param("Category_ID")  Long categoryId
    );
}
