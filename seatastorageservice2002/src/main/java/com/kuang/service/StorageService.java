package com.kuang.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {

    void decrease(Long productId,Integer count);
}
