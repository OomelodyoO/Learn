package win.zhangzhixing;

import org.apache.zookeeper.*;

import java.io.IOException;

public class MZookeeperWatch {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        CreateMode mode = CreateMode.PERSISTENT;
        String connectString = "localhost:2181,localhost:2182,localhost:2183";
        ZooKeeper zooKeeper = new ZooKeeper(connectString, 60000, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("EVENT:" + event.getType());
            }
        });
//        zooKeeper.exists("/zzxNode", true);
//        zooKeeper.create("/zzxNode", "zzx".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
//        zooKeeper.getChildren("/", true);
        System.out.println("ls / => " + zooKeeper.getChildren("/", true));
        if (zooKeeper.exists("/node", true) == null) {
            zooKeeper.create("/node", "conan".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
            System.out.println("create /node conan");
            System.out.println("get /node => " + new String(zooKeeper.getData("/node", false, null)));
            System.out.println("ls / => " + zooKeeper.getChildren("/", true));
        }

        if (zooKeeper.exists("/node/sub1", true) == null) {
            zooKeeper.create("/node/sub1", "sub1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
            System.out.println("create /node/sub1 sub1");
            System.out.println("ls /node => " + zooKeeper.getChildren("/node", true));
        }

        if (zooKeeper.exists("/node", true) != null) {
            zooKeeper.setData("/node", "changed".getBytes(), -1);
            System.out.println("get /node => " + new String(zooKeeper.getData("/node", false, null)));
        }

        if (zooKeeper.exists("/node/sub1", true) != null) {
            zooKeeper.delete("/node/sub1", -1);
            zooKeeper.delete("/node", -1);
            System.out.println("ls / => " + zooKeeper.getChildren("/", true));
        }
        zooKeeper.close();
    }
}
