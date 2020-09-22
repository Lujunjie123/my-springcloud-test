package com.kuang.service;


import com.kuang.domain.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
