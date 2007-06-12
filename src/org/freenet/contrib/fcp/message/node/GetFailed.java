/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */

package org.freenet.contrib.fcp.message.node;

import org.freenet.contrib.fcp.event.support.FcpEventSupportRepository;

/**
 *
 * @author res
 */
public class GetFailed extends NodeMessage{

    public void fireEvents(FcpEventSupportRepository eventSupport) {
        eventSupport.getQueueEventSupport().fireGetFailed(this);
    }

    public String getId() {
        return _fields.get("Identifier");
    }

    public void setId(String id) {
        _fields.put("Identifier", id);
    }
    
    public String getCode(){
        return _fields.get("Code");
    }
    
    public String getCodeDescription(){
        return _fields.get("CodeDescription");
    }
    
    public String getExtraDescription(){
        return _fields.get("ExtraDescription");
    }
    
    public boolean getFatal(){
        return Boolean.parseBoolean(_fields.get("Fatal"));
    }
    
    public long getExpectedDataLength(){
        return Long.parseLong(_fields.get("ExpectedDataLength"));
    }
    
    public String getExpectedContentType(){
        return _fields.get("ExpectedMetadata.ContentType");
    }
    
    public boolean getFinalizedExpected(){
        return Boolean.parseBoolean(_fields.get("FinalizedExpected"));
    }
    
    public String getRedirectURI(){
        return _fields.get("RedirectURI");
    }
}
