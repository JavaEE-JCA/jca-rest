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

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MessagesReceived {

    private final List<String> messagesReceived = new ArrayList<>();

    public List<String> getMessagesReceived() {
        return messagesReceived;
    }

    public void messageReceived(final String message) {
        messagesReceived.add(message);
    }
}
