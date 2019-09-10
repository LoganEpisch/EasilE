// obviously need to change at some point
exports.config = {
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['todo-spec.js']
};

// https://stackoverflow.com/questions/20023567/how-to-set-default-browser-window-size-in-protractor-webdriverjs
// set size for later