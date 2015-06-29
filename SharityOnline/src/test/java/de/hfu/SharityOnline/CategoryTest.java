package de.hfu.SharityOnline;

import org.junit.Ignore;
import org.junit.Test;

import de.hfu.SharityOnline.entities.Category;
import de.hfu.SharityOnline.rest.CategoryRestSchnittstelle;

@Ignore
public class CategoryTest {
  public static CategoryRestSchnittstelle u = new CategoryRestSchnittstelle();

  
  public void createCategoryWithArguments(String category_id, String category_term){
    Category cat = new Category();
    cat.setCategory_id(category_id);
    cat.setCategory_term(category_term);
    u.createEntity(cat);
  }
  
  @Test
  public void createCategoriesForTest(){
    createCategoryWithArguments("1", "Babysitten");
    createCategoryWithArguments("2", "Informatik Nachhilfe");
    createCategoryWithArguments("3", "Mathe Nachhilfe");
    createCategoryWithArguments("4", "Haushalt");
    createCategoryWithArguments("5", "Deutsch Nachhilfe");
    createCategoryWithArguments("6", "Praktikum");
  }
}
