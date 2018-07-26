package win.zhangzhixing.quickfix.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.*;
import quickfix.mina.acceptor.DynamicAcceptorSessionProvider;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.*;

import static quickfix.Acceptor.*;

@Component
public class FixServer {
    private SocketAcceptor acceptor = null;
    private final Map<InetSocketAddress, List<DynamicAcceptorSessionProvider.TemplateMapping>> dynamicSessionMappings = new HashMap<>();

    @Autowired
    private FixApplication fixApplication;

    private void configureDynamicSessions(SessionSettings settings, Application application,
                                          MessageStoreFactory messageStoreFactory, LogFactory logFactory,
                                          MessageFactory messageFactory) throws ConfigError, FieldConvertError {
        Iterator<SessionID> sectionIterator = settings.sectionIterator();
        while (sectionIterator.hasNext()) {
            SessionID sessionID = sectionIterator.next();
            if (isSessionTemplate(settings, sessionID)) {
                InetSocketAddress address = getAcceptorSocketAddress(settings, sessionID);
                getMappings(address).add(new DynamicAcceptorSessionProvider.TemplateMapping(sessionID, sessionID));
            }
        }

        for (Map.Entry<InetSocketAddress, List<DynamicAcceptorSessionProvider.TemplateMapping>> entry : dynamicSessionMappings
                .entrySet()) {
            acceptor.setSessionProvider(entry.getKey(), new DynamicAcceptorSessionProvider(
                    settings, entry.getValue(), application, messageStoreFactory, logFactory,
                    messageFactory));
        }
    }

    private List<DynamicAcceptorSessionProvider.TemplateMapping> getMappings(InetSocketAddress address) {
        return dynamicSessionMappings.computeIfAbsent(address, k -> new ArrayList<>());
    }

    private InetSocketAddress getAcceptorSocketAddress(SessionSettings settings, SessionID sessionID)
            throws ConfigError, FieldConvertError {
        String acceptorHost = "0.0.0.0";
        if (settings.isSetting(sessionID, SETTING_SOCKET_ACCEPT_ADDRESS)) {
            acceptorHost = settings.getString(sessionID, SETTING_SOCKET_ACCEPT_ADDRESS);
        }
        int acceptorPort = (int) settings.getLong(sessionID, SETTING_SOCKET_ACCEPT_PORT);

        return new InetSocketAddress(acceptorHost, acceptorPort);
    }

    private boolean isSessionTemplate(SessionSettings settings, SessionID sessionID)
            throws ConfigError, FieldConvertError {
        return settings.isSetting(sessionID, SETTING_ACCEPTOR_TEMPLATE)
                && settings.getBool(sessionID, SETTING_ACCEPTOR_TEMPLATE);
    }

    private void init() throws ConfigError, FieldConvertError {
        SessionSettings settings = new SessionSettings("acceptor.conf");
        MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new ScreenLogFactory(true, true, true);
        MessageFactory messageFactory = new DefaultMessageFactory();
        acceptor = new SocketAcceptor(fixApplication, messageStoreFactory, settings, logFactory, messageFactory);
        configureDynamicSessions(settings, fixApplication, messageStoreFactory, logFactory,
                messageFactory);
    }

    @PostConstruct
    public void start() throws FieldConvertError, ConfigError {
        init();
        acceptor.start();
    }


    @PreDestroy
    public void stop() {
        acceptor.stop();
    }
}
