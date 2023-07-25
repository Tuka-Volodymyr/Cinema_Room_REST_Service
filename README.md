# Welcome to Cinema-Seat-Booking: A Play in Three Acts

Have you ever wanted to run your own cinema, but found yourself constrained by lack of a physical building or any sort of financial backing? Fear not, digital impresario, for I present to you Cinema-Seat-Booking, the RESTful drama in Java that lets you simulate running your very own cinema...all without leaving the comfort of your development environment.

## Act I: The Seating Plan

Our `Cinema` is a cozy place, containing 9 rows with 9 seats each (but you can resize it at will). Check the seating plan by calling `GET /seats`. It's all listed there, every row and column of seating available for your perusal. 

## Act II: The Purchase

When our patrons wish to secure their spot for the performance, they'll perform a `POST /purchase`, passing in the row and column of their desired seat. Our diligent usher will then check to see if the seat is available, and if it is, voila! A `Ticket` is created and returned to the patron, complete with a unique token, and the seat is marked as occupied. But be warned! If the seat is already occupied or doesn't exist, a polite (yet firm) refusal will be issued.

## Act III: The Return

Ah, the show must go on... but sometimes, a patron's plans do not. That's when they perform a `POST /return`, providing the token of their now-unwanted `Ticket`. Our helpful usher marks the seat as available again and a refund is issued. Should the token prove invalid, alas, no refund can be issued.

## Encore: Stats

Finally, there's the encore - an optional performance for those privy to the super secret password (which, between you and me, is `super_secret`). Invoke `GET /stats` with the aforementioned password, and behold a glimpse into the state of your cinema: current income, number of available seats, and number of purchased tickets!

Cinema-Seat-Booking is an exercise in elegant simplicity, a dance of requests and responses that allows you to manage a Cinema with ease. And just like a great Cinema performance, every request and response has been carefully rehearsed to provide the best experience for all involved. 

So dim the lights, open the curtains, and let the show begin!
