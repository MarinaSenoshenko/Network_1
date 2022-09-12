package core;

import java.net.InetSocketAddress;

import sender.MulticastPacketSender;

public class ThreadNotifier extends Thread {
    private MulticastPacketSender multicastPacketSender;
    private InetSocketAddress inetSocketAddress;
    private String message;
    private int notifyPeriod;

    public ThreadNotifier(MulticastPacketSender multicastPacketSender, String message, int notifyPeriod) {
        this.multicastPacketSender = multicastPacketSender;
        this.message = message;
        this.notifyPeriod = notifyPeriod;
    }

    public MulticastPacketSender getMulticastPacketSender() {
        return multicastPacketSender;
    }
    
    public String getMessage() {
        return message;
    }
    
    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }
    
    public int getNotifyPeriod() {
        return notifyPeriod;
    }

    public void setMulticastPacketSender(MulticastPacketSender multicastPacketSender) {
        this.multicastPacketSender = multicastPacketSender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setInetSocketAddress(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
    }

    public void setNotifyPeriod(int notifyPeriod) {
        this.notifyPeriod = notifyPeriod;
    }

    private void notifyGroup() {
        while (true) {
            try {
                sleep(notifyPeriod);
                multicastPacketSender.sendPacket(message);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        notifyGroup();
    }
}
