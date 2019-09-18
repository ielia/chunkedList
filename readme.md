# Chunked List Data Structure
This project is so you start coding different data structures.

The data structure you'll have to implement consists of a linked
list of primitive arrays. The current "last chunk" will get
filled up to the specified (or default, if no specification)
maximum occupancy percentage. Inserting in the middle of the list
will result in inserting elements into the incomplete chunks or
adding new chunks in the middle of the list. Deleting will also
result in modifications to the linked list, so if a chunk ends up
empty, then it will be removed completely.

Unit tests are provided for a TDD approach. Please take good
advantage of them.

This skeleton TDD project has been coded in a night, so if you
find any issues with it, please let me know.

## Goals
* Implement data structure.
* Fix unit tests.

## Requirements
* JDK 1.8+
* Maven

## Unit Tests Execution
```
mvn test
```

## Site Compilation
Site comprises loads of information about the current project,
including unit test report, coverage report, javadoc, etc.
```
mvn site
```
