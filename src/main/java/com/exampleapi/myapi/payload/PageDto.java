package com.exampleapi.myapi.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageDto {

private List<RegistrationDto> regDtoList;

private int pagoNo;
private int pageSize;
private int totalPages;

}

