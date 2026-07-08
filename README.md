# CSCI 1112 Music Catalog

This project implements a music catalog data structure two ways behind a shared MusicCatalog interface: a dynamic array (ArrayList) and a singly linked list (LinkedList). It was written for GWU CSCI 1112 in Spring 2025.

## What I wrote

I implemented ArrayList.java and LinkedList.java, the two concrete catalog implementations behind the MusicCatalog interface. Both support adding a song, removing the first song or a specific song, checking membership, clearing the catalog, indexed retrieval, and reporting the earliest and most recent release years through publish. ArrayList backs the catalog with a resizable array that doubles in size whenever it runs out of room, while LinkedList backs it with a singly linked chain of nodes tracked by a head pointer. Both implementations pass all of the course's unit tests.

## Provided scaffolding (not my code)

MusicCatalog.java (the shared interface), Song.java, CatalogItem.java, CatalogHelper.java, UnitTests.java, and UseCases.java were provided by the course. I did not write these files.

## Running it

UnitTests.main runs the full unit test suite against both the ArrayList and LinkedList implementations and reports a pass or fail for each. UseCases.main walks through a few typical interactions, like adding songs, publishing a catalog, and searching for a song, against both implementations.
