#!/usr/bin/env groovy

/**
 * Simple wrapper for sauce connect
 * Have to wrap sauceconnect in a script block
 * https://issues.jenkins-ci.org/browse/JENKINS-41236
 */
 def testWithSauceConnect(
      List<String> platform_configs = [
                            'chrome',
                            'firefox',
                            'ie',
                            'edge'
                        ]) {
    // Add sauce credentials
    sauce('f0a6b8ad-ce30-4cba-bf9a-95afbc470a8a') {
        // Start sauce connect
        sauceconnect(options: '', useGeneratedTunnelIdentifier: false, verboseLogging: false) {
           // Run selenium tests using Nightwatch.js
           // Ignore error codes. The junit publisher will cover setting build status.
           sh "./node_modules/.bin/nightwatch -e ${platform_configs.join(',')} --test tests/guineaPig.js || true"
         }
     }
 }
