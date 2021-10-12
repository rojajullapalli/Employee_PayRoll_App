package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * creates and maintains response data as object (DTO)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 10-10-2021
 */
@Data
@AllArgsConstructor
public class ResponseDto {
    private String message;
    private Object data;
}
