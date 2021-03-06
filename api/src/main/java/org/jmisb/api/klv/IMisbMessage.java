package org.jmisb.api.klv;

/**
 * A packet containing MISB-compliant metadata
 */
public interface IMisbMessage
{
    /**
     * Get the Universal Label (UL) identifying the message type
     * @return The {@link UniversalLabel}
     */
    UniversalLabel getUniversalLabel();

    /**
     * Frame the message into a byte array
     * @param isNested If true, the key and length field are omitted, and only the value will be written
     * @return Generated byte array
     */
    byte[] frameMessage(boolean isNested);
}
