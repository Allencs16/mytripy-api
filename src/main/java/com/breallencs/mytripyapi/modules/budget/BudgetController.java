package com.breallencs.mytripyapi.modules.budget;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping({"/budget"})
public class BudgetController {
  
  private BudgetService budgetService;
  private BudgetRepository budgetRepository;

  public BudgetController(BudgetService budgetService, BudgetRepository budgetRepository){
    this.budgetService = budgetService;
    this.budgetRepository = budgetRepository;
  }

  @GetMapping
  public List<Budget> getAllBudgets(){
    return budgetRepository.findAll();
  }

  @PostMapping
  public Budget createBudget(@RequestBody BudgetDTO budgetDTO){
    return budgetService.createBudget(budgetDTO);
  }

  @DeleteMapping(path = "/{budgetId}")
  public ResponseEntity<?> deleteBudget(@PathVariable Long budgetId){
    budgetRepository.deleteById(budgetId);
    return ResponseEntity.ok().body("Deleted Sucefully");
  }
}
