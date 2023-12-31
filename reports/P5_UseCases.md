# Use Cases

## **View Company Qualifications**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Wants to succesfully view the qualifications the company has.\
**Pre-Conditions:** Application connected to company database. Company has workers with qualifications.\
**Post-Conditions:** Clicklist with qualifications displayed for Application User.

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Qualifications Tab | Loads Qualifications Page |

### **Alternative Success Scenario**
N/A

## **View company employed worker**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Wants to succesfully view the workers empoyed by the company.\
**Pre-Conditions:** Application connected to company database. Company has workers.\
**Post-Conditions:** Clicklist with qualifications displayed for Application User.

### **Main Success Scenario** 
| User Action | System Response |
|--|--|
| Click on Workers Tab | Loads Workers Page |

### **Alternative Success Scenario**
N/A

## **View company projects**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Wants to successfully view all projects in company, regardless of status.\
**Pre-Conditions:** Application connected to company database and populated with projects. \
**Post-Conditions:** Clicklist with projects displayed for application user. 

### **Main Success Scenario** 
| User Action | System Response |
|--|--|
| Click on Projects Tab | Loads Projects Page |
### **Alternative Success Scenario**
N/A

## **View qualification details.**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Wants to successfully view all qualifications in company.\
**Pre-Conditions:**  Application connected to company database and populated with qualifications. \
**Post-Conditions:** Clicklist with qualifications displayed for application user. 

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Qualifications tab | Loads Qualifications Page |
| Click on qualification | Clicklist displays qualification details|

### **Alternative Success Scenario**
N/A

## **View worker details.**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Wants to successfully view all worker details\
**Pre-Conditions:**  Application connected to company database and populated with workers. \
**Post-Conditions:** Clicklist with workers displayed for application user

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on qualifications tab | Loads qualifications page |
| Click on worker | Clicklist displays qualification details |

### **Alternative Success Scenario**
N/A

## **View project details.** 
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Wants to view specific project details\
**Pre-Conditions:**  Application connected to DB, Projects page loaded, specific project clicked on\
**Post-Conditions:** Clicklist expands to show additional details about project

### **Main Success Scenario** 
| User Action | System Response |
|--|--|
| Click on projects tab | Loads projects page|
| Click on Project | Clicklist displays project details |

### **Alternative Success Scenario**
N/A

## **Create new qualification.**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Needs to add a qualification to the Company\
**Pre-Conditions:** Application connected to DB, Qualifications page is loaded, user enters new qualification into textbox, clicks enter \
**Post-Conditions:** Qualification request sent to server and added to Company

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Enter new qualification and submit | Posts new qualification to server and re-renders component |
### **Alternative Success Scenario**
N/A

## **Create new worker.** 
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application Users, wants to add a worker to the company\
**Pre-Conditions:**  Appliction is connected to the database and the database is populated with qualifications.\
**Post-Conditions:** Worker is added to the company.

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Workers Tab | Navigates user to the Workers Page |
| Enter Worker Name, select a qualification for the worker, and input worker salary in the appropriate boxes above the list of workers on the workers page. | Posts a new worker to the server, creates a pop up stating said worker has been created, and re-renders the component |

### **Alternative Success Scenario**
N/A

## **Create new project.** 
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - wants to create a new project\
**Pre-Conditions:**  Applicaiton is connected to the database and database is populated with workers and qualifications. \
**Post-Conditions:** A new project is created.

### **Main Success Scenario** 
| User Action | System Response |
|--|--|
| Click on the project tab | Project page is displayed |
| TODO | |
### **Alternative Success Scenario**
N/A

## **Assign worker**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - assign worker to project in the company. \
**Pre-Conditions:** Only workers from the pool of available workers can be assigned as long as they are not already assiged to the same project. The project must not be in the ACTIVE or FINISHED state. The worker should not get overloaded by adding to this project. The worker can be added only if the worker is helpful to the project (i.e., meets at least one missing qualifications). If the conditions are satisfied, (1) the assigned worker is added to the pool of assiged workers of the company unless they were already present in that pool, and (2) the worker is also added to the project. Check if the worker should be moved out of the available pool.  \
**Post-Conditions:** Worker is assigned to the project. 

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Projects Page | Client loads Projects page |
| Dropdown Project list at top of page | List of projects appears |
| Click project to assign worker to | Project is selected |
| Dropdown Worker list at top of page | List of workers appears |
| Click worker to assign | Worker is selected |
| Click "Assign a Worker" | Worker is added to project and success message appears |

### **Alternative Success Scenario**
N/A

## **Unassign worker**
**Primary Actor:** Application User \
**Stakeholders and Interests:**  \
**Pre-Conditions:** The worker must have been assiged to the project to be unassigned. If this was the only project for the worker, then delete this worker from the pool of assigned workers of the company. Also think about other situations for the available and assigned pools. If the qualification requirements of an ACTIVE project are no longer met, that project is marked SUSPENDED. A PLANNED OR SUSPENDED project remains in that state.\
**Post-Conditions:** Worker is unassigned form project and the project possibly changes into suspended.

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Projects Page | Client loads Projects page |
| Dropdown Project list at top of page | List of projects appears |
| Click project to unassign worker from | Project is selected |
| Dropdown Worker list at top of page | List of workers appears |
| Click worker to unassign | Worker is selected |
| Click "Unassign a Worker" | Worker is removed from project and success message appears |

### **Alternative Success Scenario**
N/A

## **Start project**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Be able to take a planned project and start it.\
**Pre-Conditions:** Project is planned or suspended. \
**Post-Conditions:** Project is now in a active state.

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Projects Page | Client loads Projects page |
| Dropdown Project list at top of page | List of projects appears |
| Select project to start | Project is selected |
| Click "Start Project" | Project is started and success message appears |

### **Alternative Success Scenario**
N/A

## **Finish project**
**Primary Actor:** Application User \
**Stakeholders and Interests:** Application User - Be able to take and active project and finish said project.\
**Pre-Conditions:**  Project must be active. \
**Post-Conditions:** If project is active, and qualifications are met then the project is finished. Otherwise visual feedback for era is shown. 

### **Main Success Scenario**
| User Action | System Response |
|--|--|
| Click on Projects Page | Client loads Projects page |
| Dropdown Project list at top of page | List of projects appears |
| Select project to finish | Project is selected |
| Click "Finish Project" | Project is finished and success message appears |

### **Alternative Success Scenario**
N/A
