package com.StockExchangeApplication.share;

import com.StockExchangeApplication.stockExchange.StockExchangeData;
import com.StockExchangeApplication.stockExchange.StockExchangeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShareServiceImpl implements ShareService{

    @Autowired
    ShareRepository shareRepository;
    @Autowired
    StockExchangeDataService stockExchangeDataService;

    @Override
    public List<ShareDto> getAll() {
        List<Share> shares = shareRepository.findAll();
        return shares.parallelStream()
                .map(this::createShareDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShareDto getById(int id) {
        Share share = shareRepository.findById(id).orElse(null);
        if (share == null) {
            return null;
        } else {
            return new ShareDto(share);
        }
    }

    @Override
    public Share save(ShareDto shareDto) {
        return shareRepository.save(shareDto.toEntity());
    }

    @Override
    public Share update(ShareDto shareDto) {
        return shareRepository.save(shareDto.toEntity());
    }

    @Override
    public void deleteById(int id) {
        shareRepository.deleteById(id);
    }

    private ShareDto createShareDto(Share share) {
        try {
            StockExchangeData stockExchangeData = stockExchangeDataService.getDataFromStockExchange(share.getCompanyUrlPart());
            return new ShareDto(share, stockExchangeData);
        } catch (IOException e) {
            share.setCompanyUrlPart(e.getMessage());
            return new ShareDto(share);
        }

    }


}
