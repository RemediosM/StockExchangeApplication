package com.StockExchangeApplication.stockExchange;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StockExchangeDataServiceImpl implements StockExchangeDataService {

    @Override
    public StockExchangeData getDataFromStockExchange(String companyUrlPart) throws IOException {
        StockExchangeData stockExchangeData = new StockExchangeData();

        Document doc = Jsoup.connect(StockExchangeConnector.STOCK_EXCHANGE_PAGE + companyUrlPart).get();

        String price =  doc.select(StockExchangeConnector.PRICE_CSS_QUERY).text();
        price = price.replaceAll("[^\\d,]", "");
        price = price.replace(",", ".");
        float priceFloat = Float.parseFloat(price);
        stockExchangeData.setActualPrice(priceFloat);

        String pctChange = doc.select(StockExchangeConnector.PCT_CHANGE_CSS_QUERY).text();
        stockExchangeData.setLastChange(pctChange);

        return stockExchangeData;
    }

}
