package com.breallencs.mytripyapi.enums;

public enum BudgetCategory {
  
  STAY(0, "Stay"),
  FOOD(1, "Food"),
  FUEL(2, "Fuel"),
  OTHER(3, "Other");

  private String title;
  private Integer id;

  private BudgetCategory(Integer id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public static BudgetCategory verifyCategory(Integer id){
    BudgetCategory[] budgetCategories = BudgetCategory.values();

    for(int i = 0; i < budgetCategories.length; i++){
      if (budgetCategories[i].getId().equals(id)) {
        return budgetCategories[i];        
      }
    }
    return null;
  }
  
}
