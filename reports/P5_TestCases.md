# Test Cases

## View company qualifications
| Test Case: Create Qualification and view it | Use Case Used |
|--|--|
| Navigate to Qualification tab | View Company Qualifications |
| Check that Qualification to be added is not currently in list | View Company Qualifications | 
| Type new Qualification into text box | Create New Qualification |
| Click "Create Qualification" | Create New Qualification |
| Alert appears, Click "OK" | |
| Observe that new Qualification has been added | View Company Qualifications |

## View company employed worker
| Test Case: Create Worker and view it | Use Cases Used |
|--------------|---------------------|
| Clicks on on the workers tab | view employed workers |
| Checks to see that worker is not alrady employed| view employed workers |
| Inputs "Steven Thomson" into the name field| -- |
| Selects the Angular and Cyber Security qualifications| -- |
| Inputs "18000" in the salary field | -- |
| Clicks Employe worker | create new worker |
| Clicks on the worker in the click list| view worker details |

## View company projects
| Test Case: Create Project and view it | Use Case Used |
|--|--|
| Navigate to Projects tab | View Company Projects |
| Check that Project to be added is not currently in list | View Company Project | 
| Type new Project into text box | Create New Project |
| Click "Create Project" | Create New Project |
| Alert appears, Click "OK" | |
| Observe that new Project has been added | View Company Projects |

## View qualification details
|Test Case: Create and view a qualificaiton| Use Case Used|
|--|--|
| User clicks on qualification tab | view company qualifications |
| User imputs "R" into the "Add Qualification" field | -- |
| User clicks on added qualification | View qualificaiton details|

## View worker details
| Test Case: Create Worker and view it | Use Cases Used |
|--------------|---------------------|
| Clicks on the workers tab | view employed workers |
| Inputs "Alexander Volkanovski" into the name field| -- |
| Selects the Java and TypeScript qualifications| -- |
| Inputs "11000" in the salary field | -- |
| Clicks "Employ worker" | create new worker |
| Clicks on the worker in the click list| view worker details |

## View project details
| Test Case: View an existing projects details | Use Cases Used |
|--------------|---------------------|
| Clicks on the Projects tab| View project details|
| User clicks on the 'Android Task Monitoring' in the clicklist | View project details |
| User verifies the project details meet the following:| -- |
|Name: Android Task Monitoring|  |
|Size: SMALL|  |
|Status: PLANNED|  |
|Assigned Employees: Erika Johnston, Terry Hampton, Benjamin Guzman|  |
|Required Qualifications: Java, MongoDB, Spring, Sql|  |
|Missing Qualifications:|  |

## Create new qualification
| Test Case: Create and view a new Qualification | Use Cases Used |
|--------------|---------------------|
| User clicks on Qualifications Tab | view qualification details |
| User enters 'c++' in the text box next to the text "Add Qualification" | create new qualification |
| User clicks the Create Qualification Button | create new qualification |
| User clicks on new Qualification in the Click List of Qualifications and verifies the Workers: list is empty | -- |

## Create new worker
| Test Case: Create and view a new Worker | Use Cases Used |
|--------------|---------------------|
| User clicks on the Workers Tab | create new worker |
| User types 'John Stamos' into the name box | create new worker |
| (Hold down CTRL(COMMAND on Mac) while clicking quals from the list to select multiple) User selects Java & Javascript from the list of Qualifications | create new worker  |
| User types in a salary of '100000' into the Salary box | create new worker |
| User clicks the employ worker button | create new worker |
| User now finds 'John Stamos' in the list of workers, clicks on him, and verifies that all the information about him is as previously mentioned. | -- |

## Create new project

## Assign worker
| Test Case: Assign worker and view it | Use Cases Used |
|--------------|---------------------|
| Clicks on Projects tab | view company projects |
| Selects "Android Task Monitoring" from bottom-most dropdown menu| -- |
| Selects "Terry Hampton" from dropdown to the right of above dropdown| -- |
| Clicks "Assign a Worker" button | assign worker |
| Clicks "Android Task Monitoring" tab from click list | view project details |
| Confirms worker has been added to project| assign worker |

## Unassign worker
| Test Case: Unassign worker and view it | Use Cases Used |
|--------------|---------------------|
| Clicks on Projects tab | view company projects |
| Selects "Credit Card Fraud Detection" from bottom-most dropdown menu| -- |
| Selects "Jamie Burgess" from dropdown to the right of above dropdown| -- |
| Clicks "Unassign a Worker" button | unassign worker |
| Clicks "Credit Card Fraud Detection" tab from click list | view project details |
| Confirms worker has been removed from project| unassign worker |

## Start project
| Test Case: Start Project and view it. Valid Start | Use Cases Used |
|--|--|
| User clicks on Projects tab | View Project Details |
| User clicks on project in clicklist to verify that it is not currently started | View Project Details |
| User selects project from dropdown that they would like to start | Start Project |
| User clicks "Start Project" option | Start Project |
| Project alert appears verifying success | Start Project |
| User clicks on Project in Clicklist to verify that it has started | View Project Details |

| Test Case: Start Project and view it. Invalid Start | Use Cases Used |
|--|--|
| User clicks on Projects tab |View Project Details |
| User click on project in clicklist to verify that it is currently finished | View Project Details |
| User selects project from drowndown that they would like to start | Start Project |
| User clicks "Start Project" option | Start Project |
| Project alert appears indicating an error | Start Project |
| User clicks on Project in clicklist to verify that status has not changed | View Project Details |

## Finish project 
| Test Case: Finish Project and view it | Use Cases Used |
|--|--|
| User clicks on Projects tab | View Project Details |
| User clicks on project in clicklist to verify that it is not currently finished | View Project Details |
| User selects project from dropdown menu that they would like to finish | Finish Project |
| User clicks "Finish Project" option | Finish Project |
| Project alert appears verifying success | Finish Project |
| User clicks on Project in Clicklist to verify that it has finished | View Project Details |
| Test Case: Finish Project and view it | Use Cases Used |

| Test Case: Whole Project Lifecycle | Use Cases Used |
|--|--|
| User creates new Project | New Project appears in Clicklist |
| User clicks on new Project | ProjectStatus is Planned |
| User assigns relevant workers | Qualifications Met |
| User starts project | Project is Active |
| User selects project from dropdown menu that they would like to finish | Finish Project |
| User clicks "Finish Project" option | Finish Project |
| Project alert appears verifying success | Finish Project |
| User clicks on Project in Clicklist to verify that it has finished | View Project Details |
