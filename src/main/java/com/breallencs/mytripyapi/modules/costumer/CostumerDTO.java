package com.breallencs.mytripyapi.modules.costumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @NoArgsConstructor
public class CostumerDTO {
    
    private Long id;
    private String name;
    private String manager;
    private String state;
    private String city;
    private String description;
}
