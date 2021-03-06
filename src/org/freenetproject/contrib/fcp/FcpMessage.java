/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */

package org.freenetproject.contrib.fcp;

import java.util.HashMap;
import java.util.Map;
import org.freenetproject.contrib.fcp.event.support.FcpEventSupportRepository;
import org.freenetproject.contrib.fcp.message.MessageBuilderException;

/**
 * The superclass of all FCP messages.
 * @author Ralph Smithen
 */
public abstract class FcpMessage{
    /**
     * the name=value pairs of the message
     */
    protected Map<String, String>   _fields = new HashMap();
    /**
     * the name of the message
     */
    protected String                _headerString;
    
    /**
     * the payload data of the message
     */
    protected byte[]                  _data;
    
    /**
     * Creates new instance, assigns {@link #_headerString _headerString}.
     */
    public FcpMessage(){
        _headerString = this.getClass().getSimpleName();
    }
    
    /**
     * Accessor for message's fields.
     * @return the message fields
     */
    public Map<String, String> getFields() {
        return _fields;
    }
    
    /**
     * Get the name of the message.
     * @return the name
     */
    public String getHeaderString(){
        return _headerString;
    }
    
    /**
     * Trigger the events upon receipt or transmission of a message.
     * @param eventSupport the object to be notified of message events
     */
    protected abstract void fireEvents(FcpEventSupportRepository eventSupport);
    
    /**
     * Get the fields that must be non-null in a valid message.
     * @return an array of <code>String</code>s, the names of the mandatory fields
     */
    public String[] getMandatoryFields() {
        return new String[] {};
    }
    
    /**
     * Checks mandatory fields.
     * @throws org.freenet.contrib.fcp.message.MessageBuilderException if required field absent
     */
    public void validate() throws MessageBuilderException{
        
        for(String field : getMandatoryFields()){
            if(_fields.get(field) == null)
                throw new MessageBuilderException("mandatory field " + field + " not found in message " + _headerString);
        }
    }    
    
    /**
     * Gets the value of the "DataLength" field.
     * @return the length in <code>byte</code>s of payload data
     */
    public int getDataLength() {
        return Integer.parseInt(_fields.get("DataLength"));
    }
    
    /**
     * Sets the value of the "DataLength" field.
     * @param dataLength the new length in <code>byte</code>s of payload data to be set
     */
    void setDataLength(int dataLength) {
        _fields.put("DataLength", String.valueOf(dataLength));
    }
    
    /**
     * Get the message's data.
     * @return the payload data
     */
    public byte[] getData() {
        return _data;
    }
    
    /**
     * Sets the payload data, also invokes the {@link #setDataLength(int) setDataLength} 
     * method with the new length.
     * @param data the payload data for the message
     */
    public void setData(byte[] data) {
        _data = data;
        setDataLength(data.length);
    }
    
    /**
     * Has the message data?
     * @return true if {@link #_data _data} is not <code>null</code>
     */
    public boolean isData(){
        return _data != null;
    }
}
