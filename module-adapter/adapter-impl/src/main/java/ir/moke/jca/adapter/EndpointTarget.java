package ir.moke.jca.adapter;

import ir.moke.jca.api.InboundListener;

import javax.resource.spi.UnavailableException;
import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;

public class EndpointTarget extends Thread {
    private final MessageEndpointFactory messageEndpointFactory;
    private MessageEndpoint messageEndpoint;

    public EndpointTarget(MessageEndpointFactory messageEndpointFactory) {
        this.messageEndpointFactory = messageEndpointFactory;
    }

    public void sendMessage(String message) {
        InboundListener inboundListener = (InboundListener) messageEndpoint;
        inboundListener.receiveMessage(message);
    }

    private void createEndpoint() {
        try {
            messageEndpoint = messageEndpointFactory.createEndpoint(null);
        } catch (UnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        /*
        * Liberty does not allow create endpoint during resourceAdapter activation .
        * so need to create this on another thread .
        * */
        createEndpoint();
    }
}
