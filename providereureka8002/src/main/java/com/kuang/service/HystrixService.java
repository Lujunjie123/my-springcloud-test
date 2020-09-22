package com.kuang.service;


public interface HystrixService {

    String ok(Integer id);

    String timeout(Integer id);

    String CircuitBreaker(Integer id);
}
