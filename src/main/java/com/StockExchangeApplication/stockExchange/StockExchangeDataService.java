package com.StockExchangeApplication.stockExchange;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface StockExchangeDataService {

    StockExchangeData getDataFromStockExchange(String companyUrlPart) throws IOException;

}
