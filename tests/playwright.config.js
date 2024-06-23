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
      command: `cd .. && cd frontend && npm start`,
      url: 'http://localhost:3000',
      timeout: 500 * 1000,
      reuseExistingServer: !process.env.CI,
    },
  ],
};
