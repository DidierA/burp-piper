This directory contains files to check behavior of Piper with different encoded files
+ utf-8.html : created with vs code, UTF-8, no BOM - reproduces the bug 
+ UTF-8-test.txt : retrieved from https://www.cl.cam.ac.uk/~mgk25/ucs/examples/UTF-8-test.txt , no modification - does not reproduce the bug
+ UTF-8-test.html : copy of the previous - does not reproduce the bug
+ UTF-8-test-saved.html : previous file opened in vs code, and saved as UTF-8, no BOM. There are differences with the original, some sequences have been replaced with U+FFFD (Replacement character), meaning vs code could not interpret these - reproduces the bug.
+ UTF8-test-truncated.txt : previous file with tests 2.1.5 and below removed (using dd to exclude any modification by vs code) - reproduces the bug.

The rendering in Burp viewer itself is different between all variations of UTF-8-test: the greek word near the begining is rendered correctly only with UTF-8-test-saved.html and UTF8-test-truncated.txt.

Maybe there is some sort of detection in burp, so that if it will assume the content is utf-8 encoded (and triggering the bug in Piper), and if decoding fails it wil revert to 'default' encoding.