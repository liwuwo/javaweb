package com.service.index.impl;

import com.domain.result.ResultData;
import com.service.index.IndexService;
import org.springframework.stereotype.Service;

@Service("indexService")
public class IndexServiceImpl implements IndexService {
    @Override
    public ResultData process() {
        System.out.println("*** IndexServiceImpl.process ***");
        return null;
    }
}
