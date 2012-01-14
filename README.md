RemoteControlServer
=====

RemoteControlServer is the server half of a blind VNC project. A user will be able to run the server on a computer, and locally be able to send it mouse event, keyboard event, and mouse movement data. 

Protocol
========

This server uses a TCP socket to receive commands from a remote client. Each line (denoted by a line feed character) starts with a command name, a colon, and arguments. Here are the commands that are currently supported:

* Mouse move event - move:x,y
* Mouse click event - mouse:MouseEvent
* Keyboard event - key:KeyCode

License
========

Though I wrote this code in somewhat peace and harmony of mind, in the case that it is used for purposes of evil, like controlling the laptop during a school assembly, it's not my fault. Okay? Good, now that we're done with that, I can go take a shower.
