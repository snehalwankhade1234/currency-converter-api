package com.currency_converter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.currency_converter.model.ConversionRequest;
import com.currency_converter.model.ConversionResponse;
import com.currency_converter.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	 @Autowired
	    private CurrencyService currencyService;

	    @PostMapping("/convert")
	    public ResponseEntity<ConversionResponse> convert(@RequestBody ConversionRequest request) {
	        ConversionResponse response = currencyService.convertCurrency(
	                request.getFrom(),
	                request.getTo(),
	                request.getAmount()
	        );
	        return ResponseEntity.ok(response);
	    }
}
