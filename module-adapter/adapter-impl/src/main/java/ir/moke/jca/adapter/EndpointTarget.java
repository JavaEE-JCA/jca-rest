/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
