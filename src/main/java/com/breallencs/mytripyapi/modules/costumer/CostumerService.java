package com.breallencs.mytripyapi.modules.costumer;

import org.springframework.stereotype.Service;

@Service
public interface CostumerService {
    
    Costumer createCostumer(CostumerDTO costumerDTO);
}
