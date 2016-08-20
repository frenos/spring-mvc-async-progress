# spring-mvc-async-progress
---
A sample project to show long running jobs asynchronous in the background with spring-mvc while also having a progress overview.

![Screenshot](https://github.com/frenos/spring-mvc-async-progress/raw/master/screenshot.png)

This project uses:
* spring-boot
* spring-mvc
* jQuery
* Bootstrap

---
**Consider**: The status update is currently done by constantly polling the server and the response is very basic by sending 
everything on each request.

**Disclaimer**: Please only use this as a starting point for your own research, don't just copy/paste :).
