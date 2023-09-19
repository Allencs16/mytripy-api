package com.breallencs.mytripyapi.modules.costumer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/costumer"})
public class CostumerController {

    private CostumerRepository costumerRepository;
    
    CostumerController(CostumerRepository costumerRepository){
        this.costumerRepository = costumerRepository;
    }

    @GetMapping
    public List<Costumer> listCostumer(){
        return this.costumerRepository.findAll();
    }
}
