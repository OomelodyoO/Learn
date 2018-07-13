package cn.zhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangzhixing on 2017/3/28.
 */
@RestController
public class BaseController {
    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return baseService.addService();
    }
}
