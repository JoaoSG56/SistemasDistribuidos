package Client;

public class ClientStatus {
    private boolean login;
    private boolean waitingForResponse;
    private boolean exited;

    public ClientStatus(){
        this.login = false;
        this.waitingForResponse = false;
        this.exited = false;
    }

    public synchronized void login(){
        this.login = true;
    }

    public synchronized void logout(){
        this.login = false;
    }

    public synchronized boolean getLogin(){
        return this.login;
    }

    public synchronized boolean getWaiting(){
        return this.waitingForResponse;
    }
    public synchronized void setWaitingOFF(){
        this.waitingForResponse = false;
        notifyAll();
    }
    public synchronized void waitForResponse() throws InterruptedException {
        this.waitingForResponse = true;
        while(this.waitingForResponse)
            wait();
    }

    public synchronized void exited(){
        this.exited = true;
    }

    public synchronized boolean isExited(){
        return this.exited;
    }

}
