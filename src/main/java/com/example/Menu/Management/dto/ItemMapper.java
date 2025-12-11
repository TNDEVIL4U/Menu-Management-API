package com.example.Menu.Management.dto;

import com.example.Menu.Management.model.Item;

public class ItemMapper {

    public static ItemResponseDto toDto(Item item) {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setId(item.getId());
        itemResponseDto.setName(item.getName());
        itemResponseDto.setPrice(item.getPrice());
        itemResponseDto.setCategory(item.getCategory());
        itemResponseDto.setAvailability(item.getAvailability());
        return itemResponseDto;
    }
    public static Item toEntity(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        return updateEntity(item, itemRequestDto);
    }

    public static Item updateEntity(Item item,ItemRequestDto itemRequestDto) {
        item.setName(itemRequestDto.getName());
        item.setPrice(itemRequestDto.getPrice());
        item.setCategory(itemRequestDto.getCategory());
        item.setAvailability(itemRequestDto.getAvailability());
        return item;
    }

}
