package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller会加载html页面
 * 在此类中return"index"，
 * 此时会调用一个index.html的页面
 * */
@Controller
public class HelloController {
  @GetMapping("/hello")
  public String hello() {
    return "index";
  }
}

/**
 * @RestController
 * 在resources/application.properties中添加
 * book.author=liyingxiao
 * book.name=spring boot
 * 之后运行代码，在页面显示这些信息。
 * //@RestController
 * //public class HelloController {
 * //  @Value("${book.author}")
 * //  private String bookAuthor;
 * //  @Value("${book.name}")
 * //  private String bookName;
 * //  @GetMapping("/hello")
 * //  public String hello() {
 * //    return "bookName" + bookName + "  bookAuthor" + bookAuthor;
 * //  }
 * //}
 * */

