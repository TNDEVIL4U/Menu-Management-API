package com.example.Menu.Management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemRequestDto {
    @NotNull(message = "Name cant be Null")
    @NotBlank(message = "Name cant be Blank")
    private String name;
    @Min(value=1,message="Price amount is invalid")
    private Double price;
    private String category;
    private Boolean availability;
}
