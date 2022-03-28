# MeFit
This application consists of this backend and a separate frontend, the backend is a Spring boot project
built with gradle, and a PostgreSQL database built with JPA and Hibernate.

MeFit is a concept fitness app where you are able to set up weekly workout goals and mark individual
exercises as done as you complete them over the course of a week.

[Frontend](https://naughty-kowalevski-13870d.netlify.app/login)

## Table of contents

- [Background](https://github.com/Epiko1994/MeFitBackend/readme#background)
- [A Primer on URIs](https://github.com/Epiko1994/MeFitBackend/readme#a-primer-on-uris)
- [Install](https://github.com/Epiko1994/MeFitBackend/readme#install)
- [Online Deployment](https://github.com/Epiko1994/MeFitBackend/readme#online-deployment)
- [Maintainers](https://github.com/Epiko1994/MeFitBackend/tree/readme#maintainers)
- [License](https://github.com/Epiko1994/MeFitBackend/readme#licenses)
- [Code Standards](https://github.com/Epiko1994/MeFitBackend/readme#code-standard)

## Background

The MeFit backend is set up to expose the PostgreSQL database via a RESTful JPA and Hibernate
API.

The backend is deployed on Heroku.

The API consists of several controllers exposing individual endpoints producing and accepting
JSON input and outputs

The [Swagger documentation UI](https://mefitbackend-ajlm.herokuapp.com/swagger-ui/index.html)
can be found via the link.

##A Primer on URIs



## Install

Gradle should automatically handle the installation of the project and its dependencies when
downloaded. 

## Online Deployment

The backend is deployed online on [Heroku](https://mefitbackend-ajlm.herokuapp.com/swagger-ui/index.html)
with a Swagger UI for documentation and test use.

## Maintainers

- [Allan Carlsen (@AllanTC)](https://github.com/AllanTC)
- [Joshua Johansen (@Epiko1994)](https://github.com/Epiko1994)
- [Liv Reinhold (@livstella)](https://github.com/livstella)
- [Michel Saremi (@MichelSaremi)](https://github.com/MichelSaremi)

## Code standard


### General
#### Long descriptive method names are better than shorter ones, EG.
##### Good:
`private void getAllCharactersById() {}`

##### Bad:
`private void GACBI() {}`

### Java
#### Curlies go on line with the method declaration

`public static void main(String[] args) {}`



## Licenses

This project is licensed under the standard [MIT](https://choosealicense.com/licenses/mit/) license.


# Project approach

### Technical tools

- GitHub - collaboration
- Netlify - Deployment and for CI/CD
- Heroku - Deployment for backend
- Swagger UI - Endpoint documentation
- Gradle - Dependency management in backend

### Project management tools

- The project is managed through Trello
- All decisions made are written on the projects Trello board
- All tasks are delegated through Trello
- GitHub
    - Main branch is a protected branch and need to pass Netlify checks and minimum 2 reviews
    - We solve our own merge conflicts before asking for reviews on out Pull Request

### Commit standard

Try to keep titles short, ideally under 40 characters
- Added feature
- Fixed feature
- Updated feature



### MVP

Decisions regarding the MVP has been made with the intention of being customer-centric towards our hypothetical customer in mind. For this project that means:

- Endpoints for displaying data (Create and Read) are prioritised over endpoints for editing data (Update and Delete)
- Being able to visually show functionality is prioritised over perfect backend structure

### Workflow / Teamwork

- The four members of the team are divided with two members on backend and frontend respectively
- Daily stand-up at 9.00
- Weekly meeting with our mentor, Livinus, Mondays at 10.00
- Continuous communication by:
    - Marking on Trello the task you are working on
    - Moving the task to "In progress" when work starts
    - Moving the task to "Done" when definition of done has been achieved
    - If a task cannot be marked as done, due to wait time on another task, it can be labelled with "needs more info"
- There are no expectation of weekend work
- We trust each-other's ability to organise one's own work, therefore we are flexible regarding work hours