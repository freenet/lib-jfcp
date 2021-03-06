/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */

package org.freenetproject.contrib.fcp.event;

import org.freenetproject.contrib.fcp.message.node.NodeMessage;

/**
 *
 * @author res
 */
public class FcpConnectEvent<NodeHello> extends FcpEvent{
    
    /** Creates a new instance of FcpConnectEvent */
    public FcpConnectEvent(NodeHello message) {
        super(message);
    }
    
}
