package com.example.web;

import com.example.config.AccountSetting;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
//  private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
//
//  @Autowired
//  AccountSetting accountSetting;
//
//  @PostMapping("/hello")
//  public ResponseData printAccount(String account) {
//    System.out.println("account："+account);
//
//    if (!account.equals(accountSetting.getName())) {
//      return new ResponseData("Search failed!");
//    }
//
//    return new ResponseData("name: " + accountSetting.getName()
//        + " sex: " + accountSetting.getSex()
//        + " age: " + accountSetting.getAge());
//  }
}
