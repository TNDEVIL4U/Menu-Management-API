package com.example.Menu.Management.dto;

import lombok.Data;

@Data
public class ItemResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private Boolean availability;
}
