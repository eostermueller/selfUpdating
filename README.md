# selfUpdating
This is an Apache Wicket quickstart where AjaxSelfUpdatingTimerBehavior breaks browser refresh.

I added AjaxSelfUpdatingTimerBehavior to this wicket quickstart and it works just fine.
However, browser refresh no longer works like I need it to.

The home page url shows a counter (that starts and 23) and a java timestamp that refreshes itself every 2 seconds using AjaxSelfUpdatingTimerBehavior:
```
http://localhost:8080/selfUpdating/
```

The following different URL invokes a servlet that increments the counter stored in an AtomicInteger in Application scope:
```
http://localhost:8080/selfUpdating/increment
```

But if you refresh the original page, you're stick with a counter value of 23....you don't get to see the incremented value.

I've found two workarounds to display the incremented counter value, neither of which are acceptable.
The first is to open a separate browser tab or window.
The second is to comment out the following line in HomePage.java:
```
label.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
```

Any suggestions for how to get around this?
Thanks,
--Erik Ostermueller

