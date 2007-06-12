/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */

package org.freenet.contrib.fcp.event;

import java.util.Map;
import org.freenet.contrib.fcp.NodeInfo;
import org.freenet.contrib.fcp.message.node.DataFound;

/**
 *
 * @author res
 */
public class DataFoundEvent extends FcpEvent<DataFound>{

    public DataFoundEvent(DataFound df){
        super(df);
    }
    
}
