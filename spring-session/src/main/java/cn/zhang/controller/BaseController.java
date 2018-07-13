package cn.zhang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangzhixing on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/")
public class BaseController {
    @RequestMapping(value = "/")
    public String main(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
