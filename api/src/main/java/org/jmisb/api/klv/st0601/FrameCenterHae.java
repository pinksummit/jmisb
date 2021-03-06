package org.jmisb.api.klv.st0601;

/**
 * Frame Center Height Above Ellipsoid (ST 0601 tag 78)
 * <p>
 * From ST:
 * <blockquote>
 * Frame Center Ellipsoid Height as measured from the reference WGS84 Ellipsoid.
 * <p>
 * Map 0..(2^16-1) to -900..19000 meters.
 * <p>
 * Resolution: ~0.3 meters.
 * </blockquote>
 * <p>
 * Additional note from ST:
 * <blockquote>
 * For legacy purposes, both MSL (Tag 25) and HAE (Tag 78) representations of
 * Frame Center Elevation MAY appear in the same ST 0601 packet. A single representation is preferred
 * favoring the HAE version (Tag 78).
 * </blockquote>
 * See {@link FrameCenterElevation}.
 */
public class FrameCenterHae extends UasDatalinkAltitude
{
    public FrameCenterHae(double meters)
    {
        super(meters);
    }

    public FrameCenterHae(byte[] bytes)
    {
        super(bytes);
    }
}
