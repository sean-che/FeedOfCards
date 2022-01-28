## Task
### Description:
Design and implement a REST API to return a feed of "cards" - a simple JSON representation of the payload is sufficient.

Cards can be of different types and include different values. Please implement the below logic:

* <B> Daily quote card </B> - will show a different quote every day. the list of quotes will be stored in the database or a file for this exercise. The card will include:

  * Title - "Daily Quote"
  * Message - the quote content. You can use "quote1", "quote2", "quote3" for the exercise.
  * Author - the author of the daily quote. You can use "author1", "author2", etc.

* <B> Status update card </B> - will be used to show updates to customers. This card will include:
    
    * Title - String - "Important Security Update"
    * Icon - String - e.g. https://tinyurl.com/y5mdph2g
    * Message - String - e.g. "For your security, we support 2 factor authentication, and would recommend that you turn it on."
    * Button - String - e.g. "Got it, thanks"


Each card type can have multiple implementations.

Each implementation will allow for a pre-defined condition to determine whether the card should be presented to a given customer. 

E.g. if the number of seconds on the request timestamp is even, show. Else - do not show the card to this customer.


## Questions

1. How to select the quote for a day: Is it predefined for each day? 365 quotes? Or just repeat all existing quotes in specific order.
2. How to decide that the card was already shown to the customer: Is it enough just to call getStatusCard endpoint? Or we need to have another endpoint to mark card as "already displayed".
3. How to determine which implementation should be used for each request? Is it something we need to implement in our application or just different endpoints and client will decide which one to use?