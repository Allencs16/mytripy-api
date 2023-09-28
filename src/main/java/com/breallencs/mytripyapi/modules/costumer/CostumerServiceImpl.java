package com.breallencs.mytripyapi.modules.costumer;

import org.springframework.stereotype.Service;

@Service
public class CostumerServiceImpl implements CostumerService{

    private CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository){
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Costumer createCostumer(CostumerDTO costumerDTO) {
        Costumer costumer = new Costumer();
        costumer.setName(costumerDTO.getName());
        costumer.setManager(costumerDTO.getManager());
        costumer.setCity(costumerDTO.getCity());
        costumer.setDescription(costumerDTO.getDescription());
        costumer.setState(costumerDTO.getState());

        costumerRepository.saveAndFlush(costumer);

        return costumer;
    }
    
}
