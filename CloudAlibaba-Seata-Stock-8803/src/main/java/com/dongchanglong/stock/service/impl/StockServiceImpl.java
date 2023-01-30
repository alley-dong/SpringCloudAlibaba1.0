package com.dongchanglong.stock.service.impl;


import com.dongchanglong.stock.service.StockService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void decr() {
        jdbcTemplate.update("update stock set count = count - 1 where pro_id = 1");
    }
}
