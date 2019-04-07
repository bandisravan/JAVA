package com.ing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.domain.ReviewHistory;

@Service
public class QuoteService {

	// @Autowired
	// ReviewHistory reviewHistoryObj;

	public ReviewHistory getQuote(ReviewHistory reviewHistory) {
		// TODO Auto-generated method stub
		ReviewHistory reviewHistoryObj = new ReviewHistory();
		int quantity = reviewHistory.getQuantity();
		int stockId = reviewHistory.getStockId();
		Double stockPrice = reviewHistory.getStockPrice();
		Double totalPurchasedPrice;
		Double totalFees = 0.0;

		if (quantity <= 500) {
			totalFees = .10 * quantity;
			// totalPurchasedPrice=stockPrice+(.10*quantity);
		} else {
			totalFees = .10 * quantity;
			//totalPurchasedPrice = stockPrice + (.15 * quantity / 100);
		}
		totalPurchasedPrice = stockPrice + totalFees;
		
		
		reviewHistoryObj.setId(reviewHistory.getId());
		reviewHistoryObj.setTotalIncludingFee(totalPurchasedPrice);
		reviewHistoryObj.setQuantity(quantity);
		reviewHistoryObj.setStockPrice(stockPrice);
		reviewHistoryObj.setStockName(reviewHistory.getStockName());
		reviewHistoryObj.setTotalFees(totalFees);
		return reviewHistoryObj;
	}

}
