package com.currency_converter.model;
import lombok.Data;

@Data
public class ConversionRequest {
    private String from;   // e.g., "USD"
    private String to;     // e.g., "INR"
    private double amount; // e.g., 100
}
