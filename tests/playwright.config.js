const path = require('path');

module.exports = {
    testDir: './tests/e2e',
    use: {
        browserName: 'chromium',
        headless: true,
        baseURL: 'http://localhost:3000',
    },
    webServer: [
        {
            command: `cd '../backend' && mvn spring-boot:run`,
            url: 'http://localhost:8080',
            timeout: 500 * 1000,
            reuseExistingServer: !process.env.CI,
            env: {
                JAVA_HOME: process.env.JAVA_HOME,
                MAVEN_HOME: process.env.MAVEN_HOME
            }
        },
        {
            command: `cd ../frontend' && npm start`,
            url: 'http://localhost:3000',
            timeout: 500 * 1000,
            reuseExistingServer: !process.env.CI,
        },
    ],
};
