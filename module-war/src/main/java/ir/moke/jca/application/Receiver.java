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
package ir.moke.jca.application;


import ir.moke.jca.api.InboundListener;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;

@MessageDriven(name = "Receiver")
public class Receiver implements InboundListener {

    @EJB
    private MessagesReceived messagesReceived;

    @Override
    public void receiveMessage(String message) {
        messagesReceived.messageReceived(message);
    }
}
