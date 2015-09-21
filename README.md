# selfUpdating
This Apache Wicket 7.0.0 quickstart shows how to fix the problem the where AjaxSelfUpdatingTimerBehavior breaks browser refresh.
Originally, the Label (org.apache.wicket.markup.html.basic.Label) that wasn't updating had a value for its model, like this:
```
add(
      new Label("myCounter", 
          w.getCounter().get()      // THE PROBLEM
          ));
```
To fix this, I had to pass an actual IModel that retrieved my label, like this:
```
			add( new Label("myCounter", 
			counterModel                  // THE FIX
			) );					
```

## The Problem

I added AjaxSelfUpdatingTimerBehavior to this wicket quickstart and it works just fine.
However, only a few pieces of data on this page will get auto-updated.  For the rest of the data, the user needs to do a browser fresh 
but the AjaxSelfUpdatingTimerBehavior keeps that refresh from working like I need it to.

The home page url shows a counter (that starts and 23) and a java timestamp that refreshes itself every 2 seconds using AjaxSelfUpdatingTimerBehavior:
```
http://localhost:8080/selfUpdating/
```

The following different URL invokes a servlet that increments the counter stored in an AtomicInteger in Application scope:
```
http://localhost:8080/selfUpdating/increment
```
Here is the output that you see in the browser:
```
New count is [24]
```

But if you refresh the original page (I've tried chrome and safari), you're stuck with a counter value of 23....you don't get to see the incremented value.

I've found two workarounds to display the incremented counter value, neither of which are acceptable.
The first is to open a separate browser tab or window.
The second is to comment out the following line in HomePage.java:
```
label.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
```

Any suggestions for how to get the browser refresh to work with a AjaxSelfUpdatingTimerBehavior?
Thanks,
--Erik Ostermueller

