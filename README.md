# MeFit
This application consists of this backend and a separate frontend, the backend is a Spring boot project
built with gradle, and a PostgreSQL database built with JPA and Hibernate.

MeFit is a concept fitness app where you are able to set up weekly workout goals and mark individual
exercises as done as you complete them over the course of a week.

[Frontend](https://naughty-kowalevski-13870d.netlify.app/login)

## Table of contents

- [Background](https://github.com/Epiko1994/MeFitBackend/tree/readme#background)
- [A Primer on URIs](https://github.com/Epiko1994/MeFitBackend/tree/readme#a-primer-on-uris)
- [Install](https://github.com/Epiko1994/MeFitBackend/tree/readme#install)
- [Online Deployment](https://github.com/Epiko1994/MeFitBackend/tree/readme#online-deployment)
- [Maintainers](https://github.com/Epiko1994/MeFitBackend/tree/readme#maintainers)
- [License](https://github.com/Epiko1994/MeFitBackend/tree/readme#license)
- [Code Standards](https://github.com/Epiko1994/MeFitBackend/tree/readme#code-standards)

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

## Commit standard

### When to commit


### Commit structure
#### Try to keep titles short, try to keep it under 40 characters
- Added feature
- Fixed feature
- Updated feature


## Licenses

This project is licensed under the standard [MIT](https://choosealicense.com/licenses/mit/) license.