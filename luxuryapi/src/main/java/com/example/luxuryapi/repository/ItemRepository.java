package com.example.luxuryapi.repository;

import com.example.luxuryapi.еntities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>  {

    // Create new item
    @Modifying
    @Transactional
    @Query(
            value = """
        INSERT INTO Item 
          (Sort, Title, Price, Color, Transparency, Weight_g, Structure, Sustainability, Optical_effect, Purity, Origins, ImagePath, Stock, FK_Category_ID)
        VALUES
          (:sort, :title, :price, :color, :transparency, :weight_g, :structure, :sustainability, :optical_effect, :purity, :origins, :imagePath, :stock, :categoryId)
      """,
            nativeQuery = true
    )
    int insertItem(
            @Param("sort")           String sort,
            @Param("title")          String title,
            @Param("price")          double price,
            @Param("color")          String color,
            @Param("transparency")   String transparency,
            @Param("weight_g")       double weight_g,
            @Param("structure")      String structure,
            @Param("sustainability") String sustainability,
            @Param("optical_effect") String optical_effect,
            @Param("purity")         String purity,
            @Param("origins")        String origins,
            @Param("imagePath")      String imagePath,
            @Param("stock")          int stock,
            @Param("categoryId")     Long categoryId
    );

    // Return all Items names
    @Query("SELECT Title FROM Item")
    List<String> getAllItemsName();

    // Return all Items with their category
    @Query("SELECT *,cat.Category_Name FROM Item i LEFT JOIN Category cat ON i.FK_Category_ID = cat.Category_ID")
    List<String> getAllItemsWithCategory();

    // Return all about one Item with category by Id
    @Query(value = """
    SELECT i.*, cat.Category_Name
    FROM Item i
    LEFT JOIN Category cat ON i.FK_Category_ID = cat.Category_ID
    WHERE i.ItemID = :itemId
    """, nativeQuery = true)
    List<Object[]> getItemByIdWithCategoryNative(@Param("itemId") Long itemId);

    // Update one Item stock
    @Modifying // show that the query modify data :contentReference[oaicite:2]{index=2}
    @Query(
            value = "UPDATE Item SET Stock = :stock WHERE ItemID = :itemId",
            nativeQuery = true
    )
    int updateItemStockNative(
            @Param("stock")   int stock,
            @Param("itemId")  Long itemId
    );

    // Return Items in price range
    List<Item> findByPriceBetween(double min, double max);

    // Return Items by category
    List<Item> findByFKCategoryID(Long categoryId);
}
