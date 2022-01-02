package com.example.micronaut

import jakarta.inject.Singleton

@Singleton
class PetRepository {

    private val pets: MutableList<Pet> = mutableListOf()

    fun findById(id: Int): Pet? = pets.getOrNull(id)

    fun add(pet: Pet) {
        pets.add(pet)
    }
}
