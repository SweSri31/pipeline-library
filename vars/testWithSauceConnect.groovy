#!/usr/bin/env groovy

/**
 * Simple wrapper for sauce connect
 * Have to wrap sauceconnect in a script block
 * https://issues.jenkins-ci.org/browse/JENKINS-41236
 */
def call(Closure steps) {
    // Add sauce credentials
    sauce('f0a6b8ad-ce30-4cba-bf9a-95afbc470a8a') {
        // Start sauce connect
        sauceconnect(options: '', useGeneratedTunnelIdentifier: false, verboseLogging: false) {
            steps()
        }
    }
}
