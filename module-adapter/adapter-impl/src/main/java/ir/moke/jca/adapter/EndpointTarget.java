/*
package ir.moke.jca.adapter;

import ir.moke.jca.api.InboundListener;

import javax.resource.spi.UnavailableException;
import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;

public class EndpointTarget extends Thread {

    private MessageEndpointFactory mef;

    public EndpointTarget(final MessageEndpointFactory mef) {
        this.mef = mef;
    }

    public void invoke(final String message) {
        try {
            MessageEndpoint endpoint = mef.createEndpoint(null);
            InboundListener inboundListener = (InboundListener) endpoint;
            inboundListener.receiveMessage(message);
        } catch (UnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        invoke();
    }
}
*/
