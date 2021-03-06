package org.jmisb.api.klv;

/**
 * Various constants such as Universal Labels
 */
public class KlvConstants
{
    private KlvConstants() {}

    /** Universal label for UAS Datalink Local Metadata Set (ST 0601) */
    public static UniversalLabel UasDatalinkLocalUl = new UniversalLabel(new byte[] {0x06, 0x0e, 0x2b, 0x34, 0x02, 0x0b, 0x01,
            0x01, 0x0e, 0x01, 0x03, 0x01, 0x01, 0x00, 0x00, 0x00});

    /** Universal label for Security Medatadata Set Local Set (ST 0102) */
    public static UniversalLabel SecurityMetadataLocalSetUl = new UniversalLabel(new byte[] { 0x06, 0x0e, 0x2b, 0x34, 0x02, 0x03, 0x01, 0x01,
            0x0e, 0x01, 0x03, 0x03, 0x02, 0x00, 0x00, 0x00 });

    /** Universal label for Security Medatadata Set Universal Set (ST 0102) */
    public static UniversalLabel SecurityMetadataUniversalSetUl = new UniversalLabel(new byte[] { 0x06, 0x0e, 0x2b, 0x34, 0x02, 0x01, 0x01, 0x01,
            0x02, 0x08, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00 });

    /** Universal label for Generalized Transformation Set (ST 1202) */
    public static UniversalLabel GeneralizedTransformationUl = new UniversalLabel(new byte[] { 0x06, 0x0E, 0x2B, 0x34, 0x02,
            0x0B, 0x01, 0x01, 0x0E, 0x01, 0x03, 0x05, 0x05, 0x00, 0x00, 0x00 });
}

