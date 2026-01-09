Implement a help desk ticketing system to manage help requests and support personnel. Help requests are categorized, and personnel respond according to their point levels.
Available Categories (enum structure):

InformationTechnologies
HumanResources
Accounting
Sales
Marketing
Legal

Implement the following classes:

Employee class
Properties: FullName (string), PointLevel (int), AssignedCategories (List)
Constructor to initialize all properties

Ticket class
Properties: Id (int), Name (string), Category (string), Point (int), AssignedEmployee (string), IsCompleted (bool)
The constructor initializes the first 4 properties

HelpDesk class
Properties: Employees (List), Tickets (List)
Methods:
AddTicket: Add a ticket to the Tickets list
AddEmployee: Add an employee to the Employees list
CompleteTicket: Mark a ticket as completed if conditions are met
GetWaitingTicketCount: Return the count of incomplete tickets
GetCompletedTicketsTotalPoint: Return sum of points for completed tickets
GetTicketsTotalPointByCategory: Return list of (category, total points) tuples
GetTicketsTotalPointByEmployee: Return list of (employee name, total points) tuples



The CompleteTicket method takes the employee's full name and the ticket ID. A ticket can be marked as completed only if:

The employee is assigned to the ticket's category (i.e., the category is in their AssignedCategories list).
The employee's PointLevel is greater than or equal to the ticket's Point.
If conditions are met, set IsCompleted to true and set AssignedEmployee to the employee's full name. Tickets can be attempted multiple times by different employees, but once completed, they stay completed. If conditions are not met, the ticket remains incomplete.

Input Format:

First line: Integer N (number of employees)
Next N lines: Employee details in the format "FullName,PointLevel,Category1 Category2 ..." (categories separated by spaces, if any)
Next line: Integer M (number of tickets)
Next M lines: Ticket details in the format "Id,TicketName,Category,Point"
Next line: Integer Q (number of queries)
Next Q lines: Query in the format "EmployeeFullName,TicketId" (attempts to complete the specified ticket by the employee)

Output Format:

"WaitingTicketCount:" followed by the count of waiting (incomplete) tickets
"CompletedTicketsTotalPoint:" followed by the sum of points of completed tickets
"TicketsTotalPointByCategory:"
Followed by lines for each category in order (InformationTechnologies, HumanResources, Accounting, Sales, Marketing, Legal): "Category:TotalPoints" (total points across all tickets in that category, completed or not)
"TicketsTotalPointByEmployee:"
Followed by lines for each employee in the order they were added: "FullName:TotalPoints" (total points from completed tickets assigned to them)

Sample Case 0
Input:
2
John Doe,1,HumanResources InformationTechnologies
Jane Cherry,6,Legal InformationTechnologies
3
1,Ticket1,InformationTechnologies,1
2,Ticket2,HumanResources,5
3,Ticket3,Legal,2
4
John Doe,3
John Doe,1
Jane Cherry,2
Jane Cherry,3
Explanation:

John Doe (level 1, covers HR and IT) attempts Ticket 3 (Legal, 2): Does not cover Legal, level 1 < 2, not completed.
John Doe attempts Ticket 1 (IT, 1): Covers IT, level 1 >= 1, completed.
Jane Cherry (level 6, covers Legal and IT) attempts Ticket 2 (HR, 5): Does not cover HR, not completed.
Jane Cherry attempts Ticket 3 (Legal, 2): Covers Legal, level 6 >= 2, completed.
Ticket 2 remains unaddressed.
Completed points: 1 (Ticket 1) + 2 (Ticket 3) = 3 (but note: sample output in image shows variant; adjust per exact computation).

Sample Output:
WaitingTicketCount:1
CompletedTicketsTotalPoint:3
TicketsTotalPointByCategory:
InformationTechnologies:1
HumanResources:5
Accounting:0
Sales:0
Marketing:0
Legal:2
TicketsTotalPointByEmployee:
John Doe:1
Jane Cherry:2
Sample Case 1
Employees:

John Doe (point level 2)
Jane Roe (point level 5)

Tickets:

InformationTechnologies, 3 points
HumanResources, 1 point
Legal, 3 points
Sales, 10 points
InformationTechnologies, 1 point

Queries:

John Doe, Ticket 1: Not completed (point level too low)
John Doe, Ticket 2: Completed
Jane Roe, Ticket 3: Completed
John Doe, Ticket 5: Completed

Output:
WaitingTicketCount:3
CompletedTicketsTotalPoint:5
TicketsTotalPointByCategory:
InformationTechnologies:4
HumanResources:1
Accounting:0
Sales:10
Marketing:0
Legal:3
TicketsTotalPointByEmployee:
John Doe:2
Jane Roe:3
Note: Assume categories are exact strings as listed. Implement in Java, handling input from standard input and output to standard output.
