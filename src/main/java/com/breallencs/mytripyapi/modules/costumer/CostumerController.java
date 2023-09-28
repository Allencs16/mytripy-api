package com.breallencs.mytripyapi.modules.costumer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/costumer"})
public class CostumerController {

    private CostumerRepository costumerRepository;
    private CostumerService costumerService;
    
    public CostumerController(CostumerRepository costumerRepository, CostumerService costumerService){
        this.costumerRepository = costumerRepository;
        this.costumerService = costumerService;
    }

    @GetMapping
    public List<Costumer> listCostumer(){
        return this.costumerRepository.findAll();
    }

    @PostMapping
    public Costumer createCostumer(@RequestBody CostumerDTO costumerDTO){
        return this.costumerService.createCostumer(costumerDTO);
    }
}
