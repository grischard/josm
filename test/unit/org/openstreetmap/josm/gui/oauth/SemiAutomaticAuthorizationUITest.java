// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.gui.oauth;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.Test;
import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.testutils.JOSMTestRules;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Unit tests of {@link SemiAutomaticAuthorizationUI} class.
 */
class SemiAutomaticAuthorizationUITest {

    /**
     * Setup tests
     */
    @RegisterExtension
    @SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD")
    public JOSMTestRules test = new JOSMTestRules().preferences();

    /**
     * Unit test of {@link SemiAutomaticAuthorizationUI#SemiAutomaticAuthorizationUI}.
     */
    @Test
    void testSemiAutomaticAuthorizationUI() {
        assertNotNull(new SemiAutomaticAuthorizationUI("", MainApplication.worker));
    }
}
