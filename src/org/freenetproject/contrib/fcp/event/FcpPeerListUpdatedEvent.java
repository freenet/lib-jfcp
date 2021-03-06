/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */

package org.freenetproject.contrib.fcp.event;

import java.util.Map;
import org.freenetproject.contrib.fcp.NodeInfo;
import org.freenetproject.contrib.fcp.message.node.Peer;
import org.freenetproject.contrib.fcp.peer.PeerMetaData;

/**
 *
 * @author res
 */
public class FcpPeerListUpdatedEvent {
    private Map<String, Peer> _peers;
    /**
     * Creates a new instance of FcpPeerListUpdatedEvent
     */
    public FcpPeerListUpdatedEvent(Map<String, Peer> peers) {
        _peers = peers;
    }

    public Map<String, Peer> getPeers() {
        return _peers;
    }
    
}
