import { announce } from '@vaadin/a11y-base/src/announce.js';

window.announce = function(text, mode, timeout) {
  const options = {mode: mode, timeout: timeout};
  announce(text, options);
}
