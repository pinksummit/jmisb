package org.jmisb.api.klv.st0601;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlatformAngleOfAttackFullTest
{
    @Test
    public void testMinMax()
    {
        PlatformAngleOfAttackFull platformAngleOfAttackFull = new PlatformAngleOfAttackFull(-90.0);
        byte[] bytes = platformAngleOfAttackFull.getBytes();
        Assert.assertEquals(bytes, new byte[]{(byte)0x80, (byte)0x00, (byte)0x00, (byte)0x01});
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), -90.0);

        platformAngleOfAttackFull = new PlatformAngleOfAttackFull(90.0);
        bytes = platformAngleOfAttackFull.getBytes();
        Assert.assertEquals(bytes, new byte[]{(byte)0x7f, (byte)0xff, (byte)0xff, (byte)0xff});
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), 90.0);

        bytes = new byte[]{(byte)0x80, (byte)0x00, (byte)0x00, (byte)0x01};
        platformAngleOfAttackFull = new PlatformAngleOfAttackFull(bytes);
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), -90.0);
        Assert.assertEquals(platformAngleOfAttackFull.getBytes(), bytes);

        bytes = new byte[]{(byte)0x7f, (byte)0xff, (byte)0xff, (byte)0xff};
        platformAngleOfAttackFull = new PlatformAngleOfAttackFull(bytes);
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), 90.0);
        Assert.assertEquals(platformAngleOfAttackFull.getBytes(), bytes);
    }

    @Test
    public void testOutOfBounds()
    {
        PlatformAngleOfAttackFull platformAngleOfAttackFull = new PlatformAngleOfAttackFull(Double.POSITIVE_INFINITY);
        byte[] bytes = platformAngleOfAttackFull.getBytes();
        Assert.assertEquals(bytes, new byte[]{(byte)0x80, (byte)0x00, (byte)0x00, (byte)0x00});
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), Double.POSITIVE_INFINITY);

        bytes = new byte[]{(byte)0x80, (byte)0x00, (byte)0x00, (byte)0x00};
        platformAngleOfAttackFull = new PlatformAngleOfAttackFull(bytes);
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), Double.POSITIVE_INFINITY);
        Assert.assertEquals(platformAngleOfAttackFull.getBytes(), bytes);
    }
    
    @Test
    public void stExample()
    {
        double degrees = -8.6701769841230370;
        byte[] expected = new byte[]{(byte)0xf3, (byte)0xab, (byte)0x48, (byte)0xef};

        // Create from value
        PlatformAngleOfAttackFull platformAngleOfAttackFull = new PlatformAngleOfAttackFull(degrees);
        byte[] bytes = platformAngleOfAttackFull.getBytes();
        Assert.assertEquals(bytes, expected);
        Assert.assertEquals(platformAngleOfAttackFull.getDegrees(), degrees);

        // Create from bytes
        platformAngleOfAttackFull = new PlatformAngleOfAttackFull(expected);
        double value = platformAngleOfAttackFull.getDegrees();
        Assert.assertEquals(value, degrees);
        Assert.assertEquals(platformAngleOfAttackFull.getBytes(), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTooSmall()
    {
        new PlatformAngleOfAttackFull(-90.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTooBig()
    {
        new PlatformAngleOfAttackFull(90.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badArrayLength()
    {
        new PlatformAngleOfAttackFull(new byte[]{0x00, 0x01});
    }
}
