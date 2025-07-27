# Autor: Melissa Paternina

@pet
Feature: Pet Management
  As a pet store owner
  I want to manage my pet inventory
  So that I can keep track of available pets and their statuses

  Background:
    Given the pet store API is available

  Scenario: Add a new pet to the store
    When i add a new pet in the store
    Then i verify that the pet has been added
