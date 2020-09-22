package com.kuang.config;

import io.seata.common.util.StringUtils;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class GlobalTransactionScanner {
//
//    public GlobalTransactionScanner globalTransactionScanner() {
//        String applicationName = this.applicationContext.getEnvironment()
//                .getProperty("spring.application.name");
//
//        String txServiceGroup = this.seataProperties.getTxServiceGroup();
//
//        if (StringUtils.isEmpty(txServiceGroup)) {
//            txServiceGroup = applicationName + "-fescar-service-group";
//            this.seataProperties.setTxServiceGroup(txServiceGroup);
//        }
//
//        return new GlobalTransactionScanner(applicationName, txServiceGroup);
//    }
//}
