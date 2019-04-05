package com.ing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.domain.Stock;
import com.ing.service.StockService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@RestController
@EnableSwagger2
@RequestMapping("api/v1/")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	
	@GetMapping("/stock")
	public List<Stock> getStockDetails() {
		List<Stock> stocklist  = stockService.getStockDetails();
		return stocklist;
	}

	@GetMapping("/viewHistory/{id}")
	public List<ReviewHistory> viewHistory(@PathVariable String id) {
		List <ReviewHistory> stock  = transactionService.viewHistory(Integer.parseInt(id));
		return stock;
	}

}


}
