package com.breallencs.mytripyapi.modules.expenses;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/expenses"})
public class ExpensesController {
  
  private ExpensesRepository expensesRepository;
  private ExpensesServices expensesServices;

  public ExpensesController(ExpensesRepository expensesRepository, ExpensesServices expensesServices){
    this.expensesRepository = expensesRepository;
    this.expensesServices = expensesServices;
  }

  @GetMapping
  public List<Expenses> getAllExpenses(){
    return expensesRepository.findAll();
  }

  @PostMapping
  public Expenses createExpense(@RequestBody ExpensesDTO expensesDTO){
    return expensesServices.createExpense(expensesDTO);
  }
}
