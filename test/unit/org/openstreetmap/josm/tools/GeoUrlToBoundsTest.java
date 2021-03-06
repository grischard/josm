// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.tools;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests of {@link GeoUrlToBounds} class.
 */
class GeoUrlToBoundsTest {

    /**
     * Tests parsing Geo URLs with the zoom specified.
     */
    @Test
    void testParse() {
        assertThat(
                GeoUrlToBounds.parse("geo:12.34,56.78?z=9"),
                is(OsmUrlToBounds.positionToBounds(12.34, 56.78, 9))
        );
    }

    /**
     * Tests parsing Geo URLs without the zoom parameter.
     */
    @Test
    void testParseWithoutZoom() {
        assertThat(
                GeoUrlToBounds.parse("geo:12.34,56.78"),
                is(OsmUrlToBounds.positionToBounds(12.34, 56.78, 18))
        );
        assertThat(
                GeoUrlToBounds.parse("geo:-37.786971,-122.399677"),
                is(OsmUrlToBounds.positionToBounds(-37.786971, -122.399677, 18))
        );
    }

    /**
     * Tests parsing Geo URLs with a CRS and/or uncertainty.
     */
    @Test
    void testParseCrsUncertainty() {
        assertThat(
                GeoUrlToBounds.parse("geo:60.00000,17.000000;crs=wgs84"),
                is(OsmUrlToBounds.positionToBounds(60.0, 17.0, 18))
        );
        assertThat(
                GeoUrlToBounds.parse("geo:60.00000,17.000000;crs=wgs84;u=0"),
                is(OsmUrlToBounds.positionToBounds(60.0, 17.0, 18))
        );
        assertThat(
                GeoUrlToBounds.parse("geo:60.00000,17.000000;u=20"),
                is(OsmUrlToBounds.positionToBounds(60.0, 17.0, 18))
        );
    }

    /**
     * Tests parsing invalid Geo URL.
     */
    @Test
    void testInvalid() {
        assertThat(GeoUrlToBounds.parse("geo:foo"), nullValue());
        assertThat(GeoUrlToBounds.parse("geo:foo,bar"), nullValue());
    }

    /**
     * Tests parsing null.
     */
    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> GeoUrlToBounds.parse(null));
    }
}
