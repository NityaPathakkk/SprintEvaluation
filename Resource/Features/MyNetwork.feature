
Feature: To test the functionality of Mynetwork pageS
Background:
Given User is logged In and is on home page
|nitya.pathak19@gmail.com|Nitya@2001~|

@Event
Scenario: My Network Functionality
When User clicks on Event icon on home page
And User enters the Event name
And User clicks on Next button
Then User clicks on post button

@Sorting
Scenario: Connection Sorting Functionality
When User clicks on My Network icon
And Clicks on Connection option
And Clicks on sort by drop down 
Then Clicks on Recently added

@RepostEvent
Scenario: Repost Event Functionality
When User clicks on My Network icon1
And Clicks on Event option
And Clicks on previous events
And Clicks on Share button 
And Click on Repost this post
And Enter the data
Then Post the event on your feed

@Schedule
Scenario: Schedule an event
When User clicks on My Network 
And clicks on Event 
And clicks on Create button
And Enter <name> of event
And click on next
Then click on Schedule button

Examples:
|name|
|"Hello"|

@Invite
Scenario: Invite to Event
When User clicks on My Network icon2
And Clicks on Event options
And Clicks on previous events name
And Clicks on Share button1 
And Clicks on Invite
Then Enter <CmpName>
Examples:
|CmpName|
|"IBM"|
