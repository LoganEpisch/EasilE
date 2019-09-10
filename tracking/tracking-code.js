var keypress = require('keypress');

// make `process.stdin` begin emitting "mousepress" (and "keypress") events
keypress(process.stdin);

// you must enable the mouse events before they will begin firing
keypress.enableMouse(process.stdout);

process.stdin.on('mousepress', function (info) {
  console.log('got "mousepress" event at %d x %d', info.x, info.y);
});

process.on('exit', function () {
  // disable mouse on exit, so that the state
  // is back to normal for the terminal
  keypress.disableMouse(process.stdout);
});