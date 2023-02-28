package com.StockExchangeApplication.share;

import com.StockExchangeApplication.stockExchange.StockExchangeData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ShareDto {

    private int id;
    private String companyName;
    private String companyUrlPart;
    private Integer qty;
    private float purchasePrice;
    private float expectedPrice;
    private float actualPrice;
    private String lastChange;

    public ShareDto(Share share) {
        this.id = share.getId();
        this.companyName = share.getCompanyName();
        this.companyUrlPart = share.getCompanyUrlPart();
        this.qty = share.getQty();
        this.purchasePrice = share.getPurchasePrice();
        this.expectedPrice = share.getExpectedPrice();
    }

    public ShareDto(Share share, StockExchangeData stockExchangeData) {
        this.id = share.getId();
        this.companyName = share.getCompanyName();
        this.companyUrlPart = share.getCompanyUrlPart();
        this.qty = share.getQty();
        this.purchasePrice = share.getPurchasePrice();
        this.expectedPrice = share.getExpectedPrice();
        this.actualPrice = stockExchangeData.getActualPrice();
        this.lastChange = stockExchangeData.getLastChange();
    }

    public Share toEntity() {
        Share share = new Share();
        share.setId(this.id);
        share.setCompanyName(this.companyName);
        share.setCompanyUrlPart(this.companyUrlPart);
        share.setQty(this.qty);
        share.setPurchasePrice(this.purchasePrice);
        share.setExpectedPrice(this.expectedPrice);

        return share;
    }

}
