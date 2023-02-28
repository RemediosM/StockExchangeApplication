package com.StockExchangeApplication.share;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShareService {

    List<ShareDto> getAll();

    ShareDto getById(int id);

    Share save(ShareDto shareDto);

    Share update(ShareDto shareDto);

    void deleteById(int id);
}
