package core;

import java.net.InetSocketAddress;

import sender.MulticastPacketSender;

public class ThreadNotifier implements Runnable {
    private MulticastPacketSender multicastPacketSender;
    private InetSocketAddress inetSocketAddress;
    private String message;
    private int notifyPeriod;
    private static Thread thread = new Thread();

    public ThreadNotifier(MulticastPacketSender multicastPacketSender, String message, int notifyPeriod) {
        this.multicastPacketSender = multicastPacketSender;
        this.message = message;
        this.notifyPeriod = notifyPeriod;
    }
    
    public Thread getThread() {
    	return thread;
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

    private void notifyGroup() throws InterruptedException {
        try {
			while (true) {		    
			     thread.sleep(notifyPeriod);
			     multicastPacketSender.sendPacket(message);			    
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    

    @Override
    public void run() {
        try {
			notifyGroup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
