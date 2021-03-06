package org.jmisb.viewer;

import org.jmisb.api.klv.st0601.IUasDatalinkValue;
import org.jmisb.api.klv.st0601.UasDatalinkMessage;
import org.jmisb.api.klv.st0601.UasDatalinkTag;
import org.jmisb.api.video.IMetadataListener;
import org.jmisb.api.video.MetadataFrame;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.PLAIN;

/**
 * Simple text pane to display MISB metadata
 */
public class MetadataPanel extends JTextPane implements IMetadataListener
{
    private long previous = 0;

    /**
     * Constructor
     */
    MetadataPanel()
    {
        setEditable(false);
        setContentType("text/html");
        setFont(new Font("Dialog", PLAIN, 12));
    }

    @Override
    public void updateUI()
    {
        super.updateUI();
        // Make HTML renderer use the component's font setting
        putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    }

    @Override
    public void onMetadataReceived(MetadataFrame metadataFrame)
    {
        // Refresh at most once per second
        long current = System.nanoTime();
        if ((current - previous) > 1_000_000_000)
        {
            SwingUtilities.invokeLater(() ->
            {
                StringBuilder sb = new StringBuilder();
                sb.append("<html>");
                sb.append("<head>");
                sb.append("</head>");
                sb.append("<body>");

                // TODO: handle other message types, including nested local sets
                if (metadataFrame.getMisbMessage() instanceof UasDatalinkMessage)
                {
                    sb.append("<h1>ST 0601</h1>");
                    UasDatalinkMessage uasDatalinkMessage = (UasDatalinkMessage) metadataFrame.getMisbMessage();
                    for (UasDatalinkTag tag : uasDatalinkMessage.getTags())
                    {
                        IUasDatalinkValue value = uasDatalinkMessage.getField(tag);
                        sb.append("<b>").append(tag).append(":</b> ").append(value.getDisplayableValue()).append("<br>");
                    }
                }

                sb.append("</body>");
                sb.append("</html>");
                setText(sb.toString());
            });

            previous = current;
        }
    }
}
