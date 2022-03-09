package com.sci.feb22.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help")
public class HelpController {

  @Autowired
  Scanner in;

  @GetMapping("/read")
  public boolean isGoodLine() {

    String s;
    List<String> l = new ArrayList<>();
    while (in.hasNext()) {
      l.add(in.next());
    }

    for (int i = 1; i < l.size(); i++) {
      if (l.get(i).length() != l.get(0).length()) {
        return false;
      }
    }
    return true;
  }
}
