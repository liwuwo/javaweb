package com.service.index;

import com.common.enums.ResultEnum;
import com.domain.result.ResultData;
import com.common.util.DateUtil;
import com.service.BaseJob;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InitAutoJob extends BaseJob {

    private int count;

    @Override
    public Object doWork() {
        String date = DateUtil.formatDateToString(new Date(),DateUtil.YYMMDDHHMMSS);
        System.out.println(date + " >>>quartz IndexJob.doWork <<<");
        System.out.println("quartz exectue count = " + count++);
        return new ResultData(ResultEnum.SUCCESS,">> " + count + " <<");
    }
}
