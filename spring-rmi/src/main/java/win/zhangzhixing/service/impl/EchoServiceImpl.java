package win.zhangzhixing.service.impl;

import win.zhangzhixing.service.EchoService;

public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        return message;
    }
}
