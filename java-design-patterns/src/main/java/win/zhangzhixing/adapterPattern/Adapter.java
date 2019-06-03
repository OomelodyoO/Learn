package win.zhangzhixing.adapterPattern;

public class Adapter extends Usber implements Ps2 {
    @Override
    public void isPs2() {
        isUsb();
    }
}